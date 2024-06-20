package com.mbcac.array;

import java.util.Arrays;
import java.util.Random;

public class ArrayDemo {
	//배열 실습
	public static void main(String[] args) 
	{
		//배열 : 일련의 메모리 공간에 다수개의 데이터를 저장하는 자료구조(Data Structure)
		//성적관리(java,jsp,python)한학생마다 3개의 정수 공간이 필요한 상활일거다.
		//한 학생마다 과목 3개의 점수를 저장할 자료구조 필요함
		//int[] credit = new int[3] 설명위해 아래처럼
		//int[] credit; //정수가 다수개 있는 구조다 그럼 그정수가 공간 몇개 할것이냐   //배열변수 생성(선언)
		//credit = new int[3];  //new가 정수 3개를 준비, 새로 정수 3개 공간을 확보합니다. //12바이트 할당 1개당 3바이트
		/*credit[0] = 80; //이주소(credit)에 가서 어디가지말고 그자리에 80을 넣어 //초기화(Initialization) //프로그램에서는 0이 첫방을 의미하고 이것이 합리적이다
		credit[1] = 90; // 이주소에 가서 하나 건너뛰어서 이동한 방에  90을 넣어라 //[]안에 번호는 색인 번호 이다(index)
		credit[2] = 95; //이 3과정이 초기화
		//배열변수 선언, 메모리 할당, 초기화, 사용
		//방번호는 for 루프를 사용해서 생성하는게 보통이다. 배열이 나오면 처리는 대부분 for문이 나와서 처리한다고 생각해라
		
		
		//for 루프를 사용하여 배열 원소를 초기화 해보세요.
		int[] credit; 
		credit = new int[5];

		Random rd = new Random(); 
		for(int i=0;i<credit.length;i++) 
		{
			credit[i] = rd.nextInt(50); //초기화 한다.
		}

		for(int i=0;i<credit.length;i++) 
		{
			credit[i] = rd.nextInt(50);
			
			System.out.print(credit[i]+ " ");
			
		}
		
		
		// 오름차순(Ascending), 내림차순(Descending)
		// 선택정렬(Selection sort) 9,42,23,30,44 --> 9,23,30,42,44
		
		//맞바꿈 알고리즘 스왑 알로리즘 swap
		//swap 알고리즘 : a=5, b=3, -> a=3, b=5
		int a = 5, b = 3;
		int c = a;
		a=b;
		b=c;
		*/
		
		//swap, selection sort 알고리즘 배열원소 정렬하기
		int[] credit; 
		credit = new int[5];

		Random rd = new Random(); 
		for(int i=0;i<credit.length;i++) 
		{
			credit[i] = rd.nextInt(50); 
		}
		

		for(int i=0;i<credit.length-1;i++) //선택 0 1 2 3 까지만 4는 비교대상 아니니깐
		{
		

			for(int j=i+1;j<credit.length;j++) //비교대상
			{	
			
				if(credit[i]>credit[j])//swap 여부
				{
					int tmp = credit[i];//여기서 부터 아래까지 swap
					credit[i]=credit[j];
					credit[j]=tmp;
				}
		
			}
		}
		System.out.println(Arrays.toString(credit));
		System.out.println("프로그램 종료");
		
		
		
		
		
	}

		
}


