package com.mbcac.pet;

public class PetVO {
	
	private int no;
	private String name;
	private int year;
	private int price;
	private float weight;
	
	public PetVO() {}

	public PetVO(int no, String name, int year, int price, float weight) {
		this.no = no;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setWeight(float weight) {
		this.weight = weight;
	}


	
}
