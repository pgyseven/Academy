package com.mbcac.pet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PetSvc {

	private HttpServletRequest request;
	private HttpServletResponse response;

	public PetSvc(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public String process() {
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if (cmd.equals("addPet")) {
			return "/jsp/pet/addPet.jsp";

		} else if (cmd.equals("save")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			int year = Integer.parseInt(request.getParameter("year"));
			int price = Integer.parseInt(request.getParameter("price"));
			float weight = Integer.parseInt(request.getParameter("weight"));

			System.out.println("입력값 : " + no + name + year + price + weight);

			PetVO key = new PetVO();
			key.setNo(no);
			key.setName(name);
			key.setYear(year);
			key.setPrice(price);
			key.setWeight(weight);

			PetDAO pdao = new PetDAO();

			boolean saved = pdao.save(key);
			sendJSON("saved", saved);

		} else if (cmd.equals("list")) {
			PetDAO pdao = new PetDAO();
			List<PetVO> list = pdao.petList();
			System.out.println(list.get(1).getNo());
			System.out.println(list.get(1).getName());
			request.setAttribute("list", list);
			return "/jsp/pet/petList.jsp";
			
		} else if (cmd.equals("update")) {
			int no = Integer.parseInt(request.getParameter("no"));
			int price = Integer.parseInt(request.getParameter("price"));
			System.out.println("숫자와 번호등: "+no+price);
			boolean updated = new PetDAO().update(no,price);
			System.out.println(updated);
	
			sendJSON("updated", updated);
			
		}else if (cmd.equals("delete")) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			System.out.println("숫자와 번호등: "+no);
			boolean deleted = new PetDAO().delete(no);
			System.out.println(deleted);
	
			sendJSON("deleted", deleted);
			
		}

		return null;

	}

	private void sendJSON(String key, Object obj) {
		try {
			JSONObject jsObj = new JSONObject();
			jsObj.put(key, obj);
			PrintWriter out = response.getWriter(); // 응답받아야 하는 컴퓨터의 정보가 리스펀스에 있다.
			out.print(jsObj.toJSONString());
			out.flush();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
