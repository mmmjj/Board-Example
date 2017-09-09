package com.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;

public class GoodsDAO {
	
	public List<GoodsDTO> goodsList(SqlSession session, String gCategory){
		
		List<GoodsDTO> goodsList = session.selectList("com.mybatis.GoodsMapper.goodsList",gCategory);
		return goodsList;
	}
	
	public GoodsDTO goodsRetrieve(SqlSession session, String gCode){
		//retrieve는 selectone
		GoodsDTO goodsRetrieve = session.selectOne("com.mybatis.GoodsMapper.goodsRetrieve",gCode);
		return goodsRetrieve;
	}
	

}
