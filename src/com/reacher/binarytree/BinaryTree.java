package com.reacher.binarytree;

import java.util.Stack;

public class BinaryTree {
	
	private Node root;
	private int index;
	
	public BinaryTree(String source) {
		this.root = this.init(source);
	}
	
	public void out(boolean recursion, PatternEnum pattern) {
		
		switch(pattern) {
			case PERORDER: 
				if(recursion) {
					recursionPreorder(this.root);
				} else {
					preorder(this.root);
				}
				break;
			case INORDER: 
				if(recursion) {
					recursionInorder(this.root);
				} else {
					inorder(this.root);
				}
				break;
			case POSTORDER: 
				if(recursion) {
					recursionPostorder(this.root);
				} else {
					postorder(this.root);
				}
				break;
		}
	}
	
	private Node init(String source) {
		if(this.index >= source.length()) {
			return null;
		}
		char data = source.charAt(this.index++);
		if('#' == data) {
			return null;
		}
		Node node = new Node(data);
		node.lchild = init(source);
		node.rchild = init(source);
		return node;
	}
	
	private void recursionInorder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		while(null != node || !stack.isEmpty()) {
			while(null != node) {
				stack.push(node);
				node = node.lchild;
			}
			if(!stack.isEmpty()) {
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.rchild;
			}
		}
	}
	
	private void recursionPreorder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		while(null != node || !stack.isEmpty()) {
			while(null != node) {
				stack.push(node);
				System.out.print(node.data + " ");
				node = node.lchild;
			}
			if(!stack.isEmpty()) {
				node = stack.pop();
				node = node.rchild;
			}
		}
	}
	
	private void recursionPostorder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		Node pre = null;
		stack.push(node);
		while(!stack.isEmpty()) {
			node = stack.peek();
			if(validate(node, pre)) {
				pre = stack.pop();
				System.out.print(pre.data + " ");
			} else {
				if(null != node.rchild) {
					stack.push(node.rchild);
				}
				if(null != node.lchild) {
					stack.push(node.lchild);
				}
 			}
		}
	}
	
	private boolean validate(Node cur, Node pre) {
		if(null == cur.lchild && null == cur.rchild) {
			return true;
		}
		if(null != pre && (pre == cur.lchild || pre == cur.rchild)) {
			return true;
		}
		return false;
	}
	
	private void postorder(Node node) {
		if(null == node) {
			return;
		}
		postorder(node.lchild);
		postorder(node.rchild);
		System.out.print(node.data + " ");
	}
	
	private void inorder(Node node) {
		if(null == node) {
			return;
		}
		inorder(node.lchild);
		System.out.print(node.data + " ");
		inorder(node.rchild);
	}
	
	private void preorder(Node node) {
		if(null == node) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.lchild);
		preorder(node.rchild);
	}
	
	public void inThread() {
		inThread(this.root, null);
	}
	
	private void inThread(Node node, Node pre) {
		if(null == node) {
			return;
		}
		inThread(node.lchild, pre);
		if(null == node.lchild) {
			node.lchild = pre;
			node.ltag = true;
		}
		if(null != pre && null == pre.rchild) {
			pre.rchild = node;
			pre.rtag = true;
		}
		inThread(node.rchild, node);
	}
	
	private class Node  {
		private char data;
		private Node lchild;
		private Node rchild;
		private boolean ltag;
		private boolean rtag;
		
		public Node(char data) {
			this.data = data;
		}
	}
}
