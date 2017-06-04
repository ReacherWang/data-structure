package com.reacher.stack;

/**
 * Created by reacher on 17-6-4.
 */
public class MLStack<T> {

    private Node top;

    public void push(T data) {
        Node node = new Node(data);
        if(null != this.top) {
            node.next = this.top;
        }
        this.top = node;
    }

    public T pop() {
        if(null == this.top) {
            System.out.println("This stack is empty!");
            return null;
        }

        T data = this.top.data;
        this.top = this.top.next;

        return data;
    }

    public T peek() {
        if(null == this.top) {
            System.out.println("This stack is empty!");
            return null;
        }
        return this.top.data;
    }

    public boolean isEmpty() {
        return null == this.top;
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

}
