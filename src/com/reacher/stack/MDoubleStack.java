package com.reacher.stack;

/**
 * Created by reacher on 17-6-4.
 */
public class MDoubleStack {

    private static final int DEFAULT_SIZE = 20;

    private int []datas;
    private int top1;
    private int top2;

    public MDoubleStack() {
        this(DEFAULT_SIZE);
    }

    public MDoubleStack(int size) {
        this.datas = new int[size];
        this.top1 = -1;
        this.top2 = size;
    }

    public void push(int number, int data) {
        if(this.top1 + 1 == this.top2) {
            System.out.println("This stack is full!");
            return;
        }
        if(1 == number) {
            this.datas[++this.top1] =  data;
        } else {
            this.datas[--this.top2] = data;
        }
    }

    public Integer pop(int number) {
        if(1 == number) {
            if(-1 == this.top1) {
                System.out.println("This stack is empty!");
                return null;
            }
            return this.datas[this.top1--];
        } else {
            if(this.datas.length == this.top2) {
                System.out.println("This stack is empty!");
                return null;
            }
            return this.datas[this.top2++];
        }
    }

    public Integer peek(int number) {
        if(1 == number) {
            if(-1 == this.top1) {
                System.out.println("This stack is empty!");
                return null;
            }
            return this.datas[this.top1];
        } else {
            if(this.datas.length == this.top2) {
                System.out.println("This stack is empty!");
                return null;
            }
            return this.datas[this.top2];
        }
    }

    public boolean isEmpty(int number) {
        return 1 == number ? -1 == this.top1 : this.datas.length == this.top2;
    }
}
