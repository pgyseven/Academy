package com.mbcac.ControlStatement;


import java.util.*;
public class ControlStatement {
	//Control Statement 연습
	public static void main(String[] args) 
	
	{
		/*
		// if, switch , for, while
		//if, switch : 조건문
		//for, while : 반복문
		int n = 5;
		if(n%2==0) // 해석 만약에 ()가 참이면! if(n%2==0) 해석 만약에 짝수 라면!  (비교, 논리) 괄호안은 조건이 온다 조건은 True, flase 만 오면되 즉 논리값 / boolean 리터럴 또는 표현식만 오면된다.
		{
			//if 바디는 트루 일때만 실행됨 즉 컨디션이 true 일때만 돌아가는 집합이 if의 블록이다. 
			System.out.println("짝수");	
		}
		else //위에게 아니라면 즉 현재는 짝수가 아니라면 
		{
			System.out.println("홀수");	
			//if문의 블럭은 하나만 돌아야한다. if가 돌거나 else 가 돌거나
		}	
		
		
		//로그인 결과를 화면에 표시할 때 "로그인 성공", "로그인 실패" 표시해보세요.
		String s1 = "smith";
		String s2 = "1234 ";
		
		if(s1.equals("smith")&&s2.equals("1234"))
		{
		System.out.println("로그인 성공");	
		}
		else
		{
		System.out.println("로그인 실패");		
		}
		
			
		// 무작위 수를 추출하는 방법
		Random rd = new Random(); //무작위 기능이 있는 렌덤
		//rd.nextInt(); //이자리에 정수를 불러줌 우리가 전혀 제어하지 않은 임의에 숫자가 나올거임
		int n =rd.nextInt(10);   //0~9중에서 1개를 무작위 선택 Int 져 중에서 bound 붙은거임 (inclusive) and the specified value (exclusive),)
		//무작위로 추출된 정수가 홀수/짝수인지 구별하여 화면에 표시해보세요.
		System.out.print(n+"는 ");	
		
		if(n%2==0) System.out.println("짝수");	
		else  	   System.out.println("홀수");		

		System.out.println();			
		System.out.println("프로그램 종료");	
		
		
		
		// 다중조건을 다루는 if, else if, else if, .....(반복), else
		int n = 0;
		if(n==0)
		{
			//
		}
		else if(n==1) 
		{
			//
		}
		else if(n==2)
		{
			//
		}
		else
		{
			// 위의 조건이 모두 맞지 않은 경우
		}
		
		// 자바에서 달력보는 방법
		Calendar cal = Calendar.getInstance();//달력은 좀 특이해서 new Calendar 라고 하지 않는다. 그레고리언 역법 , 각나라마다 다를 수 있으므로 즉 현지 달력이 만들어 진다고 보면됨
		int y = cal.get(Calendar.YEAR); //가져올때 get 괄호안에서 점찍으면 년가 아니면 다른걸 가져올 수 있다, 자 이게 표현식이죠? 그럼 표현식은 마우스 올리고 그게 실행되면 리턴값이 정수가 되니깐 그걸 기억해야지 메모리 해야지 이걸 생각해야한다.
		int m = cal.get(Calendar.MONTH)+1;//프로그램들이 시작을 0으로 하기 때문에 1월이 0월로 생각해서 1을 안더하면 0월로 시작함
		int d = cal.get(Calendar.DAY_OF_MONTH);
		int dw = cal.get(Calendar.DAY_OF_WEEK); // 일요일이 1 현재 목요일이니 실행하면 5요일임 (전통적으로 월만 0월 부터 시작) 근데 자바만 그러기도함 자바의 특징이라고 받아들이자.
		
		String sDay =  null;
				
		if     (dw==1) sDay="일";	
		else if(dw==2) sDay="월";	
		else if(dw==3) sDay="화";	
		else if(dw==4) sDay="수";	
		else if(dw==5) sDay="목";	
		else if(dw==6) sDay="금";	
		else if(dw==7) sDay="토";	
	
		
		
		System.out.printf("%s년 %s월 %s일 %s요일%n", y,m,d,sDay);		
		System.out.println("프로그램 종료");	

		
		
		// Switch (분기한다. 바꾼다.)
		Calendar cal = Calendar.getInstance();//달력은 좀 특이해서 new Calendar 라고 하지 않는다. 그레고리언 역법 , 각나라마다 다를 수 있으므로 즉 현지 달력이 만들어 진다고 보면됨
		int y = cal.get(Calendar.YEAR); //가져올때 get 괄호안에서 점찍으면 년가 아니면 다른걸 가져올 수 있다, 자 이게 표현식이죠? 그럼 표현식은 마우스 올리고 그게 실행되면 리턴값이 정수가 되니깐 그걸 기억해야지 메모리 해야지 이걸 생각해야한다.
		int m = cal.get(Calendar.MONTH)+1;//프로그램들이 시작을 0으로 하기 때문에 1월이 0월로 생각해서 1을 안더하면 0월로 시작함
		int d = cal.get(Calendar.DAY_OF_MONTH);
		int dw = cal.get(Calendar.DAY_OF_WEEK); // 일요일이 1 현재 목요일이니 실행하면 5요일임 (전통적으로 월만 0월 부터 시작) 근데 자바만 그러기도함 자바의 특징이라고 받아들이자.
		
		String sDay =  null;
			
		switch(dw) //변수가 올 수 있다 ()값에 따라서 이걸 실행할거냐 저걸 실행 할거냐, 스위치는 if 값에 따라 분기 된다.
		{
		case 1:// 해석 a가 0인 경우 즉 케이스가 경우 !!!로 해석 ! 형식이니 지켜야 한다
			sDay="일";
			break;
		case 2:	
			sDay="월";	
			break;
		case 3:	
			sDay="화";	
			break; // 이걸 안써주면 엔트리 포인트 이후 다 실행 되지 않고 한 케이스만 실행된다.
		case 4:	
			sDay="수";	
			break;
		case 5:	
			sDay="목";	
			break;
		case 6:	
			sDay="금";	
			break;
		default://그 이외의 경우
			sDay="토";	
			
			//케이스의 경우 블럭이 없기에 한블럭 안에 있는 케이스 전체가 쭉 실행되어 버린다 / 케이스가 엔트리 포인트가 된다 즉 진입점이 된다.
			//case는 집입점이다. case 2이면 2가 돌아가고 그 하위게 다 돌아간다. 즉 엔트리 포인트고 로직이 시작되는 시작점이다.
		}
		
		// 요일을 스위치 버전으로 바꿔라
		
		
		System.out.printf("%s년 %s월 %s일 %s요일%n", y,m,d,sDay);	
			
		
		
		//반복문(for(), while, do~while, ) 3가지다 사실 두가지 인데 하나에서 가지치기 되어 3개가 된다.

		
		boolean go = true;
		int cnt = 0;
		while(++cnt <= 10) //괄호 안은 조건식 boolean값이 와야한다. 즉 불리언 값이나 표현식이 와야한다.리터럴이 올 수도 있지만 표현식이 오는게 대부분이다 왜냐면 트루면 실행하고 아니면 나가니깐
		{
		//조건이 ture일 경우에만 실행되는 블럭
			System.out.print(cnt + " "); //" "는 그냥 공백 준거다 가독성을 위해서
		// while은 반복문이니 블럭 안을 실행하고 다시 wile가 true 인지 재차 확인하고 블럭안을 실행하고 다시 ()안의 갑을 확인하고 false가 될 때까지 무한 반복 / 만약 괄호 안이 (ture) 이렇게 리터럴이 들어가면 상수니깐 절대 못나간다. 즉 프로세스가 돌아가는 중에는 ()를 바꿀수 없다 즉 꺼야한고 생각해 볼 숭 있다  ()리터럴로 쓰면 아래 System out 은 에러(Unreachable code)인데 그 프로그램을 절대 사용 못하기 때문이다.근데 위에 boolean go = ture; 넣으면 같은 결과지만 에러는 사라진다. 
			if(cnt == 10) go = false; // cnt 카운트라는 의미로 ++cnt가 if 문에 사용되기 전에 플러스 해라
			//System.out.print(cnt + " ");
		
		}
		
		
		
		//20부터 0까지 정수 중에서 짝수만 골라서 화면에 표시해보세요.
		

		int i = 20;
		while(true) 
		{


			if(i%2==1) //홀수일 때
			{
				--i;
			 continue; //아래 부분을 실행 하지 말고 루프는 계속 돌아라
			 
			}
			System.out.println(i + " "); 
			
			//if(--i<=0)break; //이렇게 하면 0 나오고
			if(i<=0)break;
			i--; //위에 한줄 포함 이렇게 하면 0은 제외됨
		}
		

		//1~30까지의 정수 중에서 3의 배수와 7의 배수를 제외한 모든 홀수를 
		//화면에 표시해보세요. continue, break 활용
		
		
		int i = 0;
		boolean go = true;
		while(go) 
		{
		if(++i>30) break;
		if(i%3==0||i%7==0||i%2==0) continue;
        System.out.println(i + " "); 
		}
		
		
		
		//Random 클래스를 사용하여 무작위 숫자를 구하고(1~50)
		//그 중에서 홀수만 골라서 5개만 화면에 표시해보세요
		Random rd = new Random(); 
		int cnt = 0;
		while(cnt<5) 
		{	
			int rdNum =rd.nextInt(50)+1;
			if(rdNum%2==1) 
				{
				System.out.println(rdNum + " "); 
				cnt++;
				}
		}
		
		// 키보드에서 아이디, 암호를 입력 받아서 로그인을 수행하고
		// 성공하면 프로그램을 종료하고, 실해할 경우에는 3번까지 다시 로그인 할 수 있도록 한다.
		// 3번 동안 실패하면 10분 후에 다시 시도하도록 안내하고 종료한다.

		Scanner kbd = new Scanner(System.in); 
        System.out.print("아이디 암호:");
        String uid = kbd.next();
        String pwd = kbd.next();
        
		boolean go = true;
		boolean suc = uid.equals("tim") && pwd.equals("123");
		
		boolean go2 = go != suc;

		int i = 0;
		
		while(go2) //단순히 suc에 ! 느낌표를 붙이면 
		{	if(i>2) break;
		     System.out.print("다시해:");
			System.out.print("아이디 암호:");
	        String uid2 = kbd.next();
	        String pwd2 = kbd.next();
	
			if(uid2.equals("tim") && pwd2.equals("123"))
			{
		        break;
			}
			else
				{								
				++i;
			
				continue;
				}
		}


	      Scanner kbd = new Scanner(System.in);
	      int failed = 0;
	      while(true){
	         System.out.print("아이디 암호:");
	         String uid = kbd.next();
	         String pwd = kbd.next();
	         if(uid.equals("smith") && pwd.equals("1111")){
	            System.out.println("로그인 성공");
	            break;
	         }else{
	            failed++;
	            if(failed==3){
	               System.out.println("10분 후에 다시 시도하세요");
	               break;
	            }
	         }
	      }

		
		// 무작위 숫자(1~20사이)를 하나 추출하여 그 숫자부터 0까지 내려가면서
		// 정수들을 합산하고 그 결과를 화면에 표시해보세요
		// sum +=i;
		// 출력예시: 5~0까지 합산결과 =15
		
	
	      Random rd = new Random();
	      int begin =rd.nextInt(20)+1; 
	      int i = begin;
	      int sum = 0;

	      while(i>0) sum += i--;
	      
	      System.out.printf("%d~1까지 합산결과=%d%n" , begin,sum);
	     
	    
		   System.out.println("프로그램 종료");

		
		int i = 0;
		while(i<5)// 이렇게 하면 비 합리적인게 첫 실행시 i가 안바꼈는데 바꼇는지 확인을 하고 while 로 들어가므로
		{
			 System.out.print(++i);
		}
		
		do//조건이 없이 실행하라 just do , 이게 i값이 변경이 없으면 do를 먼저 하는게 합리적이지만 실직적으로 거의 쓰진 않는다.
		{
			 System.out.print(++i);
		}
		while(1<2); //while 문에 실행 블록이 위로감 즉 그말인 즉슨 do에 따라 실행을 하고 While 검사를 하고 ture면 위에껄 반복 실행 false 때까지

		
		//for 반복문(loop)
		for(;;) //for 이후 꼭 (;;)  while 루프를 좀더 자세히 실행하기 위한  1;2;3 1번을 제일 먼저 실행 그다음 2인데 2는 꼭 boolean 값이 꼭 와야한다. 근데 비워두면 true가 된다 그리고 트루일때만 돌아간다. 그리고 블럭 안이 다 돌고 3번을 실행한다. 그리고 나서 2번이 트루면 다시 블록을 실행
		//1번은 대부분 변수를 생성하는 값을 준다 왜냐면 for 루프중에 1번만 돈다. 3번자리에는 이전에 했던걸 예로 들면 아래에서 반복 작업을 하고 한자리 값을 더하는 등의 행동은 3번에서 한다. 
		//1번은 지역변수 for 루프 안에서만 쓸 수 있다. 한개도 가능하고 여러개의 변수 선언도 가능하다.	
		{
			System.out.println("x");
		}
		
		
		
		}

		
		// 2개의 정수가 화면에 표시될 때 한개의 정수는 1부터 10까지 증가하고
		// 다른 한개의 정수는 10부터 1까지 감소하여 화면에 2개의 정수가 동시에
		// 표시되도록 해보세요.
		
		for(int i=1, n=10; i<=10  ; i++ , n--)
		{
            			
			System.out.printf("(%d, %d) ", i, n);
		}
		
		
		

		
		
		
		   System.out.println("프로그램 종료");
					
		
		
		
		//음수, 양수 전환
		int n = 1;
		n++;
		n *= -1; //양수를 음수로, 음수를 양수로
		n++;
		System.out.println("n="+n);
		//swap 알고리즘
		System.out.println("프로그램 종료");
		
		// 1~10~1 위로 올라갔다가 아래로 for 루프 한개와 위의 음수 양수 전환을 이용하여!
		
		int delta = 1;
		int cnt = 0, bottom_cnt = 0;
		boolean up = true;
		for(int i=1 ; i<=10 ; i += delta ) //&& 안하면 떨어져도 안멈춤 즉 영에 도달하면 끝나게 즉 false 가 뜨면 나가게 하려고 
		{
            
			
			
			if(i==10)
			{
			//if(++cnt==2)break; 
			delta *= -1;
			up = false;
			}
			else if(!up && i==1)
			{
				if(++bottom_cnt==2)break;
				delta *= -1;
				up=true;
			}
			System.out.printf("%d ", i);
		}

		
		
		//1~10 사이의 정수 중에서 무작위로 한개의 정수를 추출하여
		//그 수가 5 일 때만 화면에 표시하고, 총 5개의 5가 표시 되면
		//프로그램이 종료된도록 for루프를 활용해보세요
		//힌트 for 루프안에 while를 넣고 for 루프가 5번 돌면 끝난다.
		
		Random rd = new Random(); 

		int rdNum = 0;
		for(int i=0; i<5 ; i++)
		{   	
		
			
		
				

				System.out.printf(rdNum + " ");
			
		
		}
				*/
		
		
		
		
		// 무작위 홀수(1~10)만 합산해서 더해서 50 넘을 넘을 때까지(루프의 탈출 조건) 채우기 한변수에 무작위 값을 계속넣어서 50 넘어서
		//결과 몇번 합산했더니 결과 몇이 나왔다 최종 합산 수 합산값 출력
		
		
	
		Random rd = new Random(); 

		int cnt = 0;
		int sum = 0;
		for(int rdNum=0; sum<50 ; cnt++)
		{   	
			rdNum=rd.nextInt(10)+1;
			if(rdNum%2==0) continue; //짝수면 합산하지 말아라 다시 뽑아라
			sum += rdNum;

		}
		
		System.out.printf("%d번 합산한 결과 =%d%n", cnt , sum);
		
	}
}