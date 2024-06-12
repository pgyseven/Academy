package com.mbcac.session;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mbcac.fio.FileIO;
import com.mbcac.vo.User;
import org.json.simple.parser.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionService 

{
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public SessionService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

}

	public String process() {
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("loginForm"))
		{
			return "/jsp/loginForm.jsp";
		}
		else if(cmd.equals("login"))
		{
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			User user = new User(id,pwd);
			FileIO fio = new FileIO();
			boolean ok = fio.login(user);
			if(ok) setIdInSession(id);
			sendJSON("ok",ok); //로그인 정보를 저장을 했지만 이건 지역변수라서 나중에 쓸 수가 없다 그런데 이용자가 어디를 가던 그사람이 로그인 사람인걸 계속 알릴 수 있게 지역 변수가 아닌 다른곳에 저장해야 맞다.
			
			
		}
		else if(cmd.equals("showIndex"))
		{
			//로그인에 성공한 이용자에게만 보여줄 수 있는 화면을 제시한다.
			//요청한 이용자의 로그인 여부를 검사한다.
			Object objUserId = request.getSession().getAttribute("userid");
			if(objUserId==null) {
				String cause = "요청하신 기능은 로그인 후에 사용할 수 있습니다.";
				request.getSession().setAttribute("cause",cause);//로그인 안한경우이기에 이게 리퀘스트에 저장하는게 아니고 세션에 담는거나 리퀘스트보다 넓은 영역이 세션이다. 
				return "/jsp/loginForm.jsp";
			}
			//로그인 이요자인경우에는 해당 화면을 보여주고, 아니면 로그인 폼을 보여준다.
			return "/jsp/index.jsp";
		}
		else if(cmd.equals("mouse"))
		{
			return "/jsp/mouse.jsp";
		}
		else if(cmd.equals("memory"))
		{
			return "/jsp/memory.jsp";
		}
		else if(cmd.equals("monitor"))
		{
			return "/jsp/monitor.jsp";
		}
		else if(cmd.equals("cartin"))
		{
			String gname = request.getParameter("name");
			String sPrice = request.getParameter("price");
			int price = Integer.parseInt(sPrice);
			Item item = new Item(gname,price);
			//item 을 장바구니에 담는다.
	         HttpSession ss = request.getSession();
	         Object objCart = ss.getAttribute("cart");
	         if(objCart==null) {
	            Cart cart = new Cart();
	            ss.setAttribute("cart", cart);  //카트를 세션에 심는다.
	            objCart = ss.getAttribute("cart");
	         }
	         Cart cart = (Cart)objCart;
	         boolean added = cart.add(item);
	         sendJSON("added",added);
	      }
		else if(cmd.equals("showcart"))
		{
			Object objCart = request.getSession().getAttribute("cart");
			Cart cart = (Cart)objCart;
			List<Item> list = cart.getList();
			request.setAttribute("total", cart.getTotal());
			request.setAttribute("list", list);
			return "/jsp/cartItemList.jsp";
		}
		   else if(cmd.equals("itemChange"))
		      {
		         String itemName = request.getParameter("itemname");
		         String sPrice = request.getParameter("price");
		         String sQty = request.getParameter("qty");
		         int price = Integer.parseInt(sPrice);
		         int qty = Integer.parseInt(sQty);
		         Item key = new Item(itemName, price);
		         key.setQty(qty);
		         
		         Object objCart = request.getSession().getAttribute("cart");
		         Cart cart = (Cart)objCart;
		         boolean changed = cart.itemChange(key);
		         sendJSON("changed", changed);
		      }
		   else if(cmd.equals("delItem")) //자바에서 map가 비슷한 제이슨 오브젝트 원래 제이슨 자바에는 없지만 우리가 이전에 설치해서 쓸 수 있는것
		      {
					/*
					 * parser 읽어들이면서 가공한다. 제이슨 문자열을 파스한다. 뭘로? JSONArray 제이슨 배열로! 바꾼다. 제이슨 오브젝트가 많이
					 * 들어있는 배열인 것. 파서로 읽어 들였으니 제이슨 오브젝트로 바꾸고! jsArr 가공 절차가 족잡해 지니 리스트로 바꾼것!
					 */ 
			   String itemName = request.getParameter("itemname");
		         String sPrice = request.getParameter("price");
		         int price = Integer.parseInt(sPrice);
		         
		         Item key = new Item(itemName, price);
		         
		         Object objCart = request.getSession().getAttribute("cart");
		         Cart cart = (Cart)objCart;
		         boolean deleted = cart.delItem(key);
		         sendJSON("deleted", deleted);
		      }
		
		      else if(cmd.equals("delBatch"))
		      {
		         String jsStr = request.getParameter("deljs");
		         JSONParser jp = new JSONParser();
		         try {
		            JSONArray jsArr = (JSONArray)jp.parse(jsStr);
		            List<Item> delList = new ArrayList<>();
		            for(int i=0;i<jsArr.size();i++) {
		               JSONObject jsobj = (JSONObject)jsArr.get(i);
		               String itemname = (String)jsobj.get("itemname");
		               String sPrice = (String)jsobj.get("price");
		               int price = Integer.parseInt(sPrice);
		               delList.add(new Item(itemname, price));
		            }
		            Cart cart = (Cart)request.getSession().getAttribute("cart");
		            boolean deleted = cart.delBatch(delList);
		            sendJSON("deleted", deleted);
		         } catch (ParseException e) {
		            e.printStackTrace();
		         }
		      }
		
		else if(cmd.equals("cartEmpty"))
	      {
	
			Object objCart = request.getSession().getAttribute("cart");
			Cart cart = (Cart)objCart;
			List<Item> list = cart.getList();
			list.clear();
			request.setAttribute("total", cart.getTotal());
			request.setAttribute("list", list);
			return "/jsp/cartItemList.jsp";
				
	           
	      }
		else if(cmd.equals("order"))
	      {
	
			Object objCart = request.getSession().getAttribute("cart");
			Cart cart = (Cart)objCart;
			List<Item> list = cart.getList();
			
			FileIO fio = new FileIO();
		      boolean ordered = fio.addOrder(list);
		      list.clear();
		      sendJSON("ordered", ordered);
		   
		      
			
			
			
				
	           
	      }
		
		return null;
	}
	
	
	

	
	/** HttpSession에 로그인 성공한 이용자의 아이디를 저장한다. */
	private void setIdInSession(String userID) //세션은 한번 만들어지면 사이트 활동을 안하는 경우 예를들어 피곤해서 자버리는 경우 그이후 30분이 지나면 세션 오브젝트가 서버에서 삭제된다.
	{
		HttpSession session = request.getSession();//요 아이디에 속하는 세션 오브젝트를 줘봐 리퀘스트에 세션이 있는건 당연
		session.setAttribute("userid", userID);		
	}
	
	private void sendJSON(String key, Object obj)
	{
		try {
			JSONObject jsObj = new JSONObject();
			jsObj.put(key,obj);
			PrintWriter out = response.getWriter(); //응답받아야 하는 컴퓨터의 정보가 리스펀스에 있다.
			out.print(jsObj.toJSONString());
			out.flush();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
	
}
