package com.reacher.linklist;

public class Test {
	
	public static void main(String[] args) {
		MyLinkedList loop = new MyLinkedList();
		
		loop.creatLoopLink(1, 2, 3, 4, 5);
		
		if(loop.hasLoop()) {
			System.out.println("Is a loop link list");
		} else {
			System.out.println("Not a loop link list");
		}
	}

}
