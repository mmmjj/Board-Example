package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MyBoardDTO;
import com.exception.MyException;
import com.service.MyBoardService;

/**
 * Servlet implementation class MyBoardRetrieveServlet
 */
@WebServlet("/MyBoardRetrieveServlet")
public class MyBoardRetrieveServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
		MyBoardService service = new MyBoardService();
		String target="retrieve.jsp";
		try {
			MyBoardDTO dto = service.selectByNum(Integer.parseInt(num));
			request.setAttribute("retrieve", dto);
		}catch(MyException e) {
			e.printStackTrace();
			target="error.jsp";
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
