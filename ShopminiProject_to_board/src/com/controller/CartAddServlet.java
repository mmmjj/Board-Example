package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.CartService;

@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gImage=request.getParameter("gImage");
		String gCode=request.getParameter("gCode");
		String gName=request.getParameter("gName");
		String gPrice=request.getParameter("gPrice");
		String gSize=request.getParameter("GOODS_SIZE");
		String gColor=request.getParameter("GOODS_COLOR");
		String gAmount=request.getParameter("GOODS_AMOUNT");

		
		//id		
		HttpSession session = request.getSession();
		MemberDTO mem = (MemberDTO)session.getAttribute("login");
		
		CartDTO dto = new CartDTO();
		dto.setUserid(mem.getUserid());
		dto.setgAmount(Integer.parseInt(gAmount));
		dto.setgCode(gCode);
		dto.setgColor(gColor);
		dto.setgImage(gImage);
		dto.setgName(gName);
		dto.setgPrice(Integer.parseInt(gPrice));
		dto.setgSize(gSize);



		
		 CartService service = new CartService();
		 
		    String target="GoodsRetrieveServlet?gCode="+gCode;
		    try {
				service.addCart(dto);
				request.setAttribute("cart", "장바구니에 담겼습니다.");
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
