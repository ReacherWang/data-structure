package com.reacher.binarysorttree;

public class BinarySortTree {
	
	private Node root;
	
	public void insert(int data) {
		this.root = this.insert(this.root, data);
	}
	
	public Node insert(Node root, int data) {
		if(null == root) {
			return new Node(data);
		}
		if(root.data == data) {
			System.out.println("不允许添加相同的节点");
			return null;
		}
		if(data < root.data) {
			root.left = this.insert(root.left, data);
		} else {
			root.right = this.insert(root.right, data);
		}
		return root;
	}
	
	private void inOrder(Node root) {
		if(null == root) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + "-->");
		inOrder(root.right);
	}
	
	public Node search(int data) {
        return search(root, data);
    }
	
	private Node search(Node root, int data) {
		if(null == root) {
			return null;
		}
		if(data == root.data) {
			return root;
		}
		return data < root.data ? this.search(root.left, data) : this.search(root.right, data);
	}
	
	public void remove(int data) {
		Node node = this.search(data);
		if(null != node) {
			this.root = this.remove(this.root, node);
		}
	}
	
	private Node remove(Node root, Node node) {
		if(null == root || null == node) {
			return null;
		}
		if(node.data < root.data) {
			root.left = this.remove(root.left, node);
		} else if(node.data > root.data) {
			root.right = this.remove(root.right, node);
		} else {
			if(null != root.left && null != root.right) {
				node = node.right;
				while(null != node.left) {
					node = node.left;
				}
				root.data = node.data;
				root.right = this.remove(root.right, node);
			} else {
				root = null != root.left ? root.left : root.right;
			}
		}
		return root;
	}
	
	public void print() {
		if(null == this.root) {
			System.out.println("空树");
			return;
		}
		this.inOrder(this.root);
		System.out.println();
	}
	
	private class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}

}
