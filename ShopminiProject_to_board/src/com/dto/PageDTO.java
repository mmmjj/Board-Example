package com.dto;

import java.util.List;

public class PageDTO {

	private List<MyBoardDTO> list;
	private int curPage;//현재페이지
	private int totalPage;//전체페이지개수
	private static int perCount = 3;//페이지당 노출할 행개수
	private int perBlock = 3;//페이지당 노출할 페이지개수
	private String searchName;//검색종류
	private String searchValue;//검색어
	private String userId;
	public PageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageDTO(List<MyBoardDTO> list, int curPage, int totalPage, int perBlock, String searchName,
			String searchValue, String userId) {
		super();
		this.list = list;
		this.curPage = curPage;
		this.totalPage = totalPage;
		this.perBlock = perBlock;
		this.searchName = searchName;
		this.searchValue = searchValue;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "PageDTO [list=" + list + ", curPage=" + curPage + ", totalPage=" + totalPage + ", perBlock=" + perBlock
				+ ", searchName=" + searchName + ", searchValue=" + searchValue + ", userId=" + userId + "]";
	}
	public List<MyBoardDTO> getList() {
		return list;
	}
	public void setList(List<MyBoardDTO> list) {
		this.list = list;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public static int getPerCount() {
		return perCount;
	}
	public static void setPerCount(int perCount) {
		PageDTO.perCount = perCount;
	}
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
}
