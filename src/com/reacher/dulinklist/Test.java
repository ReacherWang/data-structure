package com.reacher.dulinklist;

public class Test {
	
	public static void main(String[] args) {
		MyDuLinkList link = new MyDuLinkList();
		
		link.insert(3);
		link.insert(9);
		link.insert(1);
		link.insert(5);
		link.insert(8);
		link.insert(4);
		
		link.print();
	}

}
