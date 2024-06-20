package com.mbcac.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.xml.stream.events.Characters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CollectionCRUD {

	public static void main(String[] args) 
	{
		
		/*Collection 유형 : List, Set, Map
		*List : 유순,중복가능  //값을 가지고 메모리에 보여주는건 제일 빠르다 즉 출력용으로 쓰는게 좋다.//방에 각각 정보를 저장하지만 방주소는 없기에 방주소로 찾아 갈 수는 없다.//예를 들어 순서에 의한 당첨을 할때 그리고 첫번째 입력된 사람이 중복 지원해서 1등도 2등도 가능할때 //방으로 구분하니깐 동일한 데이터도 담을 수 있다. //순서가 있는 유형이다 반대로 콩을 한줌 쥐면 콩에 순서가 없는 것 과 같은 유형도 있다.
		*set : 무순,중복불가  //같은 값이 들어가긴 가는데 같은 값은 나중에 들어가는 값이 덮어쓰기 때문이다. 그리고 기존 데이터는 사라지는것 그렇기에 중복이 없어 보이는것이다.//입력한데로 순서가 유지 되지 않는다. //모아두기는 하는데 순서 없이 모은데		
		*Map :  key, value 를 쌍으로 연결하여 저장 //value를 찾기위새서 key를 가지고 계산을 해서 value를 찾을 수 있다 저장 위치를 키를 통해서! 해싱 알고리즘을 통해서 value 위치를 찾을 숭 있고 제일 빠른 검색 기능이다. //값(key)에 꼬리표(value)를 달아서 //맵,맵핑 연결한다는 의미
		*10만개 데이터중 특정 이름을 찾고 싶다의 경우 순차 검색을 해야할거다 그런경우 10만번째면 검색 시간이 많이 걸린다. 이런경우 map의 경우 key를 계산해서 그냥 바로 찾을 수 있다. 즉 순차 검색을 안해도 된다. 그래서 검색 성능이 좋다.
		*key를 해싱해서 value를 찾을 때 쓴다. value를 저장하기 위한 자료구조
		*a(key)-menu1(value)  b-munu2    c-munu3   여기서 알파벳이 ID고 value가 회원 정보라고 생각해라 // key 를 쉽게 구할수 있는 환경이여야 한다.// 그러면 아이디를 찾으면 회원정보를 볼 수있는 구조 상상
		*/
		
		//컬렉션은 원래 기본형을 안받는다.
		
		/*
		// List(ArrayList, LinkedList)
		//ArrayList<String> list = new ArrayList<>(); //컬렉션에 뭘 담을 것이냐 그것을 <String> 여기에 넣은 것 이다.<> 여기 비어있었는데 옛날에는 String이라고 써줘야 했는데 앞에 있으니 이제는 중복이라고 안써도 된다고 업데이트됨
		//어레이 리스트 라는 객체에는 문자열을 담을 거야!ArrayList<String>  <<<자료형  list <<<변수 
		//list.add("김흥국");
		//list.add("손흥민");
		//list.add("Smith");
		//list.add("김흥국");
		//위의 과정은 CRUD 에서 create 다.
		*/
		
		/*
		//list.get(0); //위에 String이라고 했으니 문자열을 리턴한다.
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		//Read
		*/
		
		//업무에서는 대부분 List 를 사용한다. add로 두고 get으로 가져온다
		
		//Update
		//list.set(3, "박찬호"); //방번호,바꿀내용
		/*
		for(int i=0;i<list.size();i++)//length가 아니라 size 로 씀
		{
		String name = list.get(i);
		System.out.println(name);
		}
		
		*/
		
		//Delete
		//String removedName = list.remove(0); //remove는 이 두개를 많이 씀 0번 방으로 가서 떨궈 내고 떨궈낸걸 removedName여기에 저장한다 그래서 지운것도 뭔지 알 수 있다.
		/*
		for(int i=0;i<list.size();i++)
		{
		String name = list.get(i);
		System.out.println(name);
		}
		//Array List 는 우리가 배열을 할때 덮어 쓰기 형식으로 했던걸 자동으로 해줘서 좋다.
		
		*/
		
		/*
		boolean found = list.contains("박찬호"); //True, flase 로 리턴하는거 contain
		System.out.println(found ? "박찬호 있음" : "박찬호 없음");
		//Search
		
		int i = list.indexOf("박찬호");
		String name = list.get(i);
		
		name = list.get(list.indexOf("박찬호"));
		*/
		
		/*
		ArrayList<User> users = new ArrayList<>();
		
		User u1 = new User("smith", "pwsmith","010-2478-6540","smith@gamil.com");
		User u2 = new User("james", "pwjames","010-1489-2590","james@gamil.com");
		User u3 = new User("laura", "pwlaura","010-2410-6950","laura@gamil.com");
		User u4 = new User("laura", "pwlaura","010-5478-2470","laura@gamil.com");
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u3);
		

		User james = new User("james"); //james, u1, 주소가 다르지만 우리가 오버라이드로 만든 이름만 비교하는 기능을 이용했기에 
		boolean same = users.contains(james);
		*/
		
		//System.out.println(same);
		//users.get(users.indexOf(james)).printUser();
		
		//users.contains(james);
		
		//System.out.println(u3.equals(u4));
		//이런경우 홈페이지에서 아이디가 같으면 같은 사람인데 이런겨우 다르다고 나오면 이상하다 왜냐면 new 로 해당 주소만 저장된거고 다른 주소의 것들을 비교한거니
		//이런경우 부모 기능 이퀄스를 나중에 바꾸는 오버라이드를 해서 이퀄스 메소드를 아래 크래스에서 우클릭 source - override 이퀄스를 수정할거다 근데 안나오면 직접 쓴다.
		

		/*
		users.add(new User("smith", "pwsmith","010-2478-6540","smith@gamil.com"));
		users.add(new User("james", "pwjames","010-1489-2590","james@gamil.com"));
		users.add(new User("smith", "pwsmith","010-2410-6950","laura@gamil.com"));
		*/
		/*
		if(users.contains(u2))//james 정보 찾아서 화면에 표시하기
		{
			users.get(users.indexOf(u2)).printUser();
		}
		*/
		
		
		
		//List, CRUD
		/* C : add();
		 * R : get();
		 * U : set(idx, Object)
		 * D : remove(idx); remove(Object); 방번호의 인덱스도 안에 내용 값도 둘다 삭제 가능한 방법
		 * 확인 : contains(Object)
		 * 상속 : Inheritance(상속): 자식 클래스가 부모 클래스의 기능과 속성을 물려받아 확장되는 것
		 * Override : 부모한테서 상속된 메소드를 자식 클래스에서 새롭게 기능을 정의하는 것
		 * equals() : List 안에서 객체의 동등성 비교(contains(), indexOf())할 때 호출됨  //우리가 직접 호출 할 수 있지만 리스트가 목록을 관리할때 인덱스 오브 등등에서 사용하고 있음
		 * Override 문법 : 부모 메소드를 자식 클래스에 붙여널기하고 메소드 바디 내용르 새로 정의
		 */
		
		//키보드에서 애완동물 정보를 3개 입력하여 목록으로 표시
		//종, 이름, 체중, 색상
		
		/*
		 * 실습하다가 못한거!!!!!!!!!!!!!!!!!!!!!
		ArrayList<User> pets = new ArrayList<>();
		Scanner kbd = new Scanner(System.in);
		String a = kbd.next();
		String b = kbd.next();
		String c = kbd.next();
		String d = kbd.nextLine();
		pets.add(a,b,c,d);
	

			User u1 = new User(a,b,c,d);
		
		
		
		User u1 = new User("smith", "pwsmith","010-2478-6540","smith@gamil.com");
		User u2 = new User("james", "pwjames","010-1489-2590","james@gamil.com");
		User u3 = new User("laura", "pwlaura","010-2410-6950","laura@gamil.com");
		
	
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u3);
		실습하다가 못한거!!!!!!!!!!!!!!!!!!!!!!!!!
		*/
		
		/*
		//Set : 중복불허, 무순 //방번호가 없어서 루프 돌 수가 없기에 한번더 가공해야함
		 * 
		HashSet<String> names = new HashSet<>();
		names.add("박세리");
		names.add("손흥민");
		names.add("박세리");
		names.add("김연아");
		names.add("박지성");
		System.out.println("원소수: "+ names.size()); //중복이 불가이기에 2라고 출력됨
		
		Iterator<String> it = names.iterator(); //반복자! 반복 가능하게 하는 이렇게 해야 루프를 돌릴 수 잇다.
		
		while(it.hasNext()) //has 가져올 값이 있는가?
		{
			String name = it.next(); //그럼 그 다음값을 가져와!!! 방번호가 없어서 이런 방식으로 해야함
			System.out.println(name);  //김연아 박세리 손흥민 박지성 << 이런식으로 나오는데 중복 데이터 삭제됨 그리고 순서가 없다.
		}
		
		// for문장으로 위의 결과 그대로 재현하기
		for(int i = 0; it.hasNext() ;i++) //hasNext()는 불리언 값이고 true false가 나온다.  iterater가 반복이 가능하게 되었고 hasNext로 반복이 가능한가?? 확인 하면서 안에 있는거 다 보면 다음꺼를 가져오는 작업을 반복 못하니깐 끝 false
		{
			
			String name = it.next(); 
			System.out.printf("%d. %s%n", i+1, name); 
		}
		*/
		
		//모든 컬렉션 API에 공통된 특징
		//기본 자료형은 안 받는다. 참조형만 받는다.ArrayList<int> nums = new ArrayList<>(); 인티져라서 에러뜬다.double 도 안되지만 Integer는 가능하다.
		
		/*
		ArrayList<Integer> nums = new ArrayList<>();
		
		Integer itg = Integer.valueOf(5); //5라는 수 값에 인티져를 인티저 오브젝로 구해라 // 클래스 메소드 즉 .을 눌러서 보이는 것 중에 회색 사선 이있으면 시간이 흐름에 따라 못 쓰게 될수 있다고 알려주는거다 즉 어떤 조건이 되면 부작용이 있으니 다른걸 쓰세요 라는 뜻
		nums.add(itg);
		nums.add(10); //Auto -  Boxing //이렇게 하면 내부에서 위에서 행한 Integer itg = Integer.valueOf(5);이 행동을 대신 해주겠다고 한거임 즉 오토 방식이 여기서 이루어져서 인티져 오브젝트로 전환하는게 자동이다.
		
		Integer itn = nums.get(1); //이건 int가 아니라 Integer 니깐 아래서 인티저로 또 바꿔야지 쓸 수 있다.
	   
	    int n = itn.intValue();//즉 인티저 오브젝트를 풀어서 숫자를 꺼내는 작업이다.
	
	    int i = nums.get(0); //Unboxing 언박싱 //오토박싱과 반대로 꺼낼때도 쉬운 방식을 제공한다 즉 그냥 정수로 받아도 된다. 
	    //(기본형)랩퍼클래스에서는 오토박싱 언박싱이 기원이 됨
	*/
		/*
	     ArrayList<Character> chars = new ArrayList<>();
      chars.add('A');
      chars.add('B');
      chars.add('C');
      chars.add('D');
     
      char ch = chars.get(2);  // C
      System.out.printf("chars.get(2)->%c%n", ch);
	    */
		/*
	    //Map : key, value가 쌍으로 저장되는 자료구조(Data Structure)
		//key를 해싱(Hash)하여 value가 저장될 메모리 위치를 계산하는 방식
		
		User u1 = new User("smith", "pwsmith","010-2478-6540","smith@gamil.com");
		User u2 = new User("james", "pwjames","010-1489-2590","james@gamil.com");
		User u3 = new User("laura", "pwlaura","010-2410-6950","laura@gamil.com");
		User u4 = new User("ward", "pwward","010-5478-2470","ward@gamil.com");
		
		HashMap<String, User> userMap = new HashMap<>();
		userMap.put("smith", u1); //키를 해싱해서 그곳에 둔다.
		userMap.put("james", u2);
		userMap.put("laura", u3);
		userMap.put("ward", u4);
		//키는 달라야함 같으면 덮어쓰기함
		User laura = userMap.get("laura");
		laura.printUser();
		*/
		
		//무작위 수 추첨하는데 우리회사가 고객상대로 고객번호 10개를 추첨해서 선물 줄게 그대신 중복안되

		//1~50사이의 정수 중에서 중복되지 않는 10개를 추출하려면?
		
		/*실습한거!!!!!!!!!!!!!!!!
		HashSet<Integer> names = new HashSet<>();
		Random rd = new Random();
		int cnt = 0;
		for(; cnt<10 ;)
		{
			int n =rd.nextInt(50);
			if(!names.contains(n+1)) {
				names.add(n);
				cnt++;
			}
		}
		System.out.println(names);
		실습한거!!!!!!!!!!!!!!!!
		*/
			
		/*
	    Random rd = new Random();
	      HashSet<Integer> hset = new HashSet<>();
	     
	      while(hset.size()<10) {
	         hset.add(rd.nextInt(50)+1);
	      }
	     
	      Iterator<Integer> itn = hset.iterator();
	     
	      for(int i=1;itn.hasNext();i++) {
	         int n = itn.next();
	         System.out.printf("%d ", n);
	      }
	      System.out.println();
	     
	      ArrayList<Integer> list = new ArrayList<>(hset);
	      for(int i=0;i<list.size();i++) {
	         System.out.printf("%d ", list.get(i));
	      }
			*/	
			
		/*
	      //Set, CRUD 여기서 C 와 D 만 가능하다 set은 중복 불가의 장점 있지만 이런부분은 바로 안됨
	      HashSet<Integer> hset = new HashSet<>();
	      hset.add("Hello"); //create
	      //hset.get(); 안됨//방번호로 관리가 안되어서 get으로 불가능하기에 반복하는 이터레이터를 써야한다.
	      hset.remove("Hello"); //update 안되지만 리부브하고 삭제는 가능하니 그렇게 수정가능 
		*/
		
		/*
		HashMap<String, String> hmap = new HashMap<>();
		hmap.put("a","value"); //Create
		hmap.get("a"); //Read
		hmap.replace("a", "Hello"); //Update
		hmap.remove("a"); //Delete
		*/
		/*
		HashMap<String, String> hmap = new HashMap<>();
		Set<String> s = hmap.keySet(); //키집합만 몽땅 가져올 수 있다. 그걸 Set으로 가져다줌 Set은 루프를 못돌리고 업데이트가 안됨 즉 반복자로 루프돌려야함
		Collection<String> c = hmap.values(); //벨류를 가져오면 컬렉션 형인데 리스트 셋 맵이 컬렉션이다 그게 조상 인터페이스가 컬렉션이고 컬렉션을 상속 받아서 리스트 셋 맵이고 즉 이건 루프를 돌릴 수 있다.
		*/
	      //id,pwd,phone,email
		//User 클래스 사용
		// 5개의 User 오브젝트를 생성하고 로그인하는 이용자가 자신의 정보를 관라하는 프로그램
		// 전화번호 변경하기, 목록 표시
		// 관리자가 로그인하면 다른 이용자의 정보 삭제 가능
				
		initUserMap();
		boolean go = true;
		while(go)
	      {
	    
	         String usrMenu = getMenu();
	         
	         while(true) {
	            if(userId==null && usrMenu.equals("x")) {
	               userId="손"; 
	               break;
	            }
	            if(userId==null) {
	               System.err.println("로그인 후에 사용가능합니다");
	               login();
	            }else break;
	         }
	         
	         switch(usrMenu)
	         {
	            case "x": go = false;                   break;
	            case "u":                          break;//변경
	            case "s":                           break;//목록
	            case "d":                           break;//삭제
	            default: System.err.println("메뉴입력 오류");
	         }
	      }
	     
	      System.out.printf("%s님 이용해주셔서 감사합니다%n", userId);
	}
	
	  	static Product[] parr = new Product[5];
	  	static Scanner kbd = new Scanner(System.in);
	  	static Product[] cart = new Product[10];
	  	static int cartCnt;
	  	static String userId;
	  	static HashMap<String,User> userMap = new HashMap<>();

	  	static Product[] parr2 = new Product[10];
	  	static int cnt;
	  	
	  	
		   private static void login() {
			      System.out.print("아이디 암호:");
			      String id = kbd.next();
			      String pwd = kbd.next();
			      
			      System.out.println(userMap.get(id));
			      System.out.println(userMap.get(id).getUserpw());
			      System.out.println(userMap.get(id).getUserpw().equals(pwd));
		
			      if(userMap.get(id).getUserpw().equals(pwd)) 
			      {
			         userId = id;
			         System.out.println("로그인 성공");
			      }else {
			         System.err.println("로그인 실패");
			      }
			   }
		   
	  
		    private static HashMap<String,User> initUserMap()
		    {
		       User u1 = new User("smith","pwsmith","010-2478-6540", "smith@gmail.com");
		       User u2 = new User("james","pwjames","010-1489-2590", "james@gmail.com");
		       User u3 = new User("laura","pwlaura","010-2410-6950", "laura@gmail.com");
		       User u4 = new User("ward","pwward","010-5478-2470", "ward@gmail.com");
		       User u5 = new User("scott","pwscott","010-2594-4790", "scott@gmail.com");
		      
		       
		       userMap.put("smith", u1);
		       userMap.put("james", u2);
		       userMap.put("laura", u3);
		       userMap.put("ward", u4);
		       userMap.put("scott", u5);
		      
		       return userMap;
		    }
	  	
	  	
	

		 private static String getMenu()
		 {
			 System.out.println();
			 System.out.print(" 수정(u), 목록(s), 삭제(d):");
			 String m = kbd.nextLine();
			 return m;
		 }
		 


}
@Data
@AllArgsConstructor
@NoArgsConstructor
class User //부모 클래스 부를때 super class상위 클래스, parent class, baser기반 class// 자식 클래스는 sub class, child class derived파생 class//extends Object 이렇게 써도 상관없지만 자동으로 써주기에 안써도 되는거다. 오브젝트가 부모 클래스이고 유저가 자식클래스고 자식 클래스가 상속받았으니 확장되어서 더 큰규모다//필수적인 메소드인 Object 클래스를 User 에 넣어서 extends 확장한다 그안에는 equlas 도 있는거고 그래서 contains를 쓰면 이퀄이 된다. // 자바의 모든 클래스는 오브젝트를 상속한다. inheritance 즉 객체 지향언어의 3대 특징중 하나인 상속이 이거다
{	/*
	private String spe;
	private String nam;
	private String wei;
	private String col;
	*/
	private String userid;
	private String userpw;
	private String phone;
	private String email;
	
	/*
	public User(String userid)//이름만 있어도 객체를 생성할 수 있게 한다.
	{

		this.userid = userid;
	}
	
	@Override   //오버라이드 문법이 맞는지 검사한다.
	public boolean equals(Object obj) //other 외부에서 들어온 객체    이작업은 index나 contain을 쓰면 이퀄스가 쓰이는거고 그걸 바꾸는것
	{
		System.out.println("User.equals 호출됨");
		User other = (User)obj; //형변환 () 오브젝트형이 유저형으로 변환 되어 유저의 변수에 저장된다.
		//return this.getUserid().equals(other.getUserid()); //this 이객체의 유저 아이디와 other 저 객체의 유저아이디를 이퀄스로 비교
		//return this.getUserpw().equals(other.getUserpw()); 
	}
	*/
	public void printUser()
	{
		System.out.printf("%s\t%s\t%s\t%s%n", userid, userpw, phone, email);
	}
}
