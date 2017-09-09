package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/xx")
public class LogOutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logoutServlet");
		String target = "home.jsp";
		
		//로그인된상태여야지 로그아웃이 가능하기 때문>
		//dto가 null이면 로그인이 안되어있는 상태.
		//다이렉트로 요청하는 거 체크
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		if(dto==null) {
		//null인게 로그인안된상태로 온거
			target="loginForm.jsp";
			request.setAttribute("mesg", "로그인이 필요합니다");
			System.out.println("성공");
		}else {
			session.invalidate();//세션없애는거
			request.setAttribute("logout", "정상 로그아웃");
			System.out.println("실");
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
