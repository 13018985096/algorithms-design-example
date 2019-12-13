package com.structures.linear.array;

import com.algorithm.sort.InsertionSort;

import java.util.Random;


/**
 * 有序数组
 */
public class SortedArray {
    private int[] objects;
    private int size;

    public SortedArray() {
        objects = new int[10];
    }

    public boolean add(int value) {
        if ((size + 1) > objects.length) {
            throw new RuntimeException("数组大小达到上限");
        }
        objects[size++] = value;

        //j表示已排好序的末位置
        int j = size - 2;
        for (; j >= 0; j--) {
            if (objects[j] > value) {
                //数据移动
                objects[j + 1] = objects[j];
            } else {
                break;
            }
        }
        //插入数据
        objects[j + 1] = value;

        return true;
    }


    public static void main(String[] args) {
        SortedArray sortedArray = new SortedArray();
        for (int i = 10; i > 0; i--) {
            sortedArray.add(i);
        }
        System.out.println("end");
    }
}
