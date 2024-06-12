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

   public boolean itemChange(Item key) {
      if(list.contains(key)) {
         list.get(list.indexOf(key)).setQty(key.getQty());
         return true;
      }
      return false;
   }

   public boolean delItem(Item key) {
	   if(list.contains(key)) {
	         list.remove(key);
	         return true;
	      }
	
	   return false;
   }

public boolean delBatch(List<Item> delList) {
	int deleted = 0;
	for(int i=0;i<delList.size();i++) {
		Item item = delList.get(i);
		if(list.contains(item)) {
			list.remove(item);
			deleted++;
		}
	}
		//5개를 삭제해 달라고 했으니 해당 갯수 만큼 삭제되야지 성공한거니 삭제된 개수와 리스트 개수가 같은지를 확인하여 트루 폴스 해야 맞다.
	return deleted==delList.size();
}
   
   
}
