package com.mbcac.oop;

import java.util.Scanner;

import com.mbcac.ClassEx.Pet;

public class OOP_Concept 
{

	static int cnt; //맴버 변수 , 메소드 안에서도 접근 가능 //여기서도 보면 static이니 하위에 static 써 있는 곳에서도 사용할 수 있다고 생각해라 
	static Member[] mems = new Member[3]; //참조형 배열 주소를 담는 배열
	static Scanner kbd =  new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		//클래스, 생성자, 인스턴스 실습
		/*키보드에서 3인의 회원정보를 입력하여 배열에 저장하고
		 * *그 배열을 출력전용 메소드에 전달하여 목록이 화면에 표시되도록 해보세요.
		 * 회원정보 속성 : 번호, 이름, 전화
		 * 실물객체(Member)를 추상화하여 클래스를 정의하고
		 * 생성자, private, setters, getters 메소드를 활용해보세요.
		 */
		
		for(int i = 0;i<mems.length;i++)
		{
			System.out.print("번호 이름 전화");
			int num = kbd.nextInt();
			String name = kbd.next();
			String phone = kbd.nextLine();
			//Member m = new Member(num,name, phone)
			mems[cnt++] = new Member(num,name,phone);//주소를 리턴 받는다. //바로 주석으로 된 윗줄보다 이렇게 하는게 성능에 좋다 한줄이 주는거니깐
		}
		memList(mems);
		
		System.out.println("프로그램 종료");	
	}
	
	static void memList(Member[] m) 
	{
		for(int i = 0;i<m.length;i++)
		{
			m[i].printMem();
		}
	}

		
}

class Member
{
	private int num;
	private String name;
	private String phone;
	
	public Member() {} //파라미터가 없는 기본 생성자는 항상 해주는게 좋다 //나중에는 이 생성자도 자동 생성되게 할거다 이클립스 기능으로 그럼 그때는 변수만 신경쓰면 된다.
	public Member(int num, String name, String phone)
	{
		this.num = num;
		this.name = name;
		this.phone = phone;
	}
	public void printMem()//출력용 메소드
	{
			System.out.printf("%d\t%s\t%s\t%n", num, name, phone); 
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

