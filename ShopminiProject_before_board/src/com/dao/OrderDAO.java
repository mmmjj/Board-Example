package com.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.dto.OrderDTO;

public class OrderDAO {
	
	public int orderDone(SqlSession session, OrderDTO dto) {
		int n = session.insert("com.mybatis.OrderMapper.orderDone",dto);
		return n;
	}
	public int orderAllDone(SqlSession session, ArrayList<OrderDTO> list) {
		int n = session.insert("com.mybatis.OrderMapper.orderAllDone",list);
		return n;
	}
	
	
}
