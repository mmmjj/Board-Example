package com.controller.myboard;

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
import com.dto.PageDTO;
import com.exception.MyException;
import com.service.MyBoardService;

@WebServlet("*.board")
public class MyBoardFrontServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String target = "";

		MemberDTO login = (MemberDTO) session.getAttribute("login");

		if (login == null) {
			response.sendRedirect("error.jsp");
		} else {

			String requestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			String command = requestURI.substring(contextPath.length());

			MyBoardService service = new MyBoardService();

			if (command.equals("/list.board")) {
				
				String curPage = request.getParameter("curPage");
				if (curPage == null)
					curPage = "1";

				String searchName = request.getParameter("searchName");
				String searchValue = request.getParameter("searchValue");

				HashMap<String, String> map = new HashMap();
				map.put("searchName", searchName);
				map.put("searchValue", searchValue);
				map.put("userId",login.getUserid());

				try {

					PageDTO pdto = service.pageboard(map,Integer.parseInt(curPage));
					request.setAttribute("bList", pdto);
					target = "myBoardList.jsp";
				} catch (MyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			RequestDispatcher dis = request.getRequestDispatcher(target);
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
