package com.reacher.binarysorttree;

public class BinarySortTree {
	
	private Node root;
	
	public void insert(int data) {
		Node node = new Node(data);
		if(null == this.root) {
			this.root = node;
		} else {
			this.insert(this.root, node);
		}
	}
	
	public void insert(Node root, Node node) {
		if(root.data == node.data) {
			System.out.println("不允许添加相同的节点");
			return;
		}
		if(root.data > node.data) {
			if(null == root.left) {
				node.parent = root;
				root.left = node;
			} else {
				this.insert(root.left, node);
			}
		} else {
			if(null == root.right) {
				node.parent = root;
				root.right = node;
			} else {
				this.insert(root.right, node);
			}
		}
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
	
	public boolean delete(int data) {
		Node node = this.search(this.root, data);
		if(null == node) {
			System.out.println("需要删除的节点不存在");
			return false;
		}
		if(null == node.left) {
			if(node == this.root) {
				this.root = node.right;
			} else {
				node.parent.left = node.right;
			}
			return true;
		}
		if(null == node.right) {
			if(node == this.root) {
				this.root = node.left;
			} else {
				node.parent.right = node.left;
			}
			return true;
		}
		Node p = node.right;
		while(null != p.left) {
			p = p.left;
		}
		node.data = p.data;
		p.parent.left = p.right;
		return true;
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
		private Node parent;
		
		public Node(int data) {
			this.data = data;
		}
	}

}
