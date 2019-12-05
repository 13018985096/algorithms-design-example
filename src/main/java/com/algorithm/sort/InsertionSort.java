package com.algorithm.sort;

/**
 * 插入排序 时间复杂度为O(n*n) 空间复杂度为O(1) 是稳定的排序算法
 *
 * @author tanjiang
 */
public class InsertionSort {

    public void insertionSort(int[] arr, int len) {
        if (len <= 1) {
            return;
        }
        //从数组第二个数据开始进行排序操作
        for (int i = 1; i < len; i++) {
            int value = arr[i];

            //j表示已排好序的末位置
            int j = i - 1;

            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    //数据移动
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            //插入数据
            arr[j + 1] = value;
        }
    }
}
