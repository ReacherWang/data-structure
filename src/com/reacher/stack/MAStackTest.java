package com.reacher.stack;

/**
 * Created by reacher on 17-6-4.
 */
public class MAStackTest {

    public static void main(String[] args) {
        MAStack stack = new MAStack(5);

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(0);

        System.out.println(stack.toString());

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

}
