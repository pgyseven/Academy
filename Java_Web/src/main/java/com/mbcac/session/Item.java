package com.mbcac.session;

public class Item 
{

	private String gname;
	private int price;
	private int qty = 1;
	
	public Item() {}
	public Item(String gname, int price)
	{
		this.gname = gname;
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		Item other = (Item)obj;
		return this.gname.equals(other.gname) && this.price == other.price;  //비교의 기준 제시
	}
	
	
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
