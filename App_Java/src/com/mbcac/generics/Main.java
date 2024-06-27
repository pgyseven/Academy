package com.mbcac.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.print("첫번째 숫자 입력:");
		int call = kbd.nextInt();

		List<String> list = new ArrayList<>();
		list.add("smith");
		list.add("scott");
		list.add("james");
		list.add("laura");
		list.add("lynda");
		list.add("andy");
		list.add("king");
		list.add("julie");

		// List<String> page1 = list.subList(0,2); // 1페이지당 2개씩 추출할 때

		Pagination<String> pg = new Pagination<>(list); //<> 자료형 이렇게 하면 아래 클래스 생성되면서 자료형을 이걸로 결정하는 것

		List<String> pg1 = pg.getPage(call); //기본생성자는 안생성해도 자동지원이니 this.list 만 만들면된다.
		
		printPage(pg1);

	}

	private static void printPage(List<String> pageList) {
		for (String item : pageList) {
			System.out.println(item);
		}
	}
}
//자료형이란 뜻으로 T를 많이 쓴다 pagination 쓸때 자료형을 특정한다 아직은 특정되지 않았다 여기서 T 자리에 자료 형이 들어간다.
class Pagination<T>//Generics일반화 
{
	private List<T> list; //여기서 자료형을 특정하면 사용 범위가 작다 자료형은 위에서 정해주면 정할거야! 해야지 쓸모가 있다. 자료형을 일반화 해야한다.
	//리스트는 일반화 되어 있다 즉 원래도 모든걸 다 받을 수 있다 즉 스트링이 아닌 보드같을걸 해서도 이것 저것 받을 수가 있다. 
	private int cnt = 2;

	public Pagination(List<T> list) {
		this.list = list;
	}

	public List<T> getPage(int pg) {
		int from = (pg-1)*cnt;
		int end = pg*cnt;
		return list.subList(from, end); //여기서 end 는 포함 안된다 스탑이다 참고로 파이썬에서는 스탑인자이다.즉 0~1이면 1은 비포함이다.
	}



}
