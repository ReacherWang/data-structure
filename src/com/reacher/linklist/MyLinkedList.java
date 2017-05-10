package com.reacher.linklist;

public class MyLinkedList {
	
	private Node head;
	private Node tail;
	
	public void headInsert(int data) {
		Node node = new Node(data);
		if(null == this.head) {
			this.head = node;
		} else {
			node.next = this.head;
			this.head = node;
		}
	}
	
	public MyLinkedList() {
		this.head = null;
	}
	
	public MyLinkedList(Node head) {
		this.head = head;
	}
	
	/*public void insert(int data) {
		Node node = new Node(data);
		if(null == this.head) {
			this.head = node;
		} else {
			Node tail = this.head;
			while(null != tail.next) {
				tail = tail.next;
			}
			tail.next = node;
		}
	}*/
	
	public void tailInsert(int data) {
		Node node = new Node(data);
		if(null == this.head) {
			this.head = node;
		} else {
			this.tail.next = node;
		}
		this.tail = node;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public void midInsert(int data) {
		Node node = new Node(data);
		if(null == this.head) {
			this.head = node;
			return;
		}
		if(data <= this.head.data) {
			node.next = this.head;
			this.head = node;
			return;
		}
		Node p = this.head;
		while(null != p.next && p.next.data < data) {
			p = p.next;
		}
		node.next = p.next;
		p.next = node;
	}
	
	public void remove(int data) {
		if(null == this.head) {
			System.out.println("当前链表为空!");
			return;
		}
		if(data == this.head.data) {
			this.head = this.head.next;
			return;
		}
		Node p = this.head;
		while(null != p.next && data != p.next.data) {
			p = p.next;
		}
		if(null != p.next) {
			if(null == p.next.next) {
				this.tail = p;
			}
			p.next = p.next.next;
		}
	}
	
	public void print() {
		Node p = this.head;
		while(null != p) {
			System.out.print(p.data + "->");
			p = p.next;
		}
		System.out.println("NULL");
	}
	
	public void reversed() {//将链表逆序
		Node newHead = null;
		Node p = this.head;
		
		while(null != p) {
			this.head = this.head.next;
			p.next = newHead;
			newHead = p;
			p = this.head;
		}
		this.head = newHead;
	}
	
	public void creatLoopLink(Integer ...datas) {//创建一个环形链表
		if(null == datas || 0 == datas.length) {
			return;
		}
		for(Integer data: datas) {
			this.tailInsert(data);
		}
		this.tail.next = this.head;
	}

	public boolean hasLoop() {//判断链表是否有环
		Node slow = this.head;
		Node fast = this.head;
		
		while(null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}

	public class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		public int getData() {
			return this.data;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
}
