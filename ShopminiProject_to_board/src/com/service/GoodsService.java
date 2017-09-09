package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.GoodsDAO;
import com.dto.GoodsDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class GoodsService {
	
	public List<GoodsDTO> goodsList(String gCategory) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		GoodsDAO dao = new GoodsDAO();
		List<GoodsDTO> dto = null;
		try {
			dto = dao.goodsList(session, gCategory);

		}catch(Exception e) {
			throw new MyException("goodsList 예외");
		}finally {
			session.close();
		}
		return dto;
	}
	
	public GoodsDTO goodsRetrieve(String gCode) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = null;
		try {
			dto = dao.goodsRetrieve(session, gCode);
		}catch(Exception e) {
			throw new MyException("goodsRetrieve 예외");
		}finally {
			session.close();
		}
		return dto;
	}



}
