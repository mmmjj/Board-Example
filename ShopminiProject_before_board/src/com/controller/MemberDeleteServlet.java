package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exception.MyException;
import com.service.MemberService;

@WebServlet("/MemberDeleteServlet")
public class MemberDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		MemberService service = new MemberService();
		String target = "home.jsp";
		try {
			service.deletemember(userid);
			request.setAttribute("delete", "회원탈퇴");
			//세션제거
			HttpSession session = request.getSession();
			session.invalidate();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	    RequestDispatcher dis = request.getRequestDispatcher(target);
	    dis.forward(request, response);
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
