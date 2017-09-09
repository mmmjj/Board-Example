package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dao.MemberDAO;
import com.dto.MemberDTO;
import com.exception.MyException;
import com.mybatis.MybatisTemplate;

public class MemberService {
	
	public void insertMember( MemberDTO dto) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao= new MemberDAO();
		try {
			int n = dao.insertMember(session, dto);
			if(n==1) {
				session.commit();
			}
			
		}catch(Exception e) {
			throw new MyException("insertMember 예외");
		}finally {
			session.close();
		}
	}
	
	public MemberDTO login(HashMap map) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		try {
			dto = dao.login(session, map);
			
		}catch(Exception e) {
			throw new MyException("login 예외");
		}finally {
			session.close();
		}
		return dto;
	}
	
	public MemberDTO mypage(String userid) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		try {
			dto = dao.mypage(session, userid);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new MyException("mypage 예외");
			//sql?
		}finally {
			session.close();
		}
		return dto;
	}
	
	public void updateMember( MemberDTO dto) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao= new MemberDAO();
		try {
			int n = dao.updatemember(session, dto);
			if(n==1) {
				session.commit();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("updateMember 예외");
		}finally {
			session.close();
		}
	}
	
	public void deletemember( String userid) throws MyException {
		SqlSession session = MybatisTemplate.openSession();
		MemberDAO dao= new MemberDAO();
		try {
			int n = dao.deletemember(session, userid);
			if(n==1) {
				session.commit();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new MyException("deletemember 예외");
		}finally {
			session.close();
		}
	}

}
