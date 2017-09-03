package com.dto;

public class MyBoardDTO {
	//8-22
	private int num;
	private String title;
	private String author;
	private String content;
	private String writeday;
	private int readCnt;
	public MyBoardDTO(int num, String title, String author, String content, String writeday, int readCnt) {
		super();
		this.num = num;
		this.title = title;
		this.author = author;
		this.content = content;
		this.writeday = writeday;
		this.readCnt = readCnt;
	}
	public MyBoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the writeday
	 */
	public String getWriteday() {
		return writeday;
	}
	/**
	 * @param writeday the writeday to set
	 */
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	/**
	 * @return the readCnt
	 */
	public int getReadCnt() {
		return readCnt;
	}
	/**
	 * @param readCnt the readCnt to set
	 */
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", title=" + title + ", author=" + author + ", content=" + content
				+ ", writeday=" + writeday + ", readCnt=" + readCnt + "]";
	}
	

}
