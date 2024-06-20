package com.mbcac.ClassEx;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
		{
		/*
			//클래스를 로드하여 객체(Object, Instance(실체)class 라는 설계도로 실체를 만든다.는 의미로 즉 실체화 되었다는 의미로 instance 라 한다.)를 생성한다.
			Car car = new Car(); //Heap에 car 객체 생성//Heap((동적메모리)프로그램 실행중일때 메모리가 할동되는 영역)메모리 영역에 로드 //이렇게 하면 메모리에 로드됨 // 객체를 생성하는 명령은 new 이다. //이 주소로 가면아래의 변수가 있으니 각해당값으로 초기화를 해라.
			car.pName = "Sonata"; //Heap에 이 4개의 변수 생성
			car.madeBy = "Korea";
			car.price = 3000;
			car.power = 200;
			//car라는 주소에 가서 pName이라는 변수를 찾아서 sonata를 입력시켜
			//Static으로 하면 한번만 로드됨
			
			Car car2 = new Car(); //뉴를 할때마다 인스턴스가 생성되고 그 인스턴스로 가면 해당 변수가 생성됨 지금 경우 카1 카2 니깐 총 8개의 변수가 있다.
			car.pName = "Avante"; 
			car.madeBy = "China";
			car.price = 2000;
			car.power = 100;
			
			System.out.println("자동차 이름:"+car.pName);
			car.printInfo(); //객체의 기능을 호출
		
		
		
		
		//실물객체 추상화를 통한 클래스의 정의
		//Pet의 정보를 보여주는 사이트를 만들 떄 사용할 클래스를 정의하려고 한다.
		//species(종), price, weight, length
		//위와갗은 속성을 사용하여 클래스를 정의하고 인스턴스를 생성하여
		//모든 속성을 출력해주는 메소드를 호출해보세요.

		Pet dog = new Pet();  		//인스턴스 생성
		dog.species = "shipdog";	//인스턴스 초기화 근데 PET 관련클래스를 현재 다른 클래스인 여기서 초기화 하는건 좋은건 아니다. 생성자라는 기능을 통하여 초기화 로직이 자동으로 하는게 가능.
		dog.price = 1240;
		dog.weight = 20;
		dog.length = 123;

		
		Pet cat = new Pet(); 
		cat.species = "persian";
		cat.price = 1040;
		cat.weight = 200;
		cat.length = 123.2F;
	
	
		
		Pet dog = new Pet("pome", 100, 75, 32);  
		Pet cat = new Pet("dfd", 123,6,53); 
		
		Pet[] pets = new Pet[] {dog,cat}; //Pet[] pets 참조 배열변수 선헌 ,new Pet[]  메모리 확보
		for(int i=0;i<pets.length;i++)
		{
			pets[i].showInfo();
		}
	
		
		Pet[] pets = new Pet[2];
		pets[0] = new Pet("pome", 100, 75, 32);  
		pets[1] = new Pet("dfd", 123,6,53); 
		
		//Pet class 의 this 주소와 메인에서 new 해서 나오는 주소가 같다. 아래의 코드로 확인 가능하다
		System.out.printf("강아지 인스턴스의 주소=%d%n", pets[0].hashCode());//hashcoe 10진수코드 알수 있다.
		
		for(int i=0;i<pets.length;i++)
		{
			pets[i].showInfo();
		}
		
	
		Pet dog = new Pet(); 
		
		Pet cat = new Pet("persian",15000);
		//cat.species = "똥개"; // 실수라고 가정하고 이렇게 썻다면 생성자에서 했던 초기화값 persian이 사라지고 똥개가 입력된데 이런걸 원천적으로 막고 생성자만 접근하게 하겠다 가 가능하다. 이걸 코딩하면 에러나게 하는 방법이 있다 즉 외부에서 보안상 인스턴스 변수값을 수정 못하게 하겠다. 해당 클래스의 사유재산이다 그럼 pet class 로 가서 각 변수에 앞에 private 를 추가한다.그러면 이 문구가 not visible 즉 보이지 않는다라고 뜬다.
		//cat.showInfo();
		
		//System.out.println(cat.species); private 때문에 읽어오기도 안됨
		System.out.println(cat.getSpecies()); //private 경우 이런식으로 퍼블릭 메소드를 통하여 가져온다. 즉 간접 접근 저쪽 클래스에서 건네 받아서
		
		
		Pet dog = new Pet(); 
		//dog.getSpecies = "Pome"; //이런경우  위에서 기본 값으로 로드한 경우에도 이와 같이 기억을 시키려고 할때 private 로 되어 있으니 쓸수가 없다 이런경우도 간접으로 읽듯이 간접으로 써야한다 이걸 세팅이라 한다. 불러오는 클래스 내에 간접으로 세팅하자. public void setSpecies(String species){this.species = species;}
		dog.setSpecies("pome"); //간접 set 실제는 이런식으로 많이 한다. 메소드를 통한 속성값의 초기화는 쓰던 안쓰던 이렇게 하는게 좋다.
		
		Pet cat = new Pet("persian",15000);
		//set과 get 을 가능하면 항상 써라 그러나 해당 값마다 set과 get을 쓰면 짜증 나니깐 한세트로 하는건 이클립스가 해줌
		*/
		
		//Class, Instance기반의 CRUD
		//키보드에서 번호, 종, 가격, 체중, 길이를 입력받아서 인스턴스를 초기화하고
		//인스턴스를 배열에 저장한다.
		//추가(a), 목록(s), 검색(f), 수정(u), 삭제(d), 종료(x): 
		//pet class와 집접적으로 연관되어 있으면 넣고 다른건 메인클래스에~ 즉 추가 ~ 종료는 펫 클래스에 넣으면 안됨
		//목록보기 할때 한펫의 정보가 한행에 나와야 하는데 한줄을 찍어주는건 펫에다가 하는게 좋다 펫의 정보를 가져다 그대로 찍어주는거니 직접 연관이다.
		//나머지는 배열과 연관이니 메인에~
		
				
		String mStr = "추가(a), 목록(s), 검색(f), 수정(u), 삭제(d), 종료(x):";
		Scanner kbd =  new Scanner(System.in);
		
	
		while(true)
	    {
			System.out.print(mStr);
			String m = kbd.nextLine().trim();
			
			if(m.equals("x"))break;
			else if(m.equals("a")) addMember();
			else if(m.equals("s")) list(); 
			else if(m.equals("f")) find();
			else if(m.equals("u")) update();
			else if(m.equals("d")) delete();
		}
		
		System.out.println("프로그램 종료");	
	}
		

	static int idx;
	static Pet[] pets = new Pet[10];
	
	public static void addMember()
	{    
	
		Scanner kbd = new Scanner(System.in);
		System.out.printf("번호, 종, 가격, 체중, 길이:");	
		
		int num = kbd.nextInt();
		String species = kbd.next(); 
		int price = kbd.nextInt();
		float weight = kbd.nextFloat();
		float length = kbd.nextFloat();

		pets[idx] = new Pet(num,species,price,weight,length);
		
		idx++;
		System.out.println("펫 정보 추가 성공");
		 	
	}
	
	public static void list()
	{    

	
		for(int i=0;i<idx;i++)
		{
			pets[i].showInfo();
		}
	}
	
	public static void find()
	{    
		Scanner kbd = new Scanner(System.in);
		
		
		int findIndex = -1;
		

			System.out.print("검색할 펫 번호");
			int no = kbd.nextInt();
			for(int i=0;i<idx;i++) 
				
			{
				if(pets[i].getNum() ==no)
				{
					findIndex = i;
					break;
				}
			}
		
			
		if(findIndex==-1) 
		{
			System.err.println("펫번호 검색 실패");
			return;
		}

			pets[findIndex].showInfo();

	}
		
	public static void update()
	{    

		Scanner kbd = new Scanner(System.in);
		System.out.print("펫번호 새로운이름:");
		int no = kbd.nextInt();
		String newName = kbd.nextLine().trim();


	
		for(int i=0;i<idx;i++) 
		{   
			if(pets[i].getNum() ==no)
			{   
				pets[i].setSpecies(newName);
		
				System.out.println("새로운 이름으로 수정 성공");
				break;
			}
		}
	}

	public static void delete()
	{    

		Scanner kbd = new Scanner(System.in);
		System.out.print("삭제대상 펫번호:");
		
		int no = kbd.nextInt();
	

		int delIndex = -1;
		for(int i=0;i<idx;i++) 
		{   
			if(pets[i].getNum()==no)
			{   
				delIndex = i;
				break;
				

			}
		}
		for(int i=delIndex;i<idx-1;i++)
		{
		pets[i] = pets[i+1]; //이거는 메모리는 그냥 있고 주소를 바꾸는것 즉 가비지 데이터는 있는 상태임 이건 가능함
	
	
		}
	
		idx--;
		if(delIndex>-1)System.out.println("회원정보 삭제 성공");
		else System.err.println("회원정보 삭제 실패");
		
	}
	
	
		
	

}
