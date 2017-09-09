
package com.dao;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class CartDAO {
	
	public int addCart(SqlSession session, CartDTO dto) {
		int n = session.insert("com.mybatis.CartMapper.addCart",dto);
		return n;
	}
	
	public List<CartDTO> cartList(SqlSession session, String userid){
		List<CartDTO> dto = session.selectList("com.mybatis.CartMapper.cartList",userid);
		return dto;
	}
	public int delCart(SqlSession session, int num) {
		int n = session.delete("com.mybatis.CartMapper.delCart",num);
		return n;
	}
	
	public int amountUpdate(SqlSession session, HashMap<String, Integer> map) {
		int n = session.update("com.mybatis.CartMapper.amountUpdate",map);
		return n;
	}
	public int delAllCart(SqlSession session, List<String> list) {
		int n = session.delete("com.mybatis.CartMapper.delAllCart",list);
		return n;
	}
	public CartDTO orderConfirm(SqlSession session, int num) {
		CartDTO dto = session.selectOne("com.mybatis.CartMapper.orderConfirm",num);
		return dto;
	}
	public List<CartDTO> orderAllConfirm(SqlSession session, List<String> list) {
		List<CartDTO> dto = session.selectList("com.mybatis.CartMapper.orderAllConfirm",list);
		return dto;
	}

}