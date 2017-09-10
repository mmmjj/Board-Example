package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MyBoardDAO;
import com.dto.MyBoardDTO;
import com.dto.PageDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class MyBoardService {

	public List<MyBoardDTO> myBoardList() throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDAO dao = new MyBoardDAO();
		List<MyBoardDTO> list = null;
		try {
			list = dao.myBoardList(session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("myBoardList 예외");
		} finally {
			session.close();
		}
		return list;

	}

	public PageDTO pageboard(HashMap<String, String> map, int curPage) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDAO dao = new MyBoardDAO();
		PageDTO pdto = null;
		try {
			pdto = dao.pageboard(session, map, curPage);

		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("myBoardList 예외");
		} finally {
			session.close();
		}
		return pdto;

	}

	public void writeboard(MyBoardDTO dto) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDAO dao = new MyBoardDAO();
		try {
			int n = dao.writeboard(session, dto);
			if (n == 1) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new MyException("writeboard 예외");
		} finally {
			session.close();
		}
	}

	public MyBoardDTO boardretrieve(int num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDTO dto = null;
		MyBoardDAO dao = new MyBoardDAO();
		
		try {
			dto = dao.boardretrieve(session, num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("boardretrieve 예외");
		} finally {
			session.close();
		}
		return dto;
	}
}
