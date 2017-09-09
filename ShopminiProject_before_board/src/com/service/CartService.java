package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.CartDAO;
import com.dto.CartDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;


public class CartService {
	
	public void addCart(CartDTO dto) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		try {
			int n = dao.addCart(session, dto);
			if(n==1) session.commit();
		}catch(Exception e) {
			throw new MyException("addCart 예외");
		}finally {
			session.close();
		}
	}
	
	
	public List<CartDTO> cartList(String userid) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		List<CartDTO> dto =null;
		try {
			dto = dao.cartList(session, userid);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("cartList 예외");
		}
		return dto;
	}
	
	public void delCart(int num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		try {
			int n = dao.delCart(session, num);
			if(n==1) session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("delCart 예외");
		}finally {
			session.close();
		}
	}
	
	public void amountUpdate(HashMap<String,Integer> map) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();

		try {

			int n = dao.amountUpdate(session, map);
			if(n==1) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("amountUpdate 예외");
		}finally {
			session.close();
		}
	}
	
	public void delAllCart(List<String> list) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();

		try {

			int n = dao.delAllCart(session, list);
			if(list.size()==n) session.commit();
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("delAllCart 예외");
		}finally {
			session.close();
		}
	}
	
	public CartDTO orderConfirm(int num) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		CartDTO dto = null;
		try {

			dto = dao.orderConfirm(session, num);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("orderConfirm 예외");
		}finally {
			session.close();
		}
		return dto;
	}

	
	public List<CartDTO> orderAllConfirm(List<String> list) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		CartDAO dao = new CartDAO();
		 List<CartDTO> dto = null;

		try {

			dto = dao.orderAllConfirm(session, list);
		}catch(Exception e){
			e.printStackTrace();
			throw new MyException("orderAllConfirm 예외");
		}finally {
			session.close();
		}
		return dto;
	}
	
	
	
}
