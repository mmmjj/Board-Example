package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.CartDAO;
import com.dao.OrderDAO;
import com.dto.OrderDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class OrderService {
	
	public void orderDone(OrderDTO list,int num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO dao = new OrderDAO();
		CartDAO cDAO = new CartDAO();
		try {
			int n =dao.orderDone(session, list);
			int n2 = cDAO.delCart(session,num);
			//orderDone insert하고 cart는 delete하고, 트랜젝션은 service에서
			if((n+n2)==2) session.commit();
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new MyException("orderDone 예외");
		}finally {
			session.close();
		}
	}
	
	public void orderAllDone(ArrayList<OrderDTO> list, List<String> nums) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		OrderDAO dao = new OrderDAO();
		CartDAO cDAO = new CartDAO();
		try {
			int n =dao.orderAllDone(session, list);
			int n2 = cDAO.delAllCart(session,nums);
			//orderDone insert하고 cart는 delete하고, 트랜젝션은 service에서
			if((n+n2)==(list.size()+nums.size())) session.commit();
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new MyException("orderAllDone 예외");
		}finally {
			session.close();
		}
	}

}
