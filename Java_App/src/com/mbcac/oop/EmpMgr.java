package com.mbcac.oop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

public class EmpMgr 
{
	
	public static void main(String[] args) 
	{
		/* 사원관리 프로그램 //이야기 해준거 내 생각 정리!!!이런경우 실무에서는 말단 사원이 매니저가 있을거고 이런경우 그게 추상할 객체가 된다고 생각할 수 있다.
		 * 사원 클래스 정의(사번, 부서명, 급여, 입사일)
		 * initEmps() 호출하면 5명의 사원정보가 배열로 리턴되도록 한다.(실뭄객체 생각했을 때 사원과 관련이 깊은지 아닌지 생각하고 어디 클래스에 배치할지 생각)
		 * printEmps() 는 사원정보 목록을 화면에 표시한다.
		 * 회사명 : 화곡인터네셔널
		 * ***작성시 항상에러 발생하면 그것 부터 바로 해결해라
		 */
		
		//1첫번째 방법 Employee[] emps = initEmps();
		emps = initEmps();
		
		//1첫번째 방법 printEmps(emps); //클래스 메소드 호출하는 형식이다.즉 static 있어야함
		printEmps();

	}
	
	static Employee[] emps;
	
	//1첫번째 방법 private static void printEmps(Employee[] emps)
	private static void printEmps()
	{	System.out.println(Employee.getCompany()+" 사원목록"); //클래스 메소드는 클래스 다음에 점찍고 사용
		for(int i=0;i<emps.length;i++)
		{
			emps[i].printEmps();
		}
	}
	
	private static Employee[] initEmps() //stastic 없으면 인스턴스 메소드(있으면 클래스 메소드) 즉 new 해당 클래스 즉 Emp Mgr 해야함 그러면 뉴를 두번 해야하니 static 붙인다.//여기 메인 클래스에서만 쓸거니 3대 특징에 따라서 은닉성을 위해 private
	{

			
			Employee[] emps;		//배열변수 선언 //emps라는 변수가 메모리에 생긴다. 
			//emps라는 메모리 공간이 생긴건데 그 공간의 크기는 4바이트다.해당 공간에는 주소를 넣을것이다. 근데 그게 어떤형의 주소? 그게 Employee 배열의 주소를 담는다 즉 엠플로이 배열의 주소를 담을 emps
			//여기서는 emps는 비어있게된다. 만약 초기화 해야할경우 null을 한다.그러나 아래서 할거라서 여기선 안한다.
			emps = new Employee[5];	//Employee참조 공간 확보//확보했다는건 그 주소를 리턴/ 공간 몇개인지 선언
			//employeee는 참조형이고 참조형 5개를 저장할 공간 참조형 한개는 4바이트 그게 5개니 총 20바이트 공간이 어딘가에 생길것이다.
			//여기서 new 의 역할은 employee 참조 공간 5개를 만들란거고 얘는 항상 그 주소를 뱉어낸다. 메모리는 일련의 공간에 20바이트 공간이 빈틈없이 쭉 한번에 생성된다. 
			//그리고 생성된 배열 주소가 emps에 저장된다 
			//그리고 20바이트 주소에는 employee 참조 데이터만 들어갈수 있고,그 빈 공간에는 emps 와 같은 변수의 주소가 들어간다.
			
			emps[0] = new Employee(2401, "1팀","10억","2024년");//주소의 공간의 0번째에 
			//employee 클래스안에서 new 할때마다 메모리에 로드되는 변수 즉 인스턴스 맴버, 인스턴스 변수(static이 없는) 그래서 인스턴스 생성이라 부른다.
			//employee 클래스에 있는 empno; dname; sal; hiredate; 변수가 하나의 배열로 뿅하고 생성하고 그 주소가 아까 확보한 30바이트 공간중[0]번에 들어간다.
			// emps 에 가면 방이 5개 있고 그방에 0번째에는 4개의 변수가 들어있는 주소가 들어있다.
			emps[1] = new Employee(2301, "4팀","20억","2023년");
			emps[2] = new Employee(9501, "3팀","15억","1995년");
			emps[3] = new Employee(8001, "2팀","15억","1980년");
			emps[4] = new Employee(2301, "5팀","60억","2023년");
			
			return emps; //Employee[]배열로 리턴한다고 했으니 emps는 임플로이 배열이니 emps를 리턴		
	}

}
//VO(value object) 데이터 중심의~ 즉 변수가 중정이 되는~ 아래를 이와 같이 부르기도 한다. 또는 DTO(Data Transfer object)데이터 가 이동한다.

@Data //get set 인되 화면에는 안보이지만 있다 근데 스테틱에서 부르는건 안되니 생성 되는게 있고 안되는게 있어서 불안한 상태다
@AllArgsConstructor //파라미터를 가진 생성자  모든 아규먼트를 가진 생성자.
@NoArgsConstructor //기본 생성자


class Employee
{	
	private static String company ="화곡인터네셔널";
	private int empno;
	private String dname;
	private String sal;
	private String hiredate;
	

	public void printEmps()
	{

			System.out.printf("%d\t%s\t%s\t%s%n",empno,dname,sal,hiredate ); 
			//하나의 사원 정보를 저장하는 거고 하나의 사원 정보를  쓰는거니 여기에 써도 적절하다.

	}


	public static String getCompany() {
		return company;
	}
	

}