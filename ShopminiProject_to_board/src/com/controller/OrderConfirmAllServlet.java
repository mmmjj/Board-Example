package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.CartService;
import com.service.MemberService;


@WebServlet("/OrderConfirmAllServlet")
public class OrderConfirmAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String []checks = request.getParameterValues("check");
		String userid = request.getParameter("userid");
		//체크한값들가져오기
		for(String s:checks) {
			System.out.println(s);
		}
		CartService cService = new CartService();
		MemberService mService = new MemberService();
		String target="orderAllConfirm.jsp";
		
		try {
			MemberDTO mDTO = mService.mypage(userid);//member에서 가져오는 이유는 session에는 모든 정보를 저장되는 것이 아님, id가 필요하지만 주소는 없을 수 있으니
			List<CartDTO> cDTO = cService.orderAllConfirm(Arrays.asList(checks));
			request.setAttribute("cDTO", cDTO);
			request.setAttribute("mDTO", mDTO);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target="error.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
		/*		String num = request.getParameter("num"); //cart에서
		String userid = request.getParameter("userid"); //member에서
		
		CartService service = new CartService();
		MemberService mService = new MemberService();
		String target="orderConfirm.jsp";
		
		try {
			MemberDTO mDTO = mService.mypage(userid);//member에서 가져오는 이유는 session에는 모든 정보를 저장되는 것이 아님, id가 필요하지만 주소는 없을 수 있으니
			CartDTO cDTO = service.orderConfirm(Integer.parseInt(num));
			request.setAttribute("cDTO", cDTO);
			request.setAttribute("mDTO", mDTO);
			
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target="error.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
