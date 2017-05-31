package com.reacher.skiplist;

import java.util.Random;

/**
 * Created by reacher on 17-5-28.
 */
public class SkipList {

    private Node []heads;
    private Random random;
    private int maxLevel;

    public SkipList(int level) {
        this.heads = new Node[level];
        for(int i = 0; i < level; ++i) {
            this.heads[i] = new Node(Integer.MIN_VALUE);
        }
        this.maxLevel = level;
        this.random = new Random(System.currentTimeMillis());
    }

    public void insert(int data) {
        int level = this.random.nextInt(this.maxLevel) + 1;

        Node down = null;

        for(int i = 0; i < level; ++i) {
            Node node = new Node(data);

            Node location = this.findLocation(this.heads[i], data);

            node.next = location.next;
            location.next = node;

            node.down = down;
            down = node;
        }
    }

    public int find(int data) {

        int level = this.maxLevel - 1;

        Node head = this.heads[level];
        while(level >= 0) {
            Node node = this.findLocation(head, data);
            if(node == this.heads[level]) {
                head = this.heads[--level];
                continue;
            }
            if(data == node.data) {
                return level;
            }
            --level;
            head = node.down;
        }
        return -1;
    }

    public void print() {
        for(int i = this.maxLevel - 1; i >= 0; --i) {
            this.printList(this.heads[i], i);
        }
    }

    private void printList(Node head, int i) {
        System.out.print("Head[" + (i + 1) + "]-->");

        head = head.next;
        while(null != head) {
            System.out.print(head.data + "-->");
            head = head.next;
        }
        System.out.println("^");
    }

    private Node findLocation(Node head, int data) {
        while(null != head.next && data >= head.next.data) {
            head = head.next;
        }
        return head;
    }

    private class Node {
        private int data;
        private Node next;
        private Node down;

        public Node(int data) {
            this.data = data;
        }
    }
}
