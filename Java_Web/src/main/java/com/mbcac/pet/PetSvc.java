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
			String sName = request.getParameter("name");
			int year = Integer.parseInt(request.getParameter("year"));
			int price = Integer.parseInt(request.getParameter("price"));
			float weight = Integer.parseInt(request.getParameter("weight"));

			PetVO key = new PetVO();
			key.setNo(no);
			key.setsName(sName);
			key.setYear(year);
			key.setPrice(price);
			key.setWeight(weight);

			PetDAO dao = new PetDAO();

			boolean saved = dao.save(key);
			sendJSON("saved", saved);
		} else if (cmd.equals("list")) {
			PetDAO pdao = new PetDAO();
			List<PetVO> list = pdao.petList();
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
