package com.reacher.stack;

/**
 * Created by reacher on 17-6-4.
 */
public class MLStackTest {

    public static void main(String[] args) {
        MLStack<String> stack = new MLStack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.peek());

        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

}
