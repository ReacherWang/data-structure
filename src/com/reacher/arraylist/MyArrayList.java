package com.reacher.arraylist;

public class MyArrayList {
	
	private int[] datas;
	private int size;
	
	public MyArrayList(int length) {
		this.datas = new int[length];
		this.size = 0;
	}
	
	/*public void insert(int data) {
		if(this.size == this.datas.length) {
			System.out.println("存储单元已满!");
			return;
		}
		this.datas[this.size++] = data;
	}*/
	
	public void insert(int data) {
		if(this.size == this.datas.length) {
			System.out.println("存储单元已满!");
			return;
		}
		int location = this.size;
		for(int i = 0; i < this.size; ++i) {
			if(this.datas[i] > data) {
				location = i;
				break;
			}
		}
		for(int i = this.size; i > location; --i) {
			this.datas[i] = this.datas[i - 1];
		}
		this.datas[location] = data;
		++this.size;
	}
	
	public void remove(int data) {
		if(0 == this.size) {
			System.out.println("存储单元为空!");
			return;
		}
		int location = -1;
		for(int i = 0; i < this.size; ++i) {
			if(this.datas[i] == data) {
				location = i;
				break;
			}
		}
		if(-1 == location) {
			System.out.println("要删除的数据在存储单元中不存在!");
			return;
		}
		for(int i = location; i < this.size - 1; ++i) {
			this.datas[i] = this.datas[i + 1];
		}
		--this.size;
	}
	
	public void print() {
		for(int i = 0; i < this.size; ++i) {
			System.out.print(this.datas[i] + " ");
		}
		System.out.println();
	}

}
