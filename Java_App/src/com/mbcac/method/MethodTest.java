package com.mbcac.method;

import java.util.*;

public class MethodTest 
{

	public static void main(String[] args) 
	{
		/*
		//무작위 숫자를 2개 추출하여 덧셈을 하고 그 수식을 화면에 표시한다 //즉 필요할때 불러쓰는 메소드를 만든다.
		//addExp();//이름을 불러주는게 호출이다. 호출(Invocation, call)
		//addExp(3,5); //실인자(인자는 전달된다) argument논쟁이지만 왜 실인자인지 모르겠다고 하심 argument 라 하면파라미터 안으로 들어가는 실제값이라 생각해라 // 파라미터를 준 매소드 호출 (앞에서 부터 순서대로 들어간다.
		//gugu(5);
		//int sum = add(3,5); //이 호출은 표현식이다. 그리고 이것의 메소드는 void가 안붙는다.
		//System.out.printf("합계=%d%n",sum);
		//int max = getMax(5,8);
		//System.out.printf("큰값=%d%n",max);
		
		//Method : 특정 문제를 해결하기 위한 한가지 방법 //각방법론
		//코드의 재활용성을 높인다, 유지보수성, 신뢰성, 즉, 덜 코딩 //필요할때마다 이름만 부르면 몇번이던 재사용이 가능하다는 이야기. 다른 클래스에서도 해당 메소드를 쓸수도 있다. //고장이 있다면 해당 메소드에 그 기능이 있으니 그 메소드만 보고 고치면 되겠다 라고 할 수 있으니 유지보수에도 좋다. //오래동안 재활용 할 수있으니 신뢰성 높아진다 해당 메소드를 때어다가 가공하고 다시 쓰고 가공하고 다시 쓰니깐//메소드의 장정은 개발자 입장에서 코드를 덜 쓰게 할 수 있다.
		
		//아래의 메소드가 작동하도록 메소드를 정의하고 호출해보세요. 
		//boolean same = isEqual("Hello", "world"); //True false 가 나오는 메소드는 국제적으로 앞에 is 라고 한다. boolean 은 관례적으로 이름을 is로 시작한다. 해석 :이거 같냐?
		//System.out.println(same);
		
		
		//로그인을 위한 메소드 2개 선언하기
		
		//키보드에서 ID, Pwd 입력 받아서 배열로 리턴
		String[] loginData = getUserInfo();//이용자 아니다와 비번을 대열로 묶어서 보내는 역할의 겟유저 인포//괄호안에 아무것도 없다는 것은 파라미터가 없다. //아이디와 페스워드를 배열에 담아서(아이디와 패스워드가 하나가 아니니깐), 문자열 다수개를 즉 메소를 호출하면 배열이 나와야함
		//위 메소드의 리턴타입은 String[], 파라미터 없음
		
		//아이디와 암호로 인증하고 그 결과를 boolean값으로 리턴
		boolean success = login(loginData[0], loginData[1]);//아이디와 비번을 나누어 로그인 메소드에 보낸다. //id와 pw가 logindata[0]과 [1]에 들어가고 login 모소드를 부른다. //위에 아이디와 패스워드 데이터 있을 테니깐 그걸로 불리언 돌린다. 문자열 변수 2개
		System.out.printf("로그인 결과=%b%n", success);	
		
		
		//getNum 라는 메소드를 정의하고 호출했을 때 무작위 정수 5개가 리턴될 수 있게 함
		//검증 : main메소드에서 호출하여 리턴된 값을 출력했을 때 정수 5개가 표시되어야 함
		int[] arr = getNum();
		
		System.out.println(Arrays.toString(arr));	
		
		// 메소드가 데이터를 받아들이는것은 파라미터를 여러개도 받을 수 있고 배열을 받을 수도 있다. 메소드에서는 배열 변수 선언만 하면된다.
		//getTotal 메소드를 선언하고 정수 배열을 받아서 배열의 정수를 합산하여
		//리턴하는 기능을 정의해보세요. 즉 메인메소드에서 배열을 생성하여 선언한 메소드에 파라미터로 주고 그 값을 합산하여 얼마라고 
		Random rd = new Random(); 
		//int[] nums = new int[] {1,2,3,4,5};//각자리에 들어갈 값
		int[] nums = new int[5]; //정수 공간 5개를 할당하여 nums에
		for(int i=0; i<nums.length ; i++) //length를 5로 할 수 있지만 이걸 저렇게 하면 방수만 바꾸면 여긴 바꿀 필요가 없으니깐. 즉 유연한 코드로 작성하는 게 좋다 유지보수에 좋다.
		{   	
			nums[i] = rd.nextInt(20);	
		}
		
		int n = getNum(nums);
		System.out.printf("합계=%d%n", n);
		
		
		
		//무작위 숫자 2개를 받아서 작은수를 골라서 리턴하는 메소드를 작성해보세요.

		System.out.println("작은수=" + getMin(5,9));
		
		
		// 무작위 수(1~100) 10개를 전달하면 그 중에서 가장 작은값과 큰값을 리턴하는 메소드
		// getMinMax
		


		
		int[] num = new int[] {1,2,3,4,5,6,7,8,9,10}; 	
		int[] res = getMinMax(num);
		System.out.printf("최소값=%d, 최대값=%d%n", res[0],res[1]);
		*/
		
		
		/*

		
		
		//무작위 정수배열을 받아서 정렬하고 그 결과 배열을 리턴하는 메소드를 작성해보세요.
		
		
		int[]sorted = sortNum(new int[] {1,10,3,4,20,6,15,8,9,12}); 	

		System.out.println(Arrays.toString(sorted));
		
		
		//오늘 날자의 요일(숫자)을 구해서 메소드에 전달하면 문자열 요일로 변환하여
		//그 문자열 요일을 리턴하는 메소드
		//public static String num2strDay(int wday)
		

		System.out.printf("오늘은 %s입니다.", num2strDay(3));
	
		
		initAnswer();
		
		gameLoop();
		
		
			*/
		//키보드에서 수식(가감승제)을 입력하면 해당 수식을 실행하여 그 결과를 구하고
		//결과를 포함한 수식을 문자열로 완성하여 리턴하는 메소드를 작성해보세요.
		//예) 이용자가 3 + 5를 입력하면 3+5=8 수식을 문자열로 리턴하는 메소드

		

		//String a = kbd.nextInt();
		//String b = kbd.next();
		//String c = kbd.nextInt();
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("가감승제 수식입력:");
		
		String[] n = new String[3];
		n [0] = kbd.next();
		n [1] = kbd.next();
		n [2] = kbd.next();
		System.out.println(sum(n));
		//System.out.println(makeExp());
	}
	
	
	public static String sum(String[] c)
	{
		int d = Integer.parseInt(c[0]);
		int e = Integer.parseInt(c[2]);
		System.out.println(d);
		System.out.println(e);
		int g = 0;
		int s = 0;
		int o = 0;
		String y = "";

		if(c[1].equals("+"));
			{g = d+e;
			 s = 6;
			 o += 6 ;
		     y += +1;
		     
			}
		if(c[1].equals("-"));
			{g = d-e;
			
			}
		if(c[1].equals("*"));
			{g = d*e;
			}
		if( c[1].equals("%"));
			{g = d%e;
			}
		if(c[1].equals("/"));
			{g = d/e;
			}
		}
			System.out.println(g);
			System.out.println(s);
			System.out.println(o);
			System.out.println(y);
		String j = y += (d+e);
		
		return j;
	
			
	}

	public static String makeExp()
	{
		Scanner kbd = new Scanner(System.in);
		System.out.print("가감승제 수식입력:");
		
		String sNum1 = kbd.next();
		String sOp = kbd.next();
		String sNum2 = kbd.next();
		
		int n1 = Integer.parseInt(sNum1);
		int n2 = Integer.parseInt(sNum2);
		
		String exp  = sNum1 + sOp + sNum2 + "=";;
		
			switch(sOp) {
			case "+" : exp += (n1+n2); break;
			case "-" : exp += (n1-n2); break;
			case "*" : exp += (n1*n2); break;
			case "/" : exp += (n1/n2); break;
			case "%" : exp += (n1%n2); break;
			default : exp = "수식입력 오류";
			}


	
		
		return exp;
	
			
	}
	
	
	
	/*
	 * 
	static int answer; //맴버 변수는 선언만 하면 초기화가 자동으로!!!즉, 초기화 불필요, 기본값으로 초기화됨 즉 의미없는 값인 0으로 초기화됨//answer는 class 변수다 static 붙어있응께//메소드 안에서 사용 가능 밖에꺼니깐 안에서 사용 가능 ex) answer = 10; 이렇게 사용 가능//class variable맴버 변수 이면서 static을 다루고 있으면 클래스 변수라고 한다. Member Variable 메소드 밖에 있으면 어디에 있던 그 변수를 맴버 변수라 한다. 반대로 메소드 안에는 지역 변수 로컬 변수
	//public static String num2strDay(int wday) // Member method, class method 메소드 안쪽에 변수는 지역 변수 위에꺼 꺼 같은건 맴버 변수
	
	
	
	//initAnswer 메소드가 실행되면 answer 변수가 무작위 수(1~30)으로 초기화되게 해보세요.
	public static void initAnswer()
	{
	 //한번만 쓸거니깐 Random rd = new~~ 이런식으로 안 써도됨
	answer = new Random().nextInt(30)+1;
	System.out.println("answer 초기화 완료");
	}
	public static void gameLoop()
	{
		Scanner kbd = new Scanner(System.in);
		
		int cnt = 0;
		System.out.print("1~30사이의 숫자를 맞춰보세요:");
		

		while(true)
		{
		 cnt++;
		 int userIn = kbd.nextInt();
		 boolean correct = getMessage(userIn);
		 if(correct)
		 {
			 System.out.printf("축하합니다~ %d번 만에 성공했습니다.", cnt);
			 break;
		 }
		 
		}	
	}
	public static boolean getMessage(int userIn)
	{
		if(userIn==answer)
		{
			return true;
		}
		else
		{
			String msg = answer<userIn ? "정답은 더 작습니다." : "정답은 더 큽니다.";
			System.out.print(msg+"입력:");
			return false;
		}
	
			
		
	}
		
	
	

	public static String num2strDay(int wday)
	{
		
	String sDay = "";
		switch(wday) 
		{
		case 1:
			sDay="일";
			break;
		case 2:	
			sDay="월";	
			break;
		case 3:	
			sDay="화";	
			break;
		case 4:	
			sDay="수";	
			break;
		case 5:	
			sDay="목";	
			break;
		case 6:	
			sDay="금";	
			break;
		default:
			sDay="토";
		
	
	}
		return sDay;
	}
	
	
	
	public static int[] sortNum(int[] arr) 
	{
		

		for(int i=0;i<arr.length-1;i++) { //선택정렬
			for(int j=i+1;j<arr.length;j++){	
				if(arr[i]>arr[j]){ //swap
					int tmp = arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
		
			}
		}
		return arr;
		
	}
		
		
		
			
	}
	public static int[] getMinMax(int[] num) 
	{ 

		int min = 100000;
		int max  = -100000;
		
		
		for(int i=0;i<num.length-1;i++) //선택 0 1 2 3 까지만 4는 비교대상 아니니깐
		{
			if(num[i]<min) min = num[i];
			if(num[i]>max) max = num[i];
		}
		return new int[] {min,max};
	
	
	}
	


	public static int getMin(int a, int b) 
	{ 
		//return Integer.min(a,b);
		//return a>b ? a: b;

		     
	 	int min = -100000; //보통계산에서 나올수 없는 값을 주었다 그런값으로 초기화함 즉 의미 없는 숫자다.
	 	if (a>b) min = b;
	 	else min = a;
		
		return min;
	
	
	}
	
	
		public static int getNum(int[] a)
		{ 

			int c = 0;
			
			for(int i=0; i<a.length ; i++) 
				
			{
				c += a[i];
				
			}
			
		
			return c ;
		}
		
	public static int[] getNum() //데이터의 겟수가 중요한거 데이터가 두개면 공간 두개만 만들고 이름은 마음데로 해두됨
	//getNum의 스팩은~ 스팩이라 읽는다 int[] 이고 이런식으로 읽을 수 있다.
	{ 
		Random rd = new Random(); 

		int[] nums = new int[5]; //정수 공간 5개를 할당하여 nums에
		for(int i=0; i<nums.length ; i++) //length를 5로 할 수 있지만 이걸 저렇게 하면 방수만 바꾸면 여긴 바꿀 필요가 없으니깐. 즉 유연한 코드로 작성하는 게 좋다 유지보수에 좋다.
		{   	
			nums[i] = rd.nextInt(20);
			
		}
		
		Random rd = new Random();
		int[] n = new int[6];
		n[1]  = rd.nextInt(10);
		n[2]  = rd.nextInt(10);
		n[3]  = rd.nextInt(10);
		n[4]  = rd.nextInt(10);
		n[5]  = rd.nextInt(10);
		return n;
		
		return nums;
	
	}
	
	*/
	/*
	public static boolean login(String id , String pwd) //데이터의 겟수가 중요한거 데이터가 두개면 공간 두개만 만들고 이름은 마음데로 해두됨
	{
		return id.equals("smith") && pwd.equals("1234");;
	
	}
	public static String[] getUserInfo() //getuserinfo 스트링 배열 표현식이다.
	{
		Scanner kbd = new Scanner(System.in);
		System.out.print("아이디 암호:");
		String uid = kbd.next();
		String pwd =kbd.next();
		String[] data = new String[2];
		data[0] = uid;
		data[1] = pwd;
		return data;//문자열 2개 나갈거야
		//return null;// 처음 코드 작성전 기본 구성시 에러 지우기 위해서null
	}
	

	
	
	
	
	
	public static void addExp() //메소드 선언 // void 이건 호출해도 값을 리턴하지 않는다. // 파라미터가 없고(이 안쪽으로 던져주는 데이터가 없다), 리턴값도 없는 가장 단순한 형식의 메서드//이름을 들었을때 그 기능의 힌트가 되는 이름으로 하고 소문자로 시작하고 단어의 조합이면 두번째를 대문자로 즉 카멜 케이스
	{
		Random rd = new Random();
		int a = rd.nextInt(20);
		int b = rd.nextInt(20);
		int c = a+b;
		System.out.printf("%d + %d%n", a,b,c);
	}
	public static void addExp(int a, int b) //파라미터 안 변수에는 호출 시에만 넣을 수 있다. 객체지향언어는 이름이 같아도 괜찮지만 파라미터 값이 달라아한다. 외부에서 들어오는 정수 두개를 받을 거야 라는 정의()괄호안에 넣었다.
	{
		int c = a+b;
		System.out.printf("%d + %d%n", a,b,c);
	}
	public static void addExp(int a, int b) //파라미터 안 변수에는 호출 시에만 넣을 수 있다. 객체지향언어는 이름이 같아도 괜찮지만 파라미터 값이 달라아한다. 외부에서 들어오는 정수 두개를 받을 거야 라는 정의()괄호안에 넣었다.
	{
		int c = a+b;
		System.out.printf("%d + %d%n", a,b,c);
	}
	public static void gugu(int dan) //이 메소드도 호출한 쪽으로 값을 돌려주는게 없다 즉 앞에 gugu(5)도 표현식은 아니다 이게 표현식이면 호출시에도 int a = gugu(5); 형식일 것이다 화면 출력과 리턴은 다르다.
	{
		for(int i=1;i<=9;i++)
		{
		System.out.printf("%d + %d = %d%n", dan, i ,dan*i);
		}
	}
	public static int add(int a, int b) //리턴하기에 void 가 없다. static 뒤에 int는 정수로 리턴한다 그리고 호출시에서 정의한게 int 여야함 즉 호출과 메서드의 자료형이 같아야함 즉, 리턴의 타입이 안에도 밖에도 영향을 준다.
	{
		return a+b; //호출한 쪽으로 리턴하기 위한 명령
	}
	public static int getMax(int a, int b) 
	{
		//return Integer.max(a,b);
		//return a>b ? a:b;
		if(a>b) return a;
		else return b;
	}
	
	public static boolean isEqual(String a, String b) //리턴 타입이 호출시 어떤지 보고 확인 여긴 boolean, 호출에서 넘겨주는 변수가 숫자인지 글자인지에 따라서 파라미터 확인, void 없으니 기본 retuen 깔고 시작.
	{//아래의 리턴값과 호출과 메소드의 타입이 같아야함 즉 여기서는 다 boolean 리턴에서는 불리언에 해당하는 트루 펄스여야 한다는 점
		
		return a.equals(b);
	}
	
	*/
	
	
}
