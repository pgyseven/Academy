package com.mbcac.operator;

import java.util.Scanner;

public class OperatorTest 
{

	public static void main(String[] args) 
	{
		
		/*
		Scanner kbd = new Scanner(System.in);
		System.out.print("알파벳 입력:");
		String s = kbd.next();
		char ch = s.charAt(0); // index(색인번호)를 이용한 문자 추출
		
		
		//Literral, Expression(표현식)
		int price; // 메모리 할당(확보)
		price = 32000; //Literal, 상수(constant) :코드를 사용하여 변경 불가
		System.out.println(price); // Expression(표현식)

		int total = price * 3;
		
		
		String s = "Hello World";
		//char ch = s.charAt(6);
		//System.out.println("가져온 문자=" + ch);
		//boolean yes = s.contains("Wo");
		// 'Wo' 가 포함되어 있다/없다	
		//String result = yes ? "포함됨" : "없음";
		//System.out.println("Wo가 포함되어 있나?" + result); 
		int idx = 0;
		char ch = s.charAt(idx);
		int unicode = s.codePointAt(idx);

		System.out.printf("%c 의 unicode= %d %n",ch,unicode); 
		
		
		String s = "Hello World";
		
		char ch = 'W' ;
		int idx = s.indexOf(ch);
		
		System.out.printf("%c의 색인번호= %d%n", ch,idx);
		
		
		
		String s = "Hello World";
		
		String l = s.toLowerCase();
		String u= s.toUpperCase();
		//원문의 대/소문자를 화면에 표시해보세요
		System.out.printf("소문자는 %s, 대문자는 %s", l,u);
		
		
		String uid = "Smith";
		//문자열의 동등성 판단
		//1==2
		
		boolean yes = uid.equals("Heollo");
		String result = yes ? "같다" : "다르다";
		//Smith와 Hello 는 같다/다르다
		System.out.printf("%s 와 Hello 는 %s", uid,result );
		
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("정수 두개를 입력:");
		int n1 = kbd.nextInt();
		int n2 = kbd.nextInt();
		
		//Wrapper Class : 기본자료형에 대한 정보나 기능을 제공하는 클래스
		int n3 = Integer.max(n1, n1);
		//키보드에서 정수 2개를 받아서 그 중 큰 수를 추출하여
		//
		System.out.printf("%d 와 %d 중에서 화면에 표시할 때, 5,3 중에서 큰 수는 5입니다.큰 수는 %d 입니다.", n1,n2,n3 );
		
		
		
		String uid = "james";
		String pwd = "112233";
		Scanner kbd = new Scanner(System.in);
		System.out.print("아이디 암호:");
		String inUid = kbd.next().trim();
		String inPwd = kbd.next().trim();
		
		boolean idOk = uid.equals(inUid);
		boolean pwdOk = uid.equals(inPwd);
		
			System.out.printf(idok && pwdok ? "로그인 성공" : "로그인 실패");
		kbd.close();
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("문자 두번 입력:");
		String tx = kbd.next();
		String tx1 = kbd.next();

		


		int sum = Integer.valueOf(sNum1) +  Integer.parseInt(sNum2);
		
		System.out.printf("%s + %s = %d%n", sNum1,sNum2,sum );

		//kbd.next(); 숫자를 읽어올 때 사용할 메소드
		//키보드에서 숫자를 입력하면 그 숫자를 읽어올 때 문자열로 읽어온다.
		//우와 같은 방법으로 숫자 2개를 받아서 덧셈을 하고 그 결과식을 화면에 표시한다.
		
		
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("정수입력:");
		int num = kbd.nextInt();
		String bs = Integer.toBinaryString(num); // 10 -> 1010
		//키보드에서 정수를 입력 받아서 해당 수의 이진수 문자열을 표시해보세요.
		//System.out.printf("10진수 %d의 2진수 %s",num,Integer.toBinaryString(num));
		//위에서 생성된 bs(2진수 문자열)를 다시 10진수로 변환하여 2를 곱해서 결과를 표시
		
		int res = Integer.parseInt(bs,2)*2;
			//bs 2진수 문자열임을 표시 즉 2진수 문자열 bs를 int 정수로parse 변환해줘
		System.out.println("결과" + res);
		
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("글 입력:");
		String ch1 = kbd.next();
		
		char ch = ch1.charAt(0); 
		int s = ch;
		

		
		boolean a = Character.isAlphabetic(s);
		String b = a== ? "영문자" : "한글문자";
		
		//Character.isDigit(0);
		//Character.isLetter(0);
		System.out.printf("%s는 %s 이다", a,b);
		//int n = Integer.parseInt(tx);
		//키보드에서 문자 1개를 입력하고 그 문자가 영문자인지 한글인지 구분하여
		//그 결과를 '가'는 한글문자, 'A' 는 영문자 
		
		
		
		//산술, 비트, 비교, 논리, 할당, 3항
		int n = 1;
		String res = n==1 ? "1" : n==2 ? "2" : n==3 ? "3" : null;
		System.out.println(res);
		
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("영문자 혹은 숫자 혹은 한글문자 입력:");
		
		String s = kbd.next();
		int code = Character.codePointAt(s, 0);
		
		String res = code>=65 && code<=122 ? "영문자" : code>=48 && code<=57 ? "숫자" : "한글";
		
		System.out.println(code + ":" + res);
		
		
		// 할당 연산자(Assignment operators)
		
		int a = 0;
		String s = "";
		s = "Hello";
		s +="World";
		//s = "World"; // Hello 오브젝트는 Garbage collector에 의해서 메모리에서 제거
		System.out.println(a+1);//The local variable a may not have been initialized(초기화)즉 초기화 되지 않은 그말인즉 int 에 초기화 0을 넣지 않음 
		System.out.println(s+"Hello");
		
		int num = 0;
		num += 1;
		num += 1;
		num += 1;
		num ++;
		
		num = 10;
		num -=1;
		
		num *= 2;
		num /=2;
		num %=2;
		
		//비교연산자(Compatison Operators)
		// <, >, <=(이하), >= (이상), ==, !=     : boolean 값을 리턴한다. 
		
		System.out.println(1<2); //결과값 ture
		System.out.println(1 != 2); //결과값 true
		
		// 키보드에서 2개의 정수를 입력 받아서
		// 숫자의 크기를 비교했을 때 첫번째 입력 값이 큰지 작은지를
		// 문자 열로 표시해보세요. 예) 첫번째 값이 큽니다
		// 반드시 비교 후에 출력문에서는 결정된 문자열만 표시하도록 해보세요(즉 출력문에서 비교하지 마라)
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("정수 두개 입력:");
		
		int n1 = kbd.nextInt();
		int n2 = kbd.nextInt();
		
		boolean comp = n1 > n2;
	
		String s = "첫번째 값이 더";
		s += comp ? "큽니다." : "작습니다.";
		
		System.out.printf(s);
		
		
		//논리연산자(Logical Operators)
		// &&(AND), ||(OR), ^(XOR,Exclusive OR), !(Not)
        // 1항, 2항, 3항  연산의 대상이 몇개이냐에 따라서
		1 + 2; //2항 연산자
		int n = 0;
		n++; // 1항 연산자 ++대상자가 1나 뿐이라 즉 ++이외에 두개가 필요없어서
		Strings = n!=5 ? "aaa" : "bbb" ; // 3항 연산자
		*/
		
		
		/*
		boolean res = true && true; //좌우 값이 논리 값이여야 함, 다른건 관심 없다 둘다 트리인지만 체크 하나의 불리언 표현식이다.
		String s = "Smith";
		String s2 = "james";
		// s == s2; 이건 될 때가 있고 안될 때고 있다 문자는 안하는게 좋다. 참조형 변수이다 즉 주소만 들어있는거니 주소 비교로 진행하는 거니 안맞을 수 있다 스미스가 두개 있는데 점유 주소가 되어 비교가 안되니깐
		boolean res = s.equals(s2); //이것도 결과는 T / F 로 나올테니 boolean으로 인식할 수 있다. 이렇게 해야지 문자열 내용 비교가 된다.
		*/
		/* 키보드에서 아이디와 암호를 입력 받아서 아이디가 "Laura", 암호가 "12345" 인지
		 * 검사하고 그 결과 아이디와 암호가 모두 일치하면 "로그인 성공", 아니면 "로그인 실패"
		 * 를 표시해 보세요

		
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("아이디, 비번:");
		
		String uid = kbd.next();
		String pwd = kbd.next();

		boolean success = uid.equals("Laura")&&pwd.equals("12345")
		String msg = success ? "로그인 성공" : "로그인 실패";

		System.out.println(msg);
			
		// 논리 OR(Logical OR operator), ||, 2항 연산자, 한쪽이 트루면 트루(최소 한개가 true면 됨)
		
		true || true; //ture
		true || false; //ture
		false || true; //ture
		false || false; //false
		
		//키보드에서 문자를 입력 받을 때 영문, 숫자 아니면 그 이외의 경우인지 검사
		//입력된 문자를 유니코드로 변환하여 영문 범위이거나 숫자 범위라면 "유효한 값"
		//그 이외의 문자라면 "무효한 값" 으로 화면에 표시해 보세요

		
		Scanner kbd = new Scanner(System.in);
		System.out.print("입력:");
		
		String inCh = kbd.next();
		int unicode = Character.codePointAt(inCh, 0);
		boolean eng = unicode>=65 && unicode<=122;
		boolean digit = unicode>=47 && unicode<=55;
		
		String msg = eng||digit ? "유효한 값" : "무효한 값";
		System.out.println(msg);
		
		
		// &&, || : 단축논리AND
		
		boolean tmp = true||true; //true
		
		//XOR(배타적 OR(즉 양쪽이 배타적이야한다. 양쪽이 달라야 한다.), ^ 
		tmp = true ^ true;
		System.out.println(tmp); //false
		 
		
		//!true 
		//! 논리 부정 연산자
		int n = 4;
		boolean even = n%2==0; // n이 짝수인가? (even 짝수)
		//만약에 값이 홀수인 경우에만 "유효한 값"으로 표시하려고 한다
		String res = !even ? "유효한 값" : "짝수" ; //이렇게 해야 직관적이다.  !의 연산자가 even 하나니깐 !even은 1항 연산자이다
		
		
		
		//아이디, 암호를 키보드에서 입력받아서 'smith' , '1234'가 아닌경우에만
		//아이디와 암호를 다시 검사하고 입력해주세요.
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("아이디 비번:");
		
		String uid = kbd.next();
		String pwd = kbd.next();
		boolean success = id.equals("smith")&&pw.equals("1234");
		String msg = !success ? "아이디, 암호를 다시 검사해주세요" : "";
	
		System.out.println(msg);	
		*/
		
		
		//산,비,논,할,3,비트
		
		//비트 연산자 (embedded, 하트웨어)
		
		//비트 이동 연산자(Shift Operators)
		
		//System.out.println(10 >> 1); //결과값은 5다! 비트를 오른쪽으로 옮겨라 뜻이다.  10은 1010 이라는 숫자를 가지고 있다 이걸 오른쪽으로 1 옮겨라 그러면 결과가 5가 나온다. 1010 옮기면 101된다 즉 절반이 된다 반대로 왼쪽으로 가면 배수로 올라간다.
		//10/2^1(1의 숫자는 오른쪽으로 몇번가냐에 따라서)
		//10*2^1(이건 왼쪽으로 갔을경우)
		//즉 비트 이동은 수학식으로 대체할 수 있다. 그러나 비트 이동하는게 연산이 빠르다. 그러나 실제 코딩에는 이런 비트 연산자로 수식을 만들진 않음
		//LED 제어할때 비트 이동을 쓸수 있음
		
		
		//비트 반전 연산자() 1을0으로 0을 1로
		//System.out.println(~10); //결과값 -11다! 10은 integer 4비트 2^4 =32비트이니 1과 0을 반전
		
		// 정보처리 (Information Processing)
		// 정보?
		// 처리? : 연자, 제어문, API(응용프로그래밍 할때 접해야하는 소재들(Application Programming Interface)(CLASS(int system 이런 자바가 미리 제공해주는 프로그램을 말한다. ))
		
		
	}

}
