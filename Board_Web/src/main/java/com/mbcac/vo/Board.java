package com.mbcac.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board 
{
   private int num;
   private String title;
   private String author;
   private String contents;
   private java.util.Date regDate; 
   private int hits;
   
   public Board() {
   }
   
   public Board(int num) {
      this.num = num;
   }

   public Board(int num, String title, String author, String contents, Date regDate, int hits) {
      this.num = num;
      this.title = title;
      this.author = author;
      this.contents = contents;
      this.regDate = regDate;
      this.hits = hits;
   }

   public Board(String[] tok) 
   {
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   try {
		   this.num = Integer.parseInt(tok[0]);
		   this.title = tok[1];
		   this.author = tok[2];
		   this.contents = tok[3];
		   this.regDate = sdf.parse(tok[4]);  //문자열이 아니라 date 형이라 tok[4]로 하면 에러난다. 여기서 문자열을 오브젝트로 변환하는게 위에서 필요한다.
	} catch (ParseException e) {
		e.printStackTrace();
	} //원래 tok[4] 만 트라이 캐치 안에 넣으면 되는데 그이외것도 그냥 넣은건 차라리 하나라도 초기화 안되면 에러 뜨는게 더 안전하니 안으로 넣었다
	   this.hits = Integer.parseInt(tok[5]);	   
   }

@Override
   public boolean equals(Object obj) {
      Board other = (Board)obj;
      return this.num==other.num;
   }

   @Override
   public String toString() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
      String strDate = sdf.format(regDate);  //날짜를 문자열로 문자를 날짜 오브젝트로 하는건 sdf.parse(strDate) 
      return String.format("%d|%s|%s|%s|%s|%d", num,title,author,contents,strDate,hits);  //이걸 쪼개려면\\ 역슬레시 두개 줘야한다. 즉 특수 문자는 이렇게 해야한다. line.split("\\|"); 즉 특수 문자 | 이걸 기준으로 쪼갤때
   }

   public int getNum() {
      return num;
   }

   public void setNum(int num) {
      this.num = num;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public String getContents() {
      return contents;
   }

   public void setContents(String contents) {
      this.contents = contents;
   }

   public java.util.Date getRegDate() {
      return regDate;
   }

   public void setRegDate(java.util.Date regDate) {
      this.regDate = regDate;
   }

   public int getHits() {
      return hits;
   }

   public void setHits(int hits) {
      this.hits = hits;
   }
}
