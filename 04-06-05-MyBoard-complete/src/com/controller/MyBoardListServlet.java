package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.PageDTO;
import com.exception.MyException;
import com.service.MyBoardService;

/**
 * Servlet implementation class MyBoardListServlet
 */
@WebServlet("/MyBoardListServlet")
public class MyBoardListServlet extends HttpServlet implements Servlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String curPage = request.getParameter("curPage"); //list.jsp에 1 2 3 4 --> 이게 넘어오는것
		 if(curPage ==null ) {
	 		 curPage="1";
		 }
		 String purPage = "1";
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		 HashMap<String, String> map= new HashMap<>();
		 map.put("searchName", searchName);
		 map.put("searchValue", searchValue);
		
		MyBoardService service = new MyBoardService();
		String target = "list.jsp";
		//성공하면목록화면, 실패하며 예외페이지
		
//		System.out.println(searchValue);
		try {
			PageDTO list = service.page(map,Integer.parseInt(curPage));
			request.setAttribute("list", list);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target = "error.jsp";
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
