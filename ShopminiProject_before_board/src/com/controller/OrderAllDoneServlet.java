package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.OrderDTO;
import com.exception.MyException;
import com.service.OrderService;


@WebServlet("/OrderAllDoneServlet")
public class OrderAllDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] userid = request.getParameterValues("userid");
		String [] gCode = request.getParameterValues("gCode");
		String [] gName = request.getParameterValues("gName");
		String [] gPrice = request.getParameterValues("gPrice");
		String [] gSize = request.getParameterValues("gSize");
		String [] gColor = request.getParameterValues("gColor");
		String [] gAmount = request.getParameterValues("gAmount");
		String [] gImage = request.getParameterValues("gImage");
		
		String orderName = request.getParameter("orderName");
		String  post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String  addr1 = request.getParameter("addr1");
		String  addr2 = request.getParameter("addr2");
		String  phone = request.getParameter("phone");
		
		String payMethod = request.getParameter("payMethod");
		
		ArrayList<OrderDTO> list = new ArrayList<>();//arraylist에 저장하는데...
		for (int i = 0; i < gCode.length; i++) {
			OrderDTO dto = new OrderDTO();
			dto.setUserid(userid[i]);
			dto.setgCode(gCode[i]);
			dto.setgColor(gColor[i]);
			dto.setgImage(gImage[i]);
			dto.setgName(gName[i]);
			dto.setgSize(gSize[i]);
			dto.setAddr1(addr1);
			dto.setAddr2(addr2);
			dto.setOrderName(orderName);
			dto.setPost1(post1);
			dto.setPost2(post2);
			dto.setPhone(phone);
			dto.setPayMethod(payMethod);
			dto.setgPrice(Integer.parseInt(gPrice[i]));
			dto.setgAmount(Integer.parseInt(gAmount[i]));
			list.add(dto);//list는 키값을 안하고 그냥 마구마구넣어도된다. 이게 list에 저장된거~
		}
		System.out.println(list);
/*		arralist에담고 insert를 arraylist만큼
		insert all 호출하고 */
		

		
		String [] nums = request.getParameterValues("num");//카트의 num orderdto의 num에 저장하면안됨
		List<String> num = new ArrayList<>() ;
		for (int i = 0; i < nums.length; i++) {
			num.add(nums[i]);
		}
		
		
		OrderService service = new  OrderService();
		
		 String target="orderAllDone.jsp";
		try {
			service.orderAllDone(list , num);
			request.setAttribute("oDTO", list);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target= "error.jsp";
		}
		 RequestDispatcher dis = request.getRequestDispatcher(target);
		    dis.forward(request, response);

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
