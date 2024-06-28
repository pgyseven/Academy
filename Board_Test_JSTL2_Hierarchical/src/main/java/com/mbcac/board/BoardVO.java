package com.mbcac.board;

import java.sql.Date;

public class BoardVO {

	private int bNum;
	private String title;
	private String author;
	private String contents;
	private java.sql.Date rDate;
	private int hits;
	private int parent;

	public BoardVO() {

	}

	public BoardVO(int bNum, String title, String author, String contents, Date rDate, int hits) {
		super();
		this.bNum = bNum;
		this.title = title;
		this.author = author;
		this.contents = contents;
		this.rDate = rDate;
		this.hits = hits;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public java.sql.Date getrDate() {
		return rDate;
	}

	public void setrDate(java.sql.Date rDate) {
		this.rDate = rDate;
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
