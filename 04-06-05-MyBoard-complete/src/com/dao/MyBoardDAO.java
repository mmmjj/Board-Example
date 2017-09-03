package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.MyBoardDTO;
import com.dto.PageDTO;
//8-22
public class MyBoardDAO {
	//1.목록보기
	public List<MyBoardDTO>	list(SqlSession session){
		List<MyBoardDTO> list = session.selectList("selectAll");
		return list;
	}
	//2.글쓰기
	public int boardWrite(SqlSession session, MyBoardDTO dto) {
		int n = session.insert("boardWrite",dto);
		System.out.println("n은" +n);
		return n; //service 가 트랜잭션을 종료해야하고 int n으로 성공했는지 service에서 확인하고 커밋할것
	}
	//3.글자세히보기
	public MyBoardDTO selectByNum(SqlSession session, int num) {
		MyBoardDTO dto = session.selectOne("selectByNum", num);
		return dto;
	}
	//3-2.조회수올리기
	public int readCnt(SqlSession session, int num) {
		int n = session.update("readCnt",num);
		return n;
	}
	//4.삭제하기
	public int deleteByNum(SqlSession session, int num) {
							//세션하고 삭제할 번호넘김
		int n = session.delete("deleteByNum",num);
		return n;
	}
	
	//5. 글 수정
	public int updateByNum(SqlSession session , MyBoardDTO dto) {
	int n = session.update("updateByNum", dto);
	return n;
	}
	
	//6. 검색보기
	public PageDTO search(SqlSession session, HashMap<String,String> map,int curPage){
		PageDTO pdto = new PageDTO();
		int totalCount = session.selectOne("searchCount",map);
		int sIndex = (curPage -1) * pdto.getPerPage();
			
		int length = pdto.getPerPage();
		
		List<MyBoardDTO> list = session.selectList("search", map, new RowBounds(sIndex,length));
		
			pdto.setList(list);
			pdto.setCurPage(curPage);
			pdto.setTotalCount(totalCount);
		return pdto;
	}
	//7.페이징처리
	public /*List<MyBoardDTO>	*/ PageDTO page(SqlSession session, HashMap<String,String> map, int curPage){
		
		PageDTO pdto = new PageDTO();
		

		int sIndex = (curPage -1)* PageDTO.getPerPage();
		int length = PageDTO.getPerPage();

		List<MyBoardDTO> list = 
				session.selectList("search",map, new RowBounds(sIndex, length));
					//sIndex만큼 뛰고 length만큼 가져온다
		
		//pdto에 4개데이터 저장.
		int totalCount=0;
		pdto.setList(list);
		pdto.setCurPage(curPage);
		
		if(map.get("searchValue")==null) {
			 totalCount = session.selectOne("totalCount",null);
		}else {
			 totalCount = session.selectOne("searchCount",map );
		}

		pdto.setTotalCount(totalCount);
		pdto.setSearchName(map.get("searchName"));
		pdto.setSearchValue(map.get("searchValue"));
	      return pdto;
	}
	
}
