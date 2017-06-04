package com.reacher.stack;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reacher on 17-6-4.
 */
public class MAStack {

    private static final int DEFAULT_SIZE = 20;

    private int []datas;
    private int top;

    public MAStack() {
        this(DEFAULT_SIZE);
    }

    public MAStack(int size) {
        this.datas = new int[size];
        this.top = 0;
    }

    public void push(int data) {
        if(this.top == this.datas.length) {
            System.out.println("This stack is full!");
        } else {
            this.datas[this.top++] = data;
        }
    }

    public Integer pop() {
        if(0 == this.top) {
            System.out.println("This stack is empty!");
            return null;
        }
        return this.datas[--this.top];
    }

    public Integer peek() {
        if(0 == this.top) {
            System.out.println("This stack is empty!");
            return null;
        }
        return this.datas[this.top - 1];
    }

    public boolean isEmpty() {
        return 0 == this.top;
    }

    @Override
    public String toString() {
        List<String> datas = new ArrayList<>();

        int length = this.top;
        while(0 < length) {
            datas.add(String.valueOf(this.datas[--length]));
        }
        return StringUtils.join(datas, ",");
    }
}
