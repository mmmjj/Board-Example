package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MyBoardDAO;
import com.dto.MyBoardDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class MyBoardService {
	
	public List<MyBoardDTO> myBoardList() throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDAO dao = new MyBoardDAO();
		List<MyBoardDTO> list =null;
		try {
			list = dao.myBoardList(session);
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("myBoardList 예외");
		}finally {
			session.close();
		}
		return list;
		
	}

}
