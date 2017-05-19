package com.reacher.circularlinklist;

public class CircularLinkListTest {
	
	public static void main(String[] args) {
		CircularLinkList<String> list = new CircularLinkList<String>();
		
		/*list.insert(1);
		list.insert(2);
		list.insert(6);
		list.insert(4);
		list.insert(5);*/
		
		list.insert("b");
		list.insert("d");
		list.insert("a");
		list.insert("e");
		list.insert("c");
		
		list.print();
		
		list.remove("f");
		
		list.print();
	}

}
