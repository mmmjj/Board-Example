package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.MyException;
import com.service.MyBoardService;

/**
 * Servlet implementation class MyBoardDeleteServlet
 */
@WebServlet("/MyBoardDeleteServlet")
public class MyBoardDeleteServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		MyBoardService service = new MyBoardService();
		String target ="MyBoardListServlet";
		try {
			service.deleteByNum(Integer.parseInt(num));
		} catch (NumberFormatException | MyException e) {
			target="error.jsp";
			e.printStackTrace();
		}
		response.sendRedirect(target);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
