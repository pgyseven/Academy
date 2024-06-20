package com.mbcac.oop;

public class Transport_mgr 
{


	
	public static void main(String[] args) 
	{
		/*
		 * 자동차 판매회사에서 5사지 차종에 대해서 차량의 정보를 표시하려고 한다.
		 * 제조사, 형식명(차이름), 연식, 가격, 차종(승용,트럭)
		 * 실물객체를 추상화하여 자바 클래스를 정의하고 인스턴스 배열을 생성하여
		 * 화면에 목록을 표시하는 기능을 작성해보세요.
		 * 생성자, private, setters, getters
		 */
	//static, private, this
		
		//System.out.println(Car.maker + " 자동차 목록"); //아래에서 말한거 처럼 메인 시작전 메모리에 static 변수 즉 클래스 변수가 로드되니 다른 지역의 변수 maker 도 불러올 수 있는데 지역명인 Car를 쓰고 점. 을찍어서 해당 변수를 불러와야한다.
		//클래스 변수 들은 클래스 이름 다음에 . 점을 찍고 쓴다.인스턴스 생성 전에 로드되기에 가능한거임
		System.out.println(Car.getMaker() + " 자동차 목록");
		
		
		//cars[0] = new Car(); //인스턴스 변수를 메모리에 할당 그리고 그 메모리는 비어 있다. 그럼 그 주소지에 값을 넣어야 하는데 그 주소는 cars[0]에 들어있다.//카클래스를 새로 메모리에 로드해라. Car 클래스를 로드한단건 static이 없는 아래 4가지 name 부터 type 까지 그리고 그 주소가 cars 에 입력된다.
		//cars[0].name = "d";
		
		//위 두줄 다른 방식 작성
		Car c1 = new Car("Avante", 2020, 2600, "승용"); //인스턴스 변수를 메모리에 할당
		System.out.println(c1.hashCode());
		Car c2 = new Car("Elatra", 2005, 1400, "트럭");
		Car c3 = new Car("surisu", 2011, 1000, "uv");
		Car c4 = new Car("master", 2012, 2000, "rv");
		Car c5 = new Car("bonggo", 2008, 5000, "빠른");
		
		cars[0]=c1;
		cars[1]=c2;
		cars[2]=c3;
		cars[3]=c4;
		cars[4]=c5;
		
		for(int i =0;i<cars.length;i++)
		{
			cars[i].printCar();
		}
		
		
		/*위에 처럼 쓰면 요거 아래꺼가 필요없다.
		c1.setName("Avante");
		c1.setYear(2024);
		c1.setPrice(2600);
		c1.setType("승용");
		
		Car c2 = new Car(); //인스턴스 변수를 메모리에 할당
		c2.setName("Elantra");
		c2.setYear(2005);
		c2.setPrice(1400);
		c2.setType("스포츠");
		*/
		
		/*
		//객체의 초기화
		c1.name = "Avan";
		c1.year = 2020;
		c1.price = 3000;
		c1.type = "승용";
		
		Car c2 = new Car();
		c2.name = "sona";
		c2.year = 2400;
		c2.price = 3022;
		c2.type = "트럭";
		
		Car c3 = new Car();
		c3.name = "equs";
		c3.year = 7050;
		c3.price = 9540;
		c3.type = "점보";
		
		Car c4 = new Car();
		c4.name = "morn";
		c4.year = 9210;
		c4.price = 1050;
		c4.type = "미니";
		
		Car c5 = new Car();
		c5.name = "land";
		c5.year = 8880;
		c5.price = 1000;
		c4.type = "트럭";
		
		cars[0] = c1;
		cars[1] = c2;
		cars[2] = c3;
		cars[3] = c4;
		cars[4] = c5;
		
		for(int i =0;i<cars.length;i++)
		{
			cars[i].printCar();
		}
			*/
	}
	static Car[] cars =  new Car[5]; //Car 참조 5개를 저장할 공간 확보//프로그램 실행시 자동으로 딱 한번만 로드되는데 static //메인 메소드보다 먼저 사용하기 위해 만약 static 이 없으면 new 로 로드 해야함 그러면 newTransport_mgr 즉 이게 실행되는 클래스를 불러와야하는 거임 
	//Car[5] 참조를 저장할 즉 주소를 저장할 4바이트 빈공간 5개 를 만들어라 // 해석 카의 주소 5개를 저장할 빈공간을 만들어 주세요.
	//정보인 이곳이 먼저 실행되고 메인이 돌아간다.
	//그리고 이 부분이 실행될때 메모리에 같이 로드 되는게 Car 클래스에 maket 부분이 static 이니 같이 로드된다.
		
}



	
//new 메모리에 로드 앞에 static 스테틱이 안붙은건 new 할때마다 로드됨
class Car// 지금 이화면 안에서만 쓸거니깐 생성자에 퍼블릭 안써도 된다.
{
	/*
	static String maker  = "한국자동차"; // class variable// 클래스로서는 로드되나 인스턴스 변수로는 선언 안됨 그래서 클래스 변수라함// 즉 같은 메이커 자동차 10대를 로드하는데 메이커는 같으니 10번 반복 안되게 static으로 함 // 자바가 실행되면 자동으로 로드됨 즉 이 아이는 개발자가 손댈수 없음 한번 로드되면 삭제도 불가 즉 static 말대로 정적일수 밖에 없다.
	
	String name; //instance variable //인스턴스 변수고 new 하면 로드됨 , 개발자에 의해서 내렸다 올렸다가 가능함
	int year;
	int price;
	String type;
	*/
	
	//객체지향 언어에서는 은닉성 변수는 프라이빗으로 가리는게 특징이다.
	//OOP 3대 특징 : 은닉성(ex private 외부 클래스에서 접근 불가), 다형성, 상속성 //객체지향 언어를 쓸데는 이 3가지가 쓰여야 한다. **************
	//Encapsulation, Polymorphism, Inheritance
	private static String maker  = "한국자동차";
	
	private String name; //instance variable //인스턴스 변수고 new 하면 로드됨 , 개발자에 의해서 내렸다 올렸다가 가능함
	private int year; 
	private int price;
	private String type;
	// 3대 특징중 하나라고 하지만 private 를 왜 써야하는가???? 변수를 개방하면 잘못 입력하거나 했을때 막을 방법이 없다.이런 즉 잘못된 값이 입력 하는 경우 기능을 통해서 필터링을 해서 막을 수 있게 그래서 set을 쓴다. 즉 set 안에 추가 기능을 넣을 수 있다.
	
	
	//생성자 명은 클래스 명과 동일  리턴타입은 없어야함 있으면 메소드임
	Car() {} //기본 생성자 default constructor
	Car(String name, int year, int price,  String type) // 파라미터 있는 생성자 
	{
		
		//this.name = name; //이렇게 하면 문법적 어긋남은 없지만 이렇게 하면 set 메소드의 필터링 기능 써둔걸 안거치고 그냥 쓰니 Set 을 써둔 의미가 없다
		
		//여긴 인스턴스 생성 직후 돌아간다 즉 빈 메모리 변수가 만들어지고 여기서 초기화한다.
		//인스턴스 멤버(인스턴스 메소두와 인스턴스 변수를 합쳐서)가 생성된 직후에 생성자 실행
		//클래스 멤버(클래스 메소드와 클래스 변수)
		System.out.println(this.hashCode());
		this.setName(name);
		setYear(year);
		setPrice(price);
		setType(type);
		
		//this.name = "Sable";  //즉 객체 생성할때(new car를 했을때) 의 주소가 this 인거고 new 했을때 돌아가니 new 주소와 여기 주소가 같다. //인스턴스 생성 직후 돌아가는거니 방급 앞서서 탄생된 인스턴스가 있을거 아니냐 거기에 넣어주는거다.
		//Car c = new Car(000) 이라고 했을때new 햇을때 car 생성자가 돌아가고 인스턴스가 생성 즉 메모리 빈공간생성 되고 그 주소가  C 에 들어간ㄷ.// 뉴카에 의해서 인스턴스 맴버를 로드(name, year, price type)한다. 즉 4개 들어갈 공간 4개 인스턴스 만들고 C에도 들어가고 new Car 에서 Car도 들어간다. 그래서 this에 표시됨  
	}
	
	
	void printCar() //private 를 쓸수 있다 쓰면 이 메소드는 이 클래스 안에서만 쓸수 있다가 된다. 액세스 모디파이어 종류: private 외부 접근 금지 다른곳에서 호출 금지, 액세스 모디파이어 자체가 없는게 디폴트 접근 이건 동일 패키지 내에서만 접근 가능 패키지는 맨위에 가서 확인하고 package 를 가 같은걸 달고 있으면 접근 가능하단것. , protected 동일 현재 패키지와 자식 즉 class  접근 가능(디폴트보다 넓은 범위) , public 어디에서나 접근 가능  
	{
		System.out.printf("%s\t%9s\t%d\t%d\t%s%n", 
				maker, name, year, price, type); 
	}

	
	public static String getMaker() {
		return Car.maker; //static 변수니깐 바로 return maker 라고만 써져 있으니 기왕이면 헷갈릴수 있으니 Car라고 붙여주는게 좋다.
	}

	public static void setMaker(String maker) {
		Car.maker = maker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year<2024) this.year = year;
		else 
		{
			System.err.println("연식은 미래 날짜를 사용하지 말것");
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}