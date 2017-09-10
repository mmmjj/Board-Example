package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.MyBoardDTO;
import com.dto.PageDTO;

public class MyBoardDAO {

	public List<MyBoardDTO> myBoardList(SqlSession session) {
		List<MyBoardDTO> dto = session.selectList("myBoardList");
		return dto;
	}

	public PageDTO pageboard(SqlSession session, HashMap<String,String> map, int curPage) {
		PageDTO pdto = new PageDTO();

		int sIndex = (curPage - 1) * PageDTO.getPerCount();
		int length = PageDTO.getPerCount();

		List<MyBoardDTO> list = session.selectList("myBoardSearchList", map,new RowBounds(sIndex, length));
		System.out.println(list);
		// pagedto에 저장하기
		int totalPage = 0;
		pdto.setList(list);
		pdto.setCurPage(curPage);
		if (map.get("searchValue") == null) {
			totalPage = session.selectOne("totalPage", map.get("userId"));
		} else {
			totalPage = session.selectOne("searchPage", map);
		}
		pdto.setUserId(map.get("userId"));
		pdto.setTotalPage(totalPage);
		pdto.setSearchName(map.get("searchName"));
		pdto.setSearchValue(map.get("searchValue"));

		return pdto;
	}

	
	public int writeboard(SqlSession session, MyBoardDTO dto) {
		int n = session.insert("writeboard",dto);
		System.out.println(n);
		return n;
	}
}
