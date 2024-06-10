package com.mbcac.session;

import java.util.*;

public class Cart 
{
   private List<Item> list = new ArrayList<>();;
   
   public boolean add(Item item)
   {
      //item을 관리가 편리한 자료구조에 저장한다
      if(list.contains(item)) {
         Item itemIn = list.get(list.indexOf(item));
         itemIn.setQty(itemIn.getQty() + item.getQty());
         return true;
      }else {
         list.add(item);
         return true;
      }
   }
   
   public List<Item> getList(){
      return list;
   }
   
   public int getTotal() {
      int total = 0;
      for(int i=0;i<list.size();i++) {
         int subtotal = list.get(i).getPrice()* list.get(i).getQty();
         total += subtotal;
      }
      return total;
   }
}
