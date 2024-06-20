package com.mbcac.array;

import java.util.*;

public class ArrayCRUD {

	//배열과 메소드에 집중
	public static void main(String[] args) 
	{
		/*
		// CRUD(Create, Read, Update, Delete)
		//     정의 (생성), 읽기, 수정(갱신), 삭제

		int[] num; //베열변수(참조) 선언, 4바이트 (즉 특정크기로 고정되어 있다)// 정수가 안들어감 즉 참조 변수(레퍼런스 스타일)임 메모리의 주소임 그것은 4바이트 빈 그릇임// 배열변수 선언 변수배열 3개의 주소
		num = new int[5]; //정수 4바이트 공간 5개 //메모리를 새로 할당해서 그 주소를 추출해주는 연산자는 new 이다.
		num[0] = 4;
		num[1] = 5;
		num[2] = 2;
		num[3] = 9;
		num[4] = 8; //여기까지가 Create
		
		int n = num[2]; //Read
		System.out.println("num[2] -> " + n);
		
		num[2] = 7; //Update
		num[2] = 0; //Delete
		
		//배열변수 선언, 메모리확보(할당), 초기화, 사용
		String[] name;
		name = new String[5];
		name[0] = "강호동";
		name[1] = "이수근";
		name[2] = "김종민";
		name[3] = "손흥민";
		name[4] = "박세리";

		String nm = name[2]; //Read
		
		name[2] = "박찬호";
		name[2] = null; //참조형이니깐 null 기본형은 0이란던가 0.001 등등 및 false 이런거~
		
		int c = 9;
		int r = c
		*/
		
		//회원관리 프로그램 작성하기
		//번호(숫자), 이름(문자열), 전화번호(문자열), 이메일(문자열)
		//각 정보를 저장할 배열 사용 (원소수 10개)
		//추가(a라고 입력하면 추가라는 기능을 보여주고), 목록(s), 검색(f), 수정(u), 삭제(d), 종료(x) 
		//프로그램이 시작되면 메뉴가 표시된다.
		String mStr = "추가(a), 목록(s), 검색(f), 수정(u), 삭제(d), 종료(x):";
		Scanner kbd =  new Scanner(System.in);
		
	
		while(true)
	    {
			System.out.print(mStr); //메뉴 보여줌
			String m = kbd.nextLine().trim(); //메뉴 선택 //행구분자로 구분되는 엔터까지 불러와서 엔터는 삭제하고 a만 그렇게 하면 다음 입력값에서 안전//엔터값까지 가져오는 기능 한행을 다 가져와라 한행의 구분은 enter 이다.  //a라고 누르고 엔터를 칠텐데 next 로 부르면 메모리에 엔터값이 남을 것 이다. 이런경우 엔터가 나중에 문제가 된다(다른걸 입력하면 엔터값 다음에 입력된다.)		
		
			if(m.equals("x"))break; //종료
		
			else if(m.equals("a")) addMember(); //회원정보 추가 
			else if(m.equals("s")) list(); 
			else if(m.equals("f")) find();
			else if(m.equals("u")) update();
			else if(m.equals("d")) delete();
		}
		System.out.println("프로그램 종료");	
	}
	static int[] ids = new int[10];
	static String[] names = new String[10];
	static String[] phones = new String[10];
	static String[] emails = new String[10];
	static int idx; //맴버변수는 자동 초기화
	
	public static void addMember()
	{    
		Scanner kbd = new Scanner(System.in);
		System.out.printf("번호 이름 전화 이메일:");	
		
		int no = kbd.nextInt();
		String name = kbd.next();
		String phone = kbd.next();
		String email = kbd.nextLine();
	
		ids[idx]= no;
		names[idx] = name;
		phones[idx]= phone;
		emails[idx] = email;
		idx++;
		System.out.println("회원정보 추가 성공");
	}
	
	public static void list()
	{    
		for(int i=0;i<idx;i++)
		{
			System.out.printf("%d\t%s\t%s\t%s\t%n", ids[i],names[i],phones[i],emails[i]); // \t으로 이름이나 특정 글자 범위에 따라서 가독성 좋게 하기 위하여
		}
	}
	
	
	public static void find()
	{    
		Scanner kbd = new Scanner(System.in);
		
		System.out.print("번호로 검색(n), 이름으로 검색(m):");
		String find = kbd.nextLine().trim();
		int findIndex = -1;// 찾았는지 못 찾았는지의 기준
		
		if(find.equals("n")) {
			System.out.print("검색활 회원번호");
			int no = kbd.nextInt();
			for(int i=0;i<idx;i++) {
				if(ids[i]==no)
					findIndex = i;
					break;
			}
		}else if(find.equals("m")) {
			System.out.print("검색활 회원 이름:");
			String name = kbd.next();
			for(int i=0;i<idx;i++) {
				if(names[i].equals(name)) {
					findIndex = i;
					break;
				}
			}
		}
		kbd.nextLine(); // 키보드 입력 버퍼에 남아있는 enter 값을 버린다. n 이나 m을 안누르고 다른걸 누르면 이부분이 필요 없지만 만약 이프문 안으로 들어가면 next() 이기에 Line으로 엔터값 안떨어주기에 여기에서 떨어주고 가는 것 이다.
		if(findIndex==-1) {
			System.err.println("회원검색 실패");
			return;
		}
		System.out.printf("%d\t%s\t%s\t%s\t%n", ids[findIndex],names[findIndex],phones[findIndex],emails[findIndex]);
	}
		
	public static void update()
	{    
		//업데이트할 회원번호 입력
		//새 전화번호
		Scanner kbd = new Scanner(System.in);
		System.out.print("회원번호 새전화번호:");
		int no = kbd.nextInt();
		String newPhone = kbd.nextLine().trim();
		//ids 배열에서 회원번호를 찾아서 그 인덱스를 사용하여 전화번호 수정

		System.out.print("검색할 회원번호");
	
		for(int i=0;i<idx;i++) 
		{   
			if(ids[i]== no) 
			{   
				phones[i] = newPhone;
				System.out.println("새 전화번호로 수정 성공");
				break;
			}
		}
	}

	public static void delete()
	{    
		//삭제대상 회원번호 //참고로 삭제가 빈번한 구조에는 배열을 안쓴다.
		//11 smith 010-5478-6210 smith@g
		//12 james 010-5478-9541 james@n
		//13 waard 010-5478-6514 waard@y
		Scanner kbd = new Scanner(System.in);
		System.out.print("삭제대상 회원번호:");
		
		int no = kbd.nextInt();
		kbd.nextInt();
	
		//삭제할 정보가 저장된 인덱스 확인
		int delIndex = -1;
		for(int i=0;i<idx;i++) 
		{   
			if(ids[i]== no) 
			{   
				delIndex = i;
				break;
				

			}
		}
		for(int i=delIndex;i<idx-1;i++)
		{
			ids[i] = ids[i+1];//삭제대상 방에 우측방의 값을 덮어쓴다.
		names[i] = names[i+1];
		phones[i] = phones[i+1];
		emails[i] = emails[i+1];
		}
	
		idx--;
		if(delIndex>-1)System.out.println("회원정보 삭제 성공");
		else System.err.println("회원정보 삭제 실패");
		
	}
	
	
		
	

}
