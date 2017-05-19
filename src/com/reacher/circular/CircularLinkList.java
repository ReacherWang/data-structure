package com.reacher.circular;

public class CircularLinkList <T extends Comparable<T>> {
	
	private Node head;
	
	/*public void insert(T data) {
		Node node = new Node(data);
		if(null == this.head) {
			this.head = node;
			this.head.next = this.head;
		} else {
			Node tail = this.getTail();
			node.next = this.head;
			this.head = node;
			tail.next = this.head;
		}
	}*/
	
	public void insert(T data) {
		Node node = new Node(data);
		if(null == this.head) {
			this.head = node;
			this.head.next = this.head;
			return;
		}
		if(data.compareTo(this.head.data) < 0) {
			Node tail = this.getTail();
			node.next = this.head;
			this.head = node;
			tail.next = this.head;
			return;
		}
		Node p = this.head;
		while(this.head != p.next && data.compareTo(p.next.data) > 0) {
			p = p.next;
		}
		if(this.head == p.next) {
			node.next = this.head;
		} else {
			node.next = p.next;
		}
		p.next = node;
	}
	
	public void remove(T data) {
		if(null == this.head) {
			System.out.println("This list is empty!");
			return;
		}
		if(data.compareTo(this.head.data) == 0) {
			Node tail = this.getTail();
			this.head = this.head.next;
			tail.next = this.head;
			return;
		}
		Node p = this.head;
		while(p.next != this.head && data.compareTo(p.next.data) != 0) {
			p = p.next;
		}
		if(p.next == this.head) {
			System.out.println("当前要删除的节点在链表中不存在！");
		} else {
			p.next = p.next.next;
		}
	}
	
	public void print() {
		if(null == this.head) {
			System.out.println("This list is empty!");
		} else {
			System.out.print(this.head.data + "-->");
			Node p = this.head.next;
			while(null != p && p != this.head) {
				System.out.print(p.data + "-->");
				p = p.next;
			}
			if(p == this.head) {
				System.out.println("head");
			} else {
				System.out.println("null");
			}
		}
	}
	
	private Node getTail() {
		Node tail = this.head;
		while(this.head != tail.next) {
			tail = tail.next;
		}
		return tail;
	}
	
	private class Node {
		private T data;
		private Node next;
		
		public Node(T data) {
			this.data = data;
		}
	}
}
