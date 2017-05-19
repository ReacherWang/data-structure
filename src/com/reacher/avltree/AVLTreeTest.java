package com.reacher.avltree;

public class AVLTreeTest {
    private static int datas[]= {3, 2, 1, 4, 5, 6, 7, 10, 9, 8};

    public static void main(String[] args) {
        int i;
        AVLTree<Integer> tree = new AVLTree<Integer>();
        for(i=0; i<datas.length; i++) {
            tree.insert(datas[i]);
        }
        System.out.printf("\n 中序遍历: ");
        tree.inOrder();
        System.out.println();
    }
}