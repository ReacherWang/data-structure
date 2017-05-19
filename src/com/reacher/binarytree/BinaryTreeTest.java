package com.reacher.binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		String source = "ABD###C#EF###";
		
		BinaryTree tree = new BinaryTree(source);
		tree.out(false, PatternEnum.POSTORDER);
		System.out.println();
		tree.out(true, PatternEnum.POSTORDER);
		System.out.println();
		
		tree.inThread();
	}
	
}
