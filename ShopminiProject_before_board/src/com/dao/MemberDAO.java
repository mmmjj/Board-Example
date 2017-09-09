package com.dao;



import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public int insertMember(SqlSession session, MemberDTO dto) {
		int n = session.insert("com.mybatis.MemberMapper.insertMember",dto);
		return n;
	}
	
	public MemberDTO login(SqlSession session, HashMap map) {
		MemberDTO dto = session.selectOne("com.mybatis.MemberMapper.login", map);
		return dto;
	}
	
	public MemberDTO mypage(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("com.mybatis.MemberMapper.mypage",userid);
		return dto;
	}
	
	public int updatemember(SqlSession session, MemberDTO dto) {
		int n = session.update("com.mybatis.MemberMapper.updatemember",dto);
		return n;
	}
	public int deletemember(SqlSession session, String userid) {
		int n = session.delete("com.mybatis.MemberMapper.deletemember",userid);
		return n;
	}

}
