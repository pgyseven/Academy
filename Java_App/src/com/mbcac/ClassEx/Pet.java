package com.mbcac.ClassEx;

public class Pet {
	
	private int num;
	private String species; 
	private int price;
	private float weight;
	private float length;
	
	
	public Pet() {} 
	
	public Pet(int num, String species, int price, float weight, float length ) 
	{
		this.num = num;
		this.species = species;
		this.price = price;
		this.weight = weight;
		this.length = length;


	}
	
	

	public void showInfo()
	{
		
		{
			System.out.printf("%d\t%10s\t%,d\t%.1f\t%.1f%n",num, species, price, weight, length); 
	}
		
	}


	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setSpecies(String species)
	{
		this.species = species;
	}
	
	public String getSpecies()
	{
		return this.species; 
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}
	
	
	/*
	
	//인스턴스 변수 즉 new 할때만 로드 된다.
	private String species; //이런 3가지 변수들은 속성이라고 한다. instance variable
	private int price;
	private float weight;
	private float length;
	//private 를 붙여 외부 접근 막음 이런걸  Access Modifier : 그종류는 즉 접근제한자 종류는 4가지이고default 가 키워드가 없다 즉 	private float length; 이거에서 private 안쓰면 그게 default가 되는 거다.
	//protected 자식만 가능하다.
	//4가지 private, default, protected, public
	//private 등의 기능은 안전성은 올라가나 편의성은 떨어짐, 근데 이렇게하면 바꾸는걸 불가하게 했지만 가져다가 쓰는것도 안되게 된다. 즉 메인에서 System.out.println(cat.species); 이렇게 해서 단순 읽는것도 안된다.
	//그래서 읽기는 가능하게 하는건  public String getSpecies(){return this.species;}와 같이 쓴다 아래 써져있음
	
	
	//생성자는 많이 생성할 수 있다. 여러개를 선언하는 걸 생성자 오버로드라고 한다.
	//생성자 오버로드(Constructor Overload)
	//기본 생성자의 생김새는 아래와 같다.
	//public Pet() {} 값을 초기화 하지 않을땐 이렇게 쓰게 면된 물론 안써도 기본 생성자는 자바가 자동 지원 그러나 아래것과 같이 함께 쓰고자하면 이렇게 쓴다. 즉 객체 생성만 해두고도 싶을때
	public Pet() {}  //얘는 되도록 생성자를 생성할때 어떠하던 그냥 무조건 써주는게 에러를 방지 하기에 좋다.
	
	public Pet(String species, int price)
	{
		this.species = species;
		this.price = price;
	}
	//생성자(Constructor) : 인스턴스 변수의 초기화를 목적으로 자동!!!(new할때)으로 돌아가는거/ 이건 메소드가 아니기에 우리가 호출할 수 없다 리턴타입이 없다 우리가 만드는 메소드는 최소 void 라고 있다.
	public Pet(String species, int price, float weight, float length ) //class 명과 동일해야함 //위에 메모리 되면 이게 자동 실행
	{
		//생성자나 메소드는 위에 인스턴스 변수들이 로드된 다음에 돌아가니 그들의 주소를 알수 있고 그걸 this 라고 한다. 그래서 this라하면 그 주소에 바로 값을 줄 수 있다.
		this.species = species;
		this.price = price;
		this.weight = weight;
		this.length = length;
		//Pet dog = new Pet();  ()기본 생성자를 호출하는 방법 이들을 기본으로 부르면 컴파일러가 자동으로 해주는 기본 생성자는 사라지기에 에러뜸		Pet dog = new Pet("pome", 100, 75, 32);  
		//Pet cat = new Pet("dfd", 123,6,53); 생성자가 생기면 이렇게 호출해야함
		//여기서는 지역변수 맴버 변수가 이름이 같아서 this라 써야하고 만약 아래와 같이 지역변수와 같이 않으면 써야한다.
		//this 주소와 메인에서 new 해서 나오는 주소가 같다. 아래의 코드로 확인 가능하다
		System.out.printf("Pet 인스턴스 주소=%d%n", this.hashCode());//hashcoe 10진수코드 알수 있다.
	}
	
	
	//인스턴트 메소드 즉 new 할때만 로드 된다
	public void showInfo()
	{
		System.out.printf("%10s\t%,d\t%.1f\t%.1f%n", species, price, weight, length); 
		//%10s 문자 우측 정렬 개이름의 불규칙성을 해소하기 위해 10자로 맞춘거임 10자 미만은 우측에 공백을 넣어서 같게 
		//%.d 3자리 마다 , 넣어라
		//.1f 소수점 이하 첫자리까지만
	}
	
	
	//아래와 같이 간접적으로 하는 이유는 해당 값이 직접근을 막고 그 값을 필터링 할 수도 있기 때문 간접 작성시 나이가 들어오는데 이 나이를 예를 들어 마이너스로 쓴다면 if 문등을 추가하여 마이너스를 뺀다는 등의 방식으로 프로그램 안정성을 높인다.
	public void setSpecies(String species)
	{
		this.species = species;
	}
	
	public String getSpecies()
	{
		return this.species; //지금 private 값으로 막혀있으니 클래스 내에서 public 메소드 즉 누구나 호출 가능한 메소드를 통해서 공개되지 않은 변수의 값을 복사해서 리턴해준다 즉 값은 받아볼 수 있게 해준다.
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}
	//******위와 같이 get과 set 을 자동으로 만들어 주는건 이클립스 기능이며 마우스 우클릭 후 source >>> generate getters and stetters 클릭
	*/
}
