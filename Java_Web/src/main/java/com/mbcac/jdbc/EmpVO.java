package com.mbcac.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmpVO {

	private int empno;
	private String ename;
	private int sal;
	private java.sql.Date hiredate;
	private int deptno;
	private String job;
	private int mgr;
	private float comm;
	
	public EmpVO() {
		
	}

	public EmpVO(int empno) {
		
		this.empno = empno;
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

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public java.sql.Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) // method Overroad
	   {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      try 
	      {
	         this.hiredate = new java.sql.Date(sdf.parse(hiredate).getTime());
	      } 
	      catch (ParseException e) {e.printStackTrace();}
	   }
	public void setHiredate(java.sql.Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public float getComm() {
		return comm;
	}

	public void setComm(float comm) {
		this.comm = comm;
	}


	

	
	
}
