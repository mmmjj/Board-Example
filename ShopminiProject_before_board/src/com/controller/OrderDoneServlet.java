package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.OrderDTO;
import com.exception.MyException;
import com.service.OrderService;


@WebServlet("/OrderDoneServlet")
public class OrderDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ueserid = request.getParameter("userid");
		String gCode = request.getParameter("gCode");
		String gName = request.getParameter("gName");
		String gPrice = request.getParameter("gPrice");
		String gSize = request.getParameter("gSize");
		String gColor = request.getParameter("gColor");
		String gAmount = request.getParameter("gAmount");
		String gImage = request.getParameter("gImage");
		String orderName = request.getParameter("orderName");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String payMethod = request.getParameter("payMethod");//parameter받고

		
		OrderDTO dto = new OrderDTO();
		dto.setUserid(ueserid);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setgCode(gCode);
		dto.setgColor(gColor);
		dto.setgImage(gImage);
		dto.setgName(gName);
		dto.setgSize(gSize);
		dto.setOrderName(orderName);
		dto.setPost1(post1);
		dto.setPost2(post2);
		dto.setPhone(phone);
		dto.setPayMethod(payMethod);
		dto.setgPrice(Integer.parseInt(gPrice));
		dto.setgAmount(Integer.parseInt(gAmount)); //orderdto set
		
		String num = request.getParameter("num");//카트의 num orderdto의 num에 저장하면안됨
		OrderService service = new  OrderService();
		
		 String target="orderDone.jsp";
		try {
			service.orderDone(dto , Integer.parseInt(num));
			request.setAttribute("oDTO", dto);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target= "error.jsp";
		}
		 RequestDispatcher dis = request.getRequestDispatcher(target);
		    dis.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
