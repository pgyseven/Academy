package com.mbcac.ClassEx;

public class Car
{
	/*클래스 멤버 / 인스턴스 멤버
	 *OOP(Objet Oriented Programming)객체 지향 프로그래밍 
	 *모든 기능을 객체에 담아서 사용하려고 하는 프로그래밍 방식 //한개의 기능은 메소드로 쓸수 있다 그 기능을 그룹화해서 담아서 쓴다 즉, 객체에 담아서 사용
	 *객체(object): 고유한 속성 (개발에서는 변수에 속한다.// 속성이란 물건이 가지고 있는 성질 고유한 특징 ex)리모콘 색상,버튼이 몇개있다. 전원이 빨갛다. 셀 수 없을 만큼 많은 제조사 재질 수입처 모양 무게 등 이 사물과 관련되 명사로 표현되는 모든 것)과 
	 기능(메소드)(ex)리모컨 각 버튼의 기능들)을 가진 사물/(이나)개념 이다. 사물이란건 속성과 기능으로 구분할수 있고 한 사물에 포함되어 있구나!리모콘에 소비자가 관심있어할 만한 속성과 기능을 모아서 클래스로 모델링한다. 
	 *우리는 클래스를 볼때 위의 객체 보듯이 봐야 한다.
	 *클래스는 객체를 생성하기 위한 설계도이다.세상의 물건을 다루듯 해보아라 리모콘이라 치면 클래스 이름은 리모콘이고 그에 기능과 속성을 만든다.
	 *실물객체의 추상화(Abstraction)
	 *변수는 실물꺼에서 녹여내지만 실물의 기능은 여기에 녹일수 없다 즉 자동차면 태우거나 가거나 코딩으로는 못하니 그 기능은 앞에 해당하는 속성을 출력한다.
	 *자동차라는 실물 객체로부터 속성과 긴으을 추출한다.
	 *속성 : 이름, 가격, 색상, 엔진출력, 몇인승, 연료, 제조사, 연식(자동차 페인트는 어디꺼냐 이런것도 속성이지만 관심없는거니 제외)
	 *구체화의 반대인 추상화를 하라했으니 실물에서의 몇가지만 가지고 자동차나 해당 객체라 한다는 의미에서 추상화 한다.
	 *기능 : 속성을 출력하는 기능
	 *
	 */
	
	//속성(property, Field) : 덜 객체 지향적 언어로는 Member Variable //Static  있는 변수는 class 변수, 없으면 instance 변수
	String pName; //이런 3가지 변수들은 속성이라고 한다. instance variable
	String madeBy;
	int price;
	int power;
	//위의 속성은 차라고 가정하에 만들었고 클래스는 안봐껏지만 차를 만든거니 클래스는 Car 인게 맞다.
	public void printInfo() //Static은 정적이다 고정되다 라는 말인데 이건 개발자가 손을 대지 않아도 자동으로 메모리에 로드되고 작동된다. 즉 로드하라는 명령 없이도 알아서 돌아간다. Static이 없으면 개발자가 돌아가게 해야한다.
	//Static 없으니 instance 메소드라 한다.
	{
		System.out.printf("%s\t%s\t%d\t%d%n", pName, madeBy,price,power);
	}
	
	//앞으로 보개될 클래스는 아래의 메인이 없을것이다.
	/*
	public static void main(String[] args) 
	{
		//클래스를 로드하여 객체(Object, Instance(실체)class 라는 설계도로 실체를 만든다.는 의미로 즉 실체화 되었다는 의미로 instance 라 한다.)를 생성한다.
		Car car = new Car(); //이렇게 하면 메모리에 로드됨 // 객체를 생성하는 명령은 new 이다. //이 주소로 가면아래의 변수가 있으니 각해당값으로 초기화를 해라.
		car.pName = "Sonata";
		car.madeBy = "Korea";
		car.price = 3000;
		car.power = 200;
		
		System.out.println("자동차 이름:"+car.pName);
		car.printInfo(); //객체의 기능을 호출
	}
	*/
}
