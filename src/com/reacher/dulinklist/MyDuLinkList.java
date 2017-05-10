package com.reacher.dulinklist;

public class MyDuLinkList {
	
	private Node head;
	
	/*public void insert(int data) {
		Node node = new Node(data);
		if(null != this.head) {
			node.next = this.head;
			this.head.pre = node;
		}
		this.head = node;
	}*/
	
	/*public void insert(int data) {
		Node node = new Node(data);
		if(null == this.head) {
			this.head = node;
		} else {
			Node p = this.head;
			while(null != p.next) {
				p = p.next;
			}
			p.next = node;
			node.pre = p;
		}
	}*/
	
	public void insert(int data) {
		Node node = new Node(data);
		if(null == this.head) {
			this.head = node;
			return;
		}
		if(node.data < this.head.data) {
			node.next = this.head;
			this.head.pre = node;
			this.head = node;
			return;
		}
		Node p = this.head;
		while(null != p.next && p.next.data < node.data) {
			p = p.next;
		}
		if(null != p.next) {
			node.next = p.next;
			node.next.pre = node;
		}
		p.next = node;
		node.pre = p;
	}
	
	public void remove(int data) {
		if(null == this.head) {
			System.out.println("当前链表为空");
			return;
		}
		if(data == this.head.data) {
			this.head = this.head.next;
			this.head.pre = null;
			return;
		}
		Node p = this.head;
		while(null != p.next && data != p.next.data) {
			p = p.next;
		}
		if(null == p.next) {
			System.out.println("要删除的节点在链表中不存在");
			return;
		}
		if(null != p.next.next) {//判断删除的是否是尾节点
			p.next.next.pre = p;
		}
		p.next = p.next.next;
	}
	
	public void print() {
		Node p = this.head;
		while(null != p) {
			System.out.print(p.data + "-->");
			p = p.next;
		}
		System.out.println("NULL");
	}
	
	private class Node {
		private int data;
		private Node next;
		private Node pre;
		
		public Node(int data) {
			this.data = data;
		}
	}

}
