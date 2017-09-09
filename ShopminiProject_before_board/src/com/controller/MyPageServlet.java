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
import com.exception.MyException;
import com.service.MemberService;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//현재내정보는 세션에있음
		HttpSession session = request.getSession(); //login폼에 보면 dto패턴으로 로그인 정보가 저장되어있음	
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		String target = null;
		MemberService service= new MemberService();
		
		if(dto!=null) {/*모든페이지는 세션페이지가되어야함 세션이있어야만 할 수 있는 작업이 있기 때문, 언제든지 로그아웃이 될수 (타임아웃)있기 때문에, 로그인은 무조건유지되지않는다 착각 ㄴㄴ*/
			target="mypage.jsp";//로그인이 되어있으니 마이페이지로
			//db의 정보가 최신정보로 db에서 pk(id)로 정보를 가져온다
			try {
				MemberDTO xxx = service.mypage(dto.getUserid()); //그냥userid가아니라 세션의 id를 db에서 직접 가져온다
				session.setAttribute("login", xxx);//db에서가져온 최신 정보를 login에 다시 set
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {	
			target="loginForm.jsp";//로그인이 안되어있으니 로그인페이지로
		
		}
		
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher(target);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
