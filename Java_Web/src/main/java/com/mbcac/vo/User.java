package com.mbcac.vo;

public class User 
{
   private int no;
   private String id;
   private String pwd;
   private String phone;
   private String email;
   
   public User() {}
   
   public User(String id, String pwd) {
      this.id = id;
      this.pwd = pwd;
   }
   
   


   
   public User(int no, String id, String pwd, String phone, String email) {
      
   //this.no = Integer.parseInt(no); //내 버전 때문에 한거
   this.no = no;
   this.id = id;
   this.pwd = pwd;
   this.phone = phone;
   this.email = email;
}

public User(int no) {
         this.no = no;

      }
   
   @Override
   public boolean equals(Object obj) {
      User other = (User)obj;
      return this.id.equals(other.id) &&
            this.pwd.equals(other.pwd);//&&
            //this.no==(other.no) ;
   }

   public void printEmp() {
         String line = String.format("%d %s %s %s %s", no, id, pwd, phone, email);
         System.out.print(line);
   }

   
   
   
   
   public String getId() {
      return id;
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPwd() {
      return pwd;
   }

   public void setPwd(String pwd) {
      this.pwd = pwd;
   }
}