package com.mbcac.oop;

public class Member
{	
		private int num ;
		private String name ;
		private String phone ;
		
		public Member() {} 
		
		public Member(int num, String name, String phone) 
		{
			this.num = num;
			this.name = name;
			this.phone = phone;
		}
		public void showInfo()
		{
				System.out.printf("%d\t%s\t%s\t%n", num, name, phone); 
		}
}


