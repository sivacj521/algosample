package com.alayam.core;

public class LinkList {
	int _data;
	LinkList next = null;	
	
	LinkList(int y){
		_data=y;
	}
	
	static void printList(LinkList head){
		LinkList cur = head;
		while(cur !=null){
			System.out.println("cur.data "+cur._data);
			cur  = cur.next;
		}
	}
	
	public static void main(String args[]){
			
		LinkList l1 = new LinkList(10);			
		LinkList l2= new LinkList(20);			
		LinkList l3 = new LinkList(30);
		
		//LinkList next = new LinkList(50); 
		
		
		l1.next = l2;
		l2.next = l3;
		
		printList(l1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _data;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkList other = (LinkList) obj;
		if (_data != other._data)
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		return true;
	}

}
