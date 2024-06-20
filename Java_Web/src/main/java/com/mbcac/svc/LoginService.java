package com.mbcac.svc;

import org.json.simple.JSONObject;

import com.mbcac.fio.FileIO;
import com.mbcac.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginService 
{
	private HttpServletRequest request; 
	private HttpServletResponse response;
	
	public LoginService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public String process() {
		String cmd = request.getParameter("cmd");
		
		if(equals("add")) 
		{
			return saveFile();
	}
	
	return null;
	}
	private String saveFile()
	{
		String id  = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		User user = new User(id, pwd);
		FileIO fio = new FileIO();
		boolean ok = fio.login(user);
		
		JSONObject jsObj = new JSONObject();
		jsObj.put("ok", ok);
		
		return jsObj.toJSONString();
	}
}

