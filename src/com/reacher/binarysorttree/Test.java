package com.reacher.binarysorttree;

public class Test {
	
	public static void main(String[] args) {
		BinarySortTree tree = new BinarySortTree();
		
		tree.insert(5);
		/*tree.insert(7);
		tree.insert(9);
		tree.insert(2);
		tree.insert(1);
		tree.insert(4);
		tree.insert(3);
		tree.insert(8);
		tree.insert(6);*/
		
		System.out.println("=====================");
		tree.print();
		
		if(null != tree.search(9)) {
			System.out.println("存在");
		} else {
			System.out.println("不存在");
		}
		
		tree.delete(5);
		tree.print();
	}

}
