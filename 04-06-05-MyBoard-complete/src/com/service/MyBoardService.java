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

	public List<MyBoardDTO> list() throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDAO dao = new MyBoardDAO();
		List<MyBoardDTO> list = null;

		try {
			list = dao.list(session);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("list 예외발생");
			// 우리가만든입셉션사용-> 설명해주려고
		} finally {
			session.close();
		}
		return list;

	}

	public void boardWrite(MyBoardDTO dto) throws MyException {
		SqlSession session = MybatisTemplate.openSession();//이거
		MyBoardDAO dao = new MyBoardDAO();//이거

		try {//이거
			int n = dao.boardWrite(session, dto);
			if (n == 1) {
				session.commit();
			}
		} catch (Exception e) {//이거
			e.printStackTrace();//이거
			throw new MyException("boardWrite 예외발생");//이거
		} finally {//이거
			session.close();//이거
			//는 왠만하면 반복임 surround따로없음 try catch직접해야하는거였어.........
		}
	}

	public MyBoardDTO selectByNum(int num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDAO dao = new MyBoardDAO();
		MyBoardDTO dto = null;
		try {
			int n = dao.readCnt(session, num);
			if (n == 1)
				session.commit();// 조회수올리는거 commit임~
			dto = dao.selectByNum(session, num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("selectByNum 예외발생");
			// 우리가만든입셉션사용-> 설명해주려고
		} finally {
			session.close();
		}
		return dto;
	}
	
	public void deleteByNum(int num) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDAO dao = new MyBoardDAO();

		try {
			int n = dao.deleteByNum(session, num);
			if(n==1) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("deleteByNum 예외발생");
		
		} finally {
			session.close();
		}
	}
	
public void updateByNum( MyBoardDTO dto)throws MyException {
		
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDAO dao = new MyBoardDAO();
		try {
			int n = dao.updateByNum(session, dto);
			if(n==1) session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("updateByNum 예외발생");
		}finally {
			session.close();
		}
		
	}//end deleteByNum
	
	//6.
/*	public PageDTO search(HashMap<String,String> map, int curPage) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDAO dao = new MyBoardDAO();
		PageDTO list = null;

		try {
			list = dao.search(session,map,curPage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("search 예외발생");

		} finally {
			session.close();
		}
		return list;

	}*/
	
	//.7페이지
	public PageDTO page(HashMap<String,String> map,int curPage) throws MyException{
		SqlSession session = MybatisTemplate.openSession();
		MyBoardDAO dao = new MyBoardDAO();
		PageDTO list = null;
		try {
			list = dao.page(session,map,curPage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException("page 예외발생");
		} finally {
			session.close();
		}
		return list;
		
	}

}
