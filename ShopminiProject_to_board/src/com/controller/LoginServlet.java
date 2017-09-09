package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MemberService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid= request.getParameter("userid");
		String passwd= request.getParameter("passwd");
		
		HashMap map = new HashMap();
		map.put("userid",userid );
		map.put("passwd",passwd );
		
		String target="";
		
		MemberService service = new MemberService();
		try {
			MemberDTO dto = service.login(map);
			if(dto == null) {
				target="error.jsp";
				request.setAttribute("mesg", "아이디/비밀번호 확인");		
			}else {
				target ="home.jsp";
				HttpSession session = request.getSession();
				session.setAttribute("login",dto);
				request.setAttribute("login", "로그인되었습니다.");
			}
			
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
