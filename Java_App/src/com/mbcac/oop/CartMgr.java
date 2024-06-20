package com.mbcac.oop;

import java.util.Scanner;

import com.mbcac.ClassEx.Pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CartMgr 
{
	public static void main(String[] args) 
	{
		//클래스와 인스턴스, 배열을 사용한 장바구니 만들기
		//프로그램이 시작되면 상품목록이 표시된다.
		//상품속성:이름(마우스,메모리 등), 가격, 제조일, 제조사
		//항상 화면하단에는 메뉴가 표시된다
		//목록(s),추가(a),검색(f),
		//장바구니에 담기(c),장바구니 보기(g),
		//수정(u),삭제(d),종료(x)
		//최소 배열 2개가 필요할거다 상품배열, 장바구니 배열
		//장바구니에 감기 기능은 검색 후 상세보기 화면에서만 가능
		
		//로그인 후에 이용하도록 하고, 프로그램을 종료하면 '????님 이용해주셔서 감사합니다.'

		//CRUD, Board, Arrays
		//글번호, 작성자, 제목, 본문, 히트수
		//프로그램이 시작되면 게시글 리스트가 표시된다.
		//목록에는 글번호, 작성자, 제목, 히트수만 표시되어야 함(본문 제외)
		//목록에는 게시글 본문은 포함하지 않고 상세글 보기에서 본문이 보이도록 할 것임
		
		/*내가 하다만거
		boolean go = false; // 내가 만든 로그인 되면 넘어가는 걸로 인해서 이거 이렇게함
		int logCnt = 0;
		String mem = "";
		System.out.printf("아이디, 비밀번호");
		String id = kbd.next();
		String pw = kbd.next();
		while(true)
		{

			if(id.equals("smi")&&pw.equals("123"))
			{
				go = true;
				mem = id;	
				kbd.nextLine();
			}
		
			for(int i = 0;i<2;i++)
			{   
				System.out.printf("아이디, 비밀번호 다시 입력");
				id = kbd.next();
				pw = kbd.next();
				if(id.equals("smi")&&pw.equals("123")) 
				{
					go = true;
				}
			}
         System.out.printf("3회 이상 실패");
         break;
		}
		*/
		
		parr =createlist();
		//printList(createlist());
		//printList(parr);
		
		
		boolean go = true;

			
		/*내가 하다만거
		 * 		printList();
		String usrMenu = getMenu();
			while(true)
			{
			if(logIn()){find();  break;}
			go=false;
			}
			*/
		
		while(go)
	      {
	         printList();
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
	         {//추가(a), 목록(s), 검색(f), 장바구니 보기(i), 수정(u), 삭제(d), 종료(x)
	            case "x": go = false;                   break;
	            case "a":    add();                         break;
	            case "s":                            break;
	            case "f": showFind(find());               break;
	            case "i": showCartItems();               break;
	            case "g":                           break;
	            case "u":                           break;
	            case "d":                           break;
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

	static Product[] parr2 = new Product[10];
	static int cnt;
	
	/*
	 * 내가 하다만거
	static int reCnt;
	static String a;

	static Log[] re = new Log[3];
	
*/
	private static void add() 
	{
	
		System.out.printf("번호, 상품이름, 가격, 제조년, 제조사:");	
		
		int id = kbd.nextInt();
		String name = kbd.next(); 
		int price = kbd.nextInt();
		String pdate = kbd.next(); 
		String maker = kbd.nextLine();
		
        
        
	    parr2[cnt++] = new Product(id,name,price,pdate,maker);
	
		System.out.println("제품 정보 추가 성공");
	 	
	
	}
	
	
	
	
	
	/*내가 하다만거
	private static boolean logIn() 
	{
		System.out.println("로그인 하세요");
		
		int logCnt = 0;
	    
		
		
		System.out.printf("아이디, 비밀번호");
		String id = kbd.next();
		String pw = kbd.next();
		re[0] = new Log("sma","123");
		while(true)
		{
			
			if(id.equals("smi")&&pw.equals("123"))
			{	kbd.nextLine();
				System.out.println("로그인 성공");
				re[0].setUid(id);
				System.out.println(re[0].getUid());
				
				return true;
				
			}
		
			for(int i = 0;i<2;i++)
			{   
				System.out.printf("아이디, 비밀번호 다시 입력");
				id = kbd.next();
				pw = kbd.next();
				if(id.equals("smi")&&pw.equals("123")) 
				{
					a = id;
					return true;
				}
			}
         System.out.printf("3회 이상 실패");
         kbd.nextLine();
         return  false;
		}
	}
	*/
	
	private static Product[] createlist() //createlist()이게 돌아가면 Product[] 이게 나온다 즉 리턴 타입 출력물은 Product[]이거다
	{    
		Product[] list; //배열변수 선언(생성) 4바이트 크기로 메모리를 점유
		list = new Product[5]; //메모리할당(20bytes)//주소를 저장할 공간 몇개
		list[0] = new Product(11, "Galaxy", 20000, "2020-05-22", "LG");
		list[1] = new Product(12, "Mouse", 2000, "2021-06-12", "HD");
		list[2] = new Product(13, "Memory", 12000, "2022-06-05", "GM");
		list[3] = new Product(14, "Monitor", 27000, "2023-08-09", "DW");
		list[4] = new Product(15, "GPU", 47000, "2024-02-15", "TX");
		return list; //처음엔 list  대신 parr 로 했는데 이런경우 가까이 있는걸 지칭하기에 겹치지 않는다!! 내생각!!!
	}
	
	//public static void printList(Product[] parr)
	private static void printList()
	{    			
		System.out.println();
		System.out.println("\t\t** 상품목록 보기 **");
		for(int i=0;i<parr.length;i++)
		{
			parr[i].printProduct();
		}
	}
	
	 private static String getMenu()
	 {
		 System.out.println();
		 System.out.print("추가(a), 목록(s), 검색(f), 장바구니 보기(i), 수정(u), 삭제(d), 종료(x):");
		 String m = kbd.nextLine();
		 return m;
	 }
	
	private static int find() //실제에서 찾는것과 보여주는것은 분리된다 찾는건 서버에서 찾고 보여주는건 클라이언트 피씨에서 보여주는게 대부분이기에
	{
		System.out.print("상품번호");
		int pnum = kbd.nextInt();
		kbd.nextLine();
		for(int i=0;i<parr.length;i++)
		{
			if(parr[i].getId()==pnum)
			{
				return i;
			}	
		}
		return -1; //이렇게해서 -1이 나오면 검색 실패로 인식하게 즉 이곳은 화면출력을 안하고 검색기능에 충실하게 되는것 이다.
	}
	
	private static void showFind(int i)
	{
		if(i==-1)
		{
			System.err.printf("상품번호를 확인해주세요");
			return; //리턴할게 아무것도 없으니 이게 맞다 만약 뭘 쓰면 그게 에러가 난다.
		}
			parr[i].printProduct();
			System.out.println();
			System.out.println("추가(a), 목록(s), 장바구니에 담기(c), 검색(f), 수정(u), 삭제(d), 종료(x):");
			String m = kbd.nextLine();
			if(m.equals("c"))
			{
				putInCart(i);
			}
	}
	
	private static void putInCart(int i)
	{
		cart[cartCnt++] = parr[i];
		System.out.println("장바구니에 담았습니다.");
		
	}
	
	private static void showCartItems()
	{
		if(cart.length==0)
		{
			System.err.println("장바구니에 상품이 없습니다.");
			return;
		}
		System.out.println();
		System.out.println("\t\t** 장바구니 보기 **");
		for(int i=0;i<cartCnt;i++) //여기서 가운데를 카운터가 아니라 length로 하면 에러가 뜨는데 그건 이미배열 갯수는 여러개인데 하나만 채운상태로 출려하니 에러난다 즉 카트에 담은 수를 카운트 하는 카운트의 양과 비교해야한다.
		{
			cart[i].printProduct();
		}
		
		System.out.print("계속쇼핑(t), 품목삭제(r):");
		String sm = kbd.nextLine();
		
		if(sm.equals("t")) return;
		else if(sm.equals("r"))
		{
			System.out.print("삭제할 품목번호:");
			int delNum = kbd.nextInt();
			kbd.nextLine();
			int delIdx = -1;
			for(int i=0;i<cartCnt;i++)
			{
				if(cart[i].getId()==delNum)
				{
					delIdx = i;
					break;
				}
			}
			if(delIdx==-1)
			{
				System.err.println("품목번호를 다시 확인해주세요");
				return;
			}
			for(int i=delIdx;i<cartCnt-1;i++)
			{
				cart[i] = cart[i+1];
			}
			cartCnt--;
			System.out.println("품목 삭제 성공");
		}
		/* 내가 만든 버전
		System.out.println("삭제할래? y :");
		String m = kbd.nextLine();
		if(m.equals("y"))
		{
			cartDel();
		}
		*/
	}
	   private static void login() {
		      System.out.print("아이디 암호:");
		      String id = kbd.next();
		      String pwd = kbd.nextLine();
		      if(id.equals("smi")) {
		         userId = "smith";
		         System.out.println("로그인 성공");
		      }else {
		         System.err.println("로그인 실패");
		      }
		   }
	/*
	private static void cartDel()
	{
		System.out.print("삭제할 상품번호");
		int pnum = kbd.nextInt();

		for(int i=0;i<cartCnt;i++)
		{
			if(cart[i].getId()==pnum)
			{
				
				
				for(int a=0;a<cartCnt-1;a++)
				{
					cart[i]=cart[++i];
					
				}
			}	
			
		}
		cartCnt--;
		kbd.next();
		
	}
	*/
	
}




@Data
@AllArgsConstructor //아래변수를 모든 파라미터로 가지고 있는 생성자 생성된거임
@NoArgsConstructor
class Product
{
	
	private int id;
	private String name;
	private int price;
	private String pdate;
	private String  maker;
	
	public void printProduct()
	{
			System.out.printf("%d\t%10s\t%,d\t%s\t%s%n", id, name, price, pdate, maker); 
	}
}

/*내가 하다만거
@AllArgsConstructor 
@NoArgsConstructor
class Log{
	private String uid;
	private String pwd;

	public void printLog()
	{
			System.out.printf("s\t", uid); 
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
*/