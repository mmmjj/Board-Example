package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MyBoardDTO;
import com.exception.MyException;
import com.service.MyBoardService;

/**
 * Servlet implementation class MyBoardWriteServlet
 */
@WebServlet("/MyBoardWriteServlet")
public class MyBoardWriteServlet extends HttpServlet {
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//dto에 담아서 보내야함
		MyBoardDTO dto = new MyBoardDTO();
		dto.setAuthor(author);
		dto.setTitle(title);
		dto.setContent(content);
		//만들어진 dto를 서비스로보냄 surround해줌
		MyBoardService service = new MyBoardService();
		String target="MyBoardListServlet";
		try {
			service.boardWrite(dto);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target="error.jsp";
		}
		response.sendRedirect(target);//forward는 url변경이안되어서 재전송이 되어버린다
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
