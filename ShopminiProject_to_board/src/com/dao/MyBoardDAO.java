package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.MyBoardDTO;
import com.mybatis.MybatisTemplate;

public class MyBoardDAO {
	
	public List<MyBoardDTO> myBoardList(SqlSession session){
		List<MyBoardDTO> dto = session.selectList("myBoardList");
		return dto;
	}


}
