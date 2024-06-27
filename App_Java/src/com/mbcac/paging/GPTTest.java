package com.mbcac.paging;

import java.util.ArrayList;
import java.util.List;

public class GPTTest {

	public static void main(String[] args) {
		
		//int currentPage, int itemsPerPage, int totalItems 생성자 pagination 꺼 참조하기 위해 가져온 것
		Pagination<Board> pagination = new Pagination<>(1, 2, 10); //1페이지고 화면당 2개를 보여줘 DB에는 총 10개행이 있어  //이건 모델 1에서 usebean 으로는 불가능 자바 코드 사용해야 함
		
		
		List<Board> list = new ArrayList<>();
		
		for(int i=0;i<10;i++) {
			list.add(new Board(i));
		}
		pagination.setItems(list);
		
		int ttlPages = pagination.getTotalPages();
		System.out.println("총 페이지 수:" + ttlPages);
		
		System.out.println("첫 페이지인가?:" + pagination.isFirstPage()); //첫 페이지 왔을때 여기가 끝이다 보여주는 용으로 사용 가능
		
		System.out.println("다음 페이지 번호:" + pagination.getNextPage()); //new Pagination<>(1, 2, 10)이거에 따라 현재 페이지 1이니깐 여기서 다음페이지인 숫자 2가 나온다.
	}

}

/* Model 1, BoardList.jsp 목록 페이지에서 한 화면에 아이템(Board) 3개를 표시해보세요.(SQL)
 * http://localhost/Myp/jsp/board/boardList.jsp?page=3
 */
