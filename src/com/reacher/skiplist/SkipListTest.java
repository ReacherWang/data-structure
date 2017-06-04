package com.reacher.skiplist;

/**
 * Created by reacher on 17-5-28.
 */
public class SkipListTest {

    private static final int []datas = {
        3, 2, 1, 4, 5, 6, 7, 9, 8
    };

    public static void main(String[] args) {
        SkipList skipList = new SkipList(5);

        for (int i = 0; i < datas.length; ++i) {
            skipList.insert(datas[i]);
        }

        skipList.print();

        int result = skipList.find(6);
        if(-1 == result) {
            System.out.println("不存在");
        } else {
            System.out.println(String.format("在第%d层", result + 1));
        }

    }

}
