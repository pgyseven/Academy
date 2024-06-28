package com.mbcac.board;
import java.util.ArrayList;
import java.util.List;

public class Pagination<T> 
{
    private int currentPage;    // 현재 페이지 번호
    private int itemsPerPage;   // 페이지 당 항목 수
    private int totalItems;     // 총 항목 수
    private int totalPages;     // 총 페이지 수
    private List<T> items;      // 현재 페이지의 항목 목록 //화면에 출력할게 여기 들어있을 것 이다.

    public Pagination(int currentPage, int itemsPerPage, int totalPages) {
        this.currentPage = currentPage;
        this.itemsPerPage = itemsPerPage;
        //this.totalItems = totalItems; 토탈페이지를 구하기 위한 데이터 였는데 위에서 토탈 페이지로 바뀌고 바로 받아오니깐 사라짐
        this.totalPages = totalPages;
       // this.totalPages = (int) Math.ceil((double) totalItems / itemsPerPage); 우린 오라클에서 sql로 설명을 하니깐
    }

    public List<Integer> getPageNums() {  //한 화면에 페이지 번호 3개만 표시되도록 하기
    	int start = currentPage-1; //시작번호
    	int end = currentPage+1; //끝번호 아닐경우 대비 아래서 보정 
		
    	 start = start>0 ? start : 1;
         end = end<totalPages ? end : totalPages;
		
		
				
         end = start+2<totalPages ? start+2 : totalPages;		//총 페이지 수 항상 3개가 나오게끔
         start = end-2>0 ? end-2 : 1;
         
         List<Integer> pages = new ArrayList<>();
         for(int i=start ; i<=end ; i++) {
            pages.add(i);
         }
         return pages;
      }
    
   
    
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
        this.totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    // 첫 번째 페이지인지 여부를 반환하는 메서드  
    public boolean isFirstPage() {
        return currentPage == 1;
    }

    // 마지막 페이지인지 여부를 반환하는 메서드
    public boolean isLastPage() {
        return currentPage == totalPages;
    }

    // 이전 페이지 번호를 반환하는 메서드 (첫 페이지인 경우 1을 반환) //이용자가 네비게이션 할때 왼쪽 이동 오른쪽 이동에서 왼쪽을 누르면 이게 돌아간다. 그러면서 숫자가 나온다 왼쪽으로 이동할 페이지 번호
    public int getPreviousPage() {
        return (currentPage > 1) ? currentPage - 1 : 1;
    }

    // 다음 페이지 번호를 반환하는 메서드 (마지막 페이지인 경우 마지막 페이지 번호를 반환) //다음페이지
    public int getNextPage() {
        return (currentPage < totalPages) ? currentPage + 1 : totalPages;
    }
}