package com.mbcac.board;

public class BoardVO 
{
	private int bnum;
	private String title;
	private String author;
	private java.sql.Date rdate;
	private String contents;
	private int hits;
	private int parent;
	
	public BoardVO() {}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public java.sql.Date getRdate() {
		return rdate;
	}

	public void setRdate(java.sql.Date rdate) {
		this.rdate = rdate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}
	
}
