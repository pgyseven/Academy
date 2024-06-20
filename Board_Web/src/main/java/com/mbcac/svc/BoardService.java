package com.mbcac.svc;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONObject;

import com.mbcac.bio.BoardIO;

import com.mbcac.vo.Board;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardService 
{
   private HttpServletRequest request;
   private HttpServletResponse response;
   
   public BoardService(HttpServletRequest request, HttpServletResponse response) {
      this.request = request;
      this.response = response;
   }

   public String process() 
   {
      String cmd = request.getParameter("cmd");
      
      if(cmd.equals("addForm"))
      {
         return "/jsp/addForm.jsp";
      }
      else if(cmd.equals("save"))
      {
         Board b = getParam();
         BoardIO bio = new BoardIO();
         boolean saved = bio.save(b);
         sendJSON("saved", saved);
      }
      else if(cmd.equals("list")) //  /board?cmd=list 
      {
         BoardIO bio = new BoardIO();
         List<Board> list = bio.getList();
         request.setAttribute("list", list);
         return "/jsp/boardList.jsp";
      }
      else if(cmd.equals("find"))   // Read, http://localhost:8080/user?cmd=find&no=12
      {
         String sNo = request.getParameter("no");
         int no = Integer.parseInt(sNo);
         BoardIO bio = new BoardIO();
         Board found = bio.findByNo(no);
         request.setAttribute("found", found);
         return "/jsp/boardDetail.jsp";
      }
      else if(cmd.equals("delete"))
      {
         String sNo = request.getParameter("no");
         int no = Integer.parseInt(sNo);
         
         BoardIO bio = new BoardIO();
         boolean deleted = bio.delete(no); 
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
      
      
      else if(cmd.equals("search"))
      {
         String category = request.getParameter("cat");
         String keyword = request.getParameter("keyword");
         List<Board> list = new BoardIO().search(category,keyword);
             request.setAttribute("list", list);
             request.setAttribute("cat", category);
             request.setAttribute("key", keyword);
             return "/jsp/searchResult.jsp";
        	 
         }
	return null;
         
   }
      

   
   private Board getParam() {
      int num = BoardIO.getMaxNum()+1;
      String title = request.getParameter("title");
      String author = request.getParameter("author");
      String contents = request.getParameter("contents");
      java.util.Date regDate = new java.util.Date();
      int hits = 0;
      return new Board(num,title,author,contents,regDate,hits);
   }
   
   private void sendJSON(String key, Object value) {
      JSONObject jsObj = new JSONObject();
      jsObj.put(key, value);
      
      try {
         PrintWriter out = response.getWriter();
         out.print(jsObj.toJSONString());
         out.flush();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
