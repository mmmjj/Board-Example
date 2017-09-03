package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.PageDTO;

/**
 * Servlet implementation class MyBoardPerPage
 */
@WebServlet("/MyBoardPerPageServlet")
public class MyBoardPerPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String perPage =request.getParameter("rowCount");

		PageDTO.setPerPage(Integer.parseInt(perPage));
		 String target="MyBoardListServlet";
		// request.setAttribute("perPage", perPage);
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
