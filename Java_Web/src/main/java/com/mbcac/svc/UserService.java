package com.mbcac.svc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONObject;

import com.mbcac.fio.FileIO;
import com.mbcac.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserService 
{
   private HttpServletRequest request;
   private HttpServletResponse response;
   
   public UserService(HttpServletRequest request, HttpServletResponse response) {
      this.request = request;
      this.response = response;
   }

   public String process() 
   {
      String cmd = request.getParameter("cmd");
      
      if(cmd.equals("add"))  // Create
      {
         return saveFile();
      }
      else if(cmd.equals("list"))  // Read
      {
         FileIO fio = new FileIO();
         List<User> list = fio.getList();
         request.setAttribute("list", list);   // Scope Object(forward관계에서 공유된는 오브젝트)
         return "/jsp/userList.jsp";        // forward하면 request오브젝트를 jsp에서 접근가능
      }
      else if(cmd.equals("find"))   // Read, http://localhost:8080/user?cmd=find&no=12
      {
         String sNo = request.getParameter("no");
         int no = Integer.parseInt(sNo);
         FileIO fio = new FileIO();
         User found = fio.findByNo(no);
         request.setAttribute("user", found);
         return "/jsp/userDetail.jsp";
      }
      else if(cmd.equals("edit"))
      {
         String sNo = request.getParameter("no");
         int no = Integer.parseInt(sNo);
         FileIO fio = new FileIO();
         User found = fio.findByNo(no);
         request.setAttribute("user", found);
         return "/jsp/userEditForm.jsp";
      }
      else if(cmd.equals("update"))
      {
         String sNo = request.getParameter("no");
         int no = Integer.parseInt(sNo);
         String phone = request.getParameter("phone");
         String email = request.getParameter("email");
         User key = new User();
         key.setNo(no);
         key.setPhone(phone);
         key.setEmail(email);
         FileIO fio = new FileIO();
         boolean updated = fio.update(key);
         
         JSONObject jsObj = new JSONObject();
         jsObj.put("updated", updated);
         jsObj.put("no", no);
         
         try {
            PrintWriter out = response.getWriter();
            out.print(jsObj.toJSONString());
            out.flush();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      else if(cmd.equals("delete"))
      {
         String sNo = request.getParameter("no");
         int no = Integer.parseInt(sNo);
         
         FileIO fio = new FileIO();
         boolean deleted = fio.delete(no); 
         JSONObject jsObj = new JSONObject();
         jsObj.put("deleted", deleted);

         try {
            PrintWriter out = response.getWriter();
            out.print(jsObj.toJSONString());
            out.flush();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
      return null;
   }
   
   private String saveFile()
   {
      String sNo = request.getParameter("no");
      String id = request.getParameter("id");
      String pwd = request.getParameter("pwd");
      String phone = request.getParameter("phone");
      String email = request.getParameter("email");
      int no = Integer.parseInt(sNo);
      
      User user = new User();
      user.setNo(no);
      user.setId(id);
      user.setPwd(pwd);
      user.setPhone(phone);
      user.setEmail(email);
      
      FileIO fio = new FileIO();
      boolean added = fio.addUser(user);
      JSONObject jsObj = new JSONObject();
      jsObj.put("added", added);
   
      return jsObj.toJSONString();
   }

}