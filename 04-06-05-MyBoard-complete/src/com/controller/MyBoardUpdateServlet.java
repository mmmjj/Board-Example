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
 * Servlet implementation class MyBoardUpdateServlet
 */
@WebServlet("/MyBoardUpdateServlet")
public class MyBoardUpdateServlet extends HttpServlet {
//8-22
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		
		MyBoardDTO dto = new MyBoardDTO();
		dto.setNum(Integer.parseInt(num));
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setContent(content);
		
		MyBoardService service = new MyBoardService();
		String target ="MyBoardListServlet";
		try {
			service.updateByNum(dto);

		} catch (MyException e) {
			target ="error.jsp";
		}
		
		response.sendRedirect(target);
		
		
	}//end 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
