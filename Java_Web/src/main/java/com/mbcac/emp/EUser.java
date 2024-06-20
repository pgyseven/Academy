package com.mbcac.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EUser {
	
	   private int empno;
	   private String ename;
	   private String sal;
	   private String hiredate;
	   private String image;
	   
	   public EUser() {}

	   public EUser(int empno, String ename, String sal, String hiredate, String image) {
	
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.hiredate = hiredate;
		this.image = image;
	   }

	   public EUser(String[] tok) 
	   {
		  
		   this.empno = Integer.parseInt(tok[0]);
			this.ename = tok[1];
			this.sal = tok[2];
			this.hiredate = tok[3];
			this.image = tok[4];
		  
			 
	   }
	
	
	
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	   
	   
	   
	   
}




	/*
	 * public Euser(String[] tok) { SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); try { this.num =
	 * Integer.parseInt(tok[0]); this.title = tok[1]; this.author = tok[2];
	 * this.contents = tok[3]; this.regDate = sdf.parse(tok[4]); } catch
	 * (ParseException e) { e.printStackTrace(); } this.hits =
	 * Integer.parseInt(tok[5]); }
	 * 
	 * @Override public boolean equals(Object obj) { Board other = (Board)obj;
	 * return this.num==other.num; }
	 * 
	 * @Override public String toString() { SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String strDate =
	 * sdf.format(regDate); //날짜를 문자열로 문자를 날짜 오브젝트로 하는건 sdf.parse(strDate) return
	 * String.format("%d|%s|%s|%s|%s|%d", num,title,author,contents,strDate,hits);
	 * //이걸 쪼개려면\\ 역슬레시 두개 줘야한다. 즉 특수 문자는 이렇게 해야한다. line.split("\\|"); 즉 특수 문자 | 이걸
	 * 기준으로 쪼갤때 }
	 * 
	 */