package com.algorithm.sort;

/**
 * 冒泡排序 时间复杂度为O(n*n) 空间复杂度为O(1) 是稳定的排序算法
 *
 * 1,4,3,2,8,3,6  经过排序之后，前面3的位置仍然在后面3的前面 1,2,3,3,4,6,8
 *
 * @author tanjiang
 */
public class BubbleSort {

    /**
     * @param arr 待排序数组
     * @param len 数组长度
     */
    public void bubbleSort(int[] arr, int len) {
        if (len <= 1) {
            return;
        }
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            //一轮冒泡结束,flag还为false,说明后面数据已经是有序的了,提前跳出循环
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 交换i j 位置的值
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
