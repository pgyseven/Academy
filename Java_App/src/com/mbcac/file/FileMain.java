package com.mbcac.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FileMain {

	public static void main(String[] args) 
	{
		
		//Text file IO(Input, Output)
		//File CRUD
		//공식이 있음
		//Reader, Writer 텍스트 파일에 읽을땐 리더 쓸땐 롸이터
		//FileReader 파일에서 텍스트 데이터를 읽어오는 클래스다.
		//FileWriter : 노드 스트림(말단 스트림) // 스트림은 무언가 흐르게 한다 데이터를 흐르게 한다 글자를 흐르게 한다.
		//한행씩 읽어오려면 BufferedReader, PrintWriter: 필터스트림(가공 스트림)(혼자 못쓰고 노드 스트림이 필요하다.)
		//예외처리(EXception Handling)
		
		
		//RuntimeException 프로그램이 돌아가다가 나는 오류 즉 에러
		
		//System.out.println(4/0); //컴파일 오류는 없다 문법적 오류는 없지만 수학적으로는 오류다 그래서 돌리면 오휴가 난다.
		/* 아래와 같이 에러 나온다.
		Exception in thread "main" java.lang.ArithmeticException: / by zero
		at com.mbcac.file.FileMain.main(FileMain.java:18)
		*/
		/*
		Scanner kbd = new Scanner(System.in);
		boolean go = true;
		while(go)
		{
		System.out.print("정수 2개 입력:");
	
		try { //영어가 입력 되었을때 에어를 막기위해 트라이를 여러군데 하면 지저분하고 많아지니 범위를 넓힌다.
		int a = kbd.nextInt();
		int b = kbd.nextInt();

		
		//
		int c = a/b; System.out.printf("%d / %d = %d %n", a, b, c);
		}
		/*catch(ArithmeticException ae) {
			String msg = ae.getMessage(); //오류의 원인을 받아서 볼수 있다.
			System.err.printf("분모는 0을 사용할 수 없습니다.(%s)",msg); 
		} //여기서 잡히면 나는 무얼 하겠다를 여기에 표현
		catch(InputMismatchException ime) {  //InputMismatchException  이건 에러 메세지에서 가져와서 쓰면된다 클래스 네임이다.
			String msg = ime.getMessage();
			System.err.println("숫자만 입력해라"); 
		}
		catch(Exception ex) { //공통된 조상인 익셉션을 사용하여 위에 두가지 오류를 다 잡을 수 있다 그러나 숫자인지 문자 에러인지 식별은 불가하다.
		//어떤 오류가 발생했는지 모호함
		if(ex instanceof ArithmeticException) { //예외객체가 산술 오류의 객체냐??? 라고 묻는걷 즉 instance는 객체
			String msg = ex.getMessage();
			System.err.printf("분모는 0을 사용할 수 없습니다.(%s)%n",msg); 
		}else if(ex instanceof InputMismatchException) { //이런식으로 윗줄과 이줄처럼 하면 exception ex 만 썻을땜 숫자에러 인지 문자 에러인지 구별 못하던걸 할 수 있다.
			String msg = ex.getMessage();
			System.err.println("숫자만 입력해라"); 
		}
		}
		//kbd.nextLine(); //에러가 있으나 없으나 없으나 아래로 내려오니깐 이것도 실행은 된다. 그럼 파이널리가 왜 필요할까? 심지어 캐치블럭 밖인데! 이런경우 말고 만약 리턴이 있다면 아래는 안돌아 가지만 리턴이 있는경우에도 아래를 꼭 돌리고 싶으면 파이널리를 사용한다.
		
		finally { //에러가 있던 없던 이곳은 돈다 꼭 돌아간다.
			kbd.nextLine();
		}
		}
		*/
		
		//Text file CRUD
		//FileReader / FileWriter : 파일에서 텍스트를 읽어오거나 텍스트파일에 쓰는 기능

		
			//readUptoEnd();
			
			//readBulk();
		
			//readDataLine();
			
		//updateEmp();
		//printEmpList(readEmpObject());
			//addEmp();
		
		//deleteEmp();
		
		searchEmp();
			System.out.println("프로그램 종료");

		
		}
	
	static void printEmpList(List<Emp> list)
	{
		for(int i=0;i<list.size();i++)
		{
		list.get(i).printEmp();
				
		}
	}
	
	
	/** 텍스트파일의 끝까지 읽어서 화면에 표시하기 */
	//위와 같이 별두개 하는 주석은 문서화 주석인데 해당 메소드 호출에 마우스 대면 해당 푸른 주석이 보인다.
	static void readUptoEnd()
	{
	try {
		FileReader fr = new FileReader("C:/test/sample.txt");//""여기 안에 파일경로 넣으면 됨
		//파일을 로드 해야하는데 new로 생성 에러 unhandled exception 밑줄 에러 뜨는데 처리되지 않은 에러가 있다는 뜻 즉 에러가 발생 안 했는데도 예외 처리 하란것
		//위와 같이 언 핸들드 익셉션 나오면 코딩당시부터 컴파일러가 체크하는 경우고 꼭 트라이 캐치로 감싸라는것
		//이런게 보이면 그냥 무조건 트라이 캐치 감싸 에러에 마우스 올려두면 서라운드 머시기 캐치 누르면 자동으로 감싸줌
		while(true)
		{
		int ich = fr.read(); //위의 파일에서 문자 한개를 읽어온다.//읽어오다가 발생하는 에러를 잡겠다 캐치 블럭을 합쳐서 하던지 나눠서 하던지 지금 위에 파일이 없을 시 에러 잡는 것과 현재 여기 읽어오는것의 예외를 잡아야함
		//여기서 read 는 문자 한개 한개이다. 반약 무한 루프로 읽다가 끝내줘야 할때는 -1을 리턴하니 읽어올게 없다는 신호를 받아서 멈출수 있다. //그러다가 파일 끝에 가서는 읽어올게 없는데 읽어올게 없다는 사인을 -1로 리텀해줌 그래서 정수로 보내주는데 리턴을 -1로 해줌 또 여기서 궁금한게 양수는 0이던 1이던 글자일 수 있다 모든 문자는 양수(아스키 코드)이기에 음수로 리턴 
		//위의 설명의 간단한 예로 int a = 'a'; 는 에러없다 즉 문자도 숫자다
		if(ich==-1)break;
		System.out.printf("%c", (char)ich); //ich 숫자를 문자로 표현해라 (char)
		}
		fr.close();//파일은 닫지 않으면 안됨 꼭 닫아야함 메모리에 남기 때문에 메모리를 점유하게 된다.
		} catch (Exception e) {
		
		e.printStackTrace();
		}
	}
	
	/** FileReader가 가진 다수개의 문자를 읽어오는 기능 */
	//cpu가 하드에서 읽어오는데 글자 하나하나는 비효율적 그래서 한번에 가서 한번에 다 담아서 돌아오게~
	static void readBulk()
	{
		try {
			FileReader fr = new FileReader("C:/test/sample.txt");
			
			char[] cbuf = new char[8];
			
			while(true)
			{
				int read = fr.read(cbuf); //몇개를 읽어온다고 리턴한다. 가져올게 없으면 -1 cbuf에 문자열이 들어는 있으니 그걸 문자열로 바꾸면됨 그건 아래서~  //.read 여러개중 이번엔 배열 버전
				if(read==-1)break;
				//System.out.printf("%s%n", new String(cbuf)); //new String(cbuf)  cbuf에 문자열이 들어는 있으니 그걸 문자열로 바꿈
				//여기서 보면 엔터도 읽어오니 엔터도 엔터대로 표시되서 줄바꿈됨 그리고 중복되는 글자가 있는데 이건 8개씩 가져오는데 꼭 8개씩 배수로 있는건 아니니깐 꼭 8개를 채우니깐 즉 메모리는 그전 값을 가지고 있으니 아까 값을 가져오기에 아래와 같이 자바가 다시 반복되는 것이다. 즉 쓰레기로 남은 것도 문자열이 되니 읽어온 만큼만 문자열로 쓰게 하면된다 그건 아래서!
				System.out.printf("%s%n", new String(cbuf, 0 ,read)); //몇번째 부터 출력할거냐 우린 처음부터니깐 0을 준거다 read에는 읽어온 갯수를 리턴 받은양의 숫자가 있으니 그것 만큼 작성하라고 했으니 쓰레기 없다.
			}
			fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * 데이터 파일 행 다루기
	 * C:\eclipse-workspace\Java_Web\src\main\webapp
	 * 데이터 파일의 행 단위로 읽어올 수 있는 BufferedReader 사용
	 * 노드스트림과 필터스트림을 연결하여 기능이나 성능을 향상시킬 수 있다
	 */
	static void readDataLine()
	{
	try {
		FileReader fr = new FileReader("C:/eclipse-workspace/Java_Web/src/main/webapp/emps.txt"); 
		
		BufferedReader br = new BufferedReader(fr); //버퍼는 메모리고 모은다 한행  한행을
		while(true)
		{
		String line = br.readLine(); //한행을 가져와라 //파일의 끝에서는 null 이 나온다.
		if(line==null)break;
		System.out.println(line);
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
	}
	
	/**
	 * 텍스트 파일에서 한행을 읽어서 각 토근으로 쪼갠 후에 Emp 인스턴스를 생성
	 * Emp 인스턴스는 리스트에 담아서 출력전용 메소드에 전달한다.
	 */
	static List<Emp> readEmpObject()
	{
		
	List<Emp> empList = new ArrayList<>();
	try {
		FileReader fr = new FileReader("C:/eclipse-workspace/Java_Web/src/main/webapp/emps.txt"); 
		
		BufferedReader br = new BufferedReader(fr);
		
		
		
		while(true)
		{
		String line = br.readLine(); 
		if(line==null)break;
		String[] tokens = line.split(" "); //공백을 기준으로 해서 쪼개라
		
	
		empList.add(new Emp(tokens));//create construtor
		
		}
		br.close();
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
	return empList;
	}
	/**
	 * 텍스트 파일에 한행 단위로 쓰기(Writing)
	 * PrintWriter(FileWriter) 연결 사용 // 필터스트림임 그래서 노트 스트림과 연결되야함  아까 퍼퍼드 리더를 파일리더로 연결 했던것 처럼
	 * PrintWriter는 다양한 자료형을 문자열로 파일에 쓸 때 유용함(println())
	 * 텍스트 쓰기용 스트림은 Writer를 사용함
	 */
	static void addEmp() {
		String path = "C:/eclipse-workspace/Java_Web/src/main/webapp/emps.txt";
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(path, true));// true 기존 데이터 지워지지 않게 덮어 쓰기 말고 이어쓰기 해라 라는 명령 즉 append mode 이다 마우스 올려서 append 읽어보면 해당 내용 있다. //new FileWriter(path) 생성자에는 어떤 특정 조건이 되면 예외를 던진다.throws던진다 IOException :이미 파일이 있는데 또 쓰면
			//printwriter 한행 한행 써주는 기능됨
			//참고로 run time exception은 컴파일이 체크 안하지만 그이외의 throw 등이 써진 것들은 트라이 켓치를 싸주라고 빨간줄 에러 나옴
			pw.println("16 박지성 pwpark 40 3400 010-5417-2103"); //한행으로 쓰여지고 줄바꿈은 앞에 println의 ln에 의해서 줄이 바뀐다.
			pw.flush();
			pw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * 텍스트 파일에서 특정 내용을 수정하는 것은 지원되지 않아서 다른 방법을 사용한다.
	 * 파일의 전체 내용을 메모리에 로드하여 메모리에서 수정/삭제 한 후에 기존 파일에 덮어쓴다.
	 */
	static void updateEmp()
	{
				
		 List<Emp> list = readEmpObject(); 
		 for(int i=0;i<list.size();i++) { //11번 사원의 급여액을 높이는 경우
			 if(list.get(i).getEmpno()==11) {
				 Emp e = list.get(i);
				 e.setSal( e.getSal()+200);
				 break;
			 }
		 } //메모리에서 수정 완료
		 //메모리에 있는 내용을 기존 파일에 덮어쓴다.
		 String path = "C:/eclipse-workspace/Java_Web/src/main/webapp/emps.txt";
		 try {
			PrintWriter pw = new PrintWriter(new FileWriter(path));
			for(int i=0;i<list.size();i++) {
				Emp e = list.get(i);
				String line=String.format("%d %s %s %d %d %s", e.getEmpno(), e.getEname(), e.getPwd(), e.getDeptno()
						, e.getSal(), e.getPhone()); //스트링 클래스에 포멧 메소드를 이용해서 서식을 가지고 문자를 만들겠다
				pw.println(line); //프린트 롸이트 기능을 이용한거임 프린터 롸이터는 프린트 엔엔 같은걸로 쓰는게 가능하다.
			}
			pw.flush();
			pw.close(); //클로즈만 해도 플러쉬가 자동으로 된다.  성능향상을 위해서 시스템이 바가지에 차지 않으면 밖으로 안부을 때가 있음 우리가 계속 쓴 이유는 머리에 각인 시키기 위해서지만 필요 없다 클로즈만 해라
			System.out.println("파일 내용 수정 성공");
		} catch (IOException e) {
			System.out.println("파일 내용 수정시 오류");
			e.printStackTrace();
		} 
		 
	}
	
	/**
	 * 텍스트 파일에서 특정 아이템 삭제하기
	 * 수정의 예와 같이 텍스트 파일의 모든 내용을 메모리에 로드하여 메모리에서 삭제하고 기존파일을 덮어쓴다.
	 */
	static void deleteEmp()
	{
				
		 List<Emp> list = readEmpObject(); 
		 for(int i=0;i<list.size();i++) { 
			 if(list.get(i).getEmpno()==13) { //13번의 정보를 삭제하는 경우
				 list.remove(i);
				 break;
			 }
		 } //메모리에서 삭제 완료
		
		 //메모리에 있는 내용을 기존 파일에 덮어 쓴다.
		 String path = "C:/eclipse-workspace/Java_Web/src/main/webapp/emps.txt";
		 try {
			PrintWriter pw = new PrintWriter(new FileWriter(path));
			for(int i=0;i<list.size();i++) {
				Emp e = list.get(i);
				String line=String.format("%d %s %s %d %d %s", e.getEmpno(), e.getEname(), e.getPwd(), e.getDeptno()
						, e.getSal(), e.getPhone());
				pw.println(line);
			}
			pw.flush();
			pw.close();
			System.out.println("파일 내용 삭제 성공");
		} catch (IOException e) {
			System.out.println("파일 내용 삭제시 오류");
			e.printStackTrace();
		} 
		 
	}
	
	
	static void searchEmp()
	{
		List<Emp> list = readEmpObject(); 
		// 14번 사원정보 검색
		Emp key = new Emp(14);
		if(list.contains(key)) {
			int idx = list.indexOf(key);
			
			Emp found = list.get(idx);
			System.out.println("검색 결과 :");
			found.printEmp();
		
		}
	}
	/* 텍스트파일 사용한 사용자 정보 CRUD
	 * 프로그램이 시작되면 메뉴가 표시되고 메뉴에 따라 아래의 기능이 실행되도록 한다.
	 * 추가, 목록, 검색, 수정, 삭제, 프로그램 종료
	 * 사용자 번호, 아이디, 암호, 전화, 이메일
	 * user.txt 파일에 사용자의 모든 정보가 입력되고 관리되도록 한다.
	 * User 클래스를 사용한다(텍스
	 * 
	 * 
	 */
	
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Emp
{

	
	private int empno;
	private String ename;
	private String pwd;
	private int deptno;
	private int sal;
	private String phone;
	
	public Emp(String[] tokens) {
		// 위에서 크리에트 컨스트럭트 해서 이게 나온거고 내용물 채운다 우리가
		this.empno = Integer.parseInt(tokens[0]);
		this.ename = tokens[1];
		this.pwd = tokens[2];
		this.deptno = Integer.parseInt(tokens[3]);
		this.sal = Integer.parseInt(tokens[4]);
		this.phone =  tokens[5];
	}
	
	public Emp(int empno) {
		this.empno = empno;
	}
	@Override
	public boolean equals(Object obj) {
		Emp other = (Emp) obj;
		return this.empno==other.empno;
		//return this.ename.equals(other.ename);//문자열 비교할때
	}
	
	public void printEmp() {
		 String line = String.format("%d\t%s\t%s\t%d\t%d\t%s%n", empno, ename, pwd, deptno, sal, phone);
	      System.out.print(line);
	}
}

