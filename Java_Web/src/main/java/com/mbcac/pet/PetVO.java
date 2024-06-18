package com.mbcac.pet;

public class PetVO {
	
	private int no;
	private String sName;
	private int year;
	private int price;
	private float weight;
	
	public PetVO() {}

	public PetVO(int no, String sName, int year, int price, int weight) {
		this.no = no;
		this.sName = sName;
		this.year = year;
		this.price = price;
		this.weight = weight;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight2) {
		this.weight = weight2;
	}
	
}
