package com.algorithm.sort;

/**
 * 快速排序 时间复杂度为O(n * logn)  空间复杂度为O(1) 非稳定排序算法
 *
 * @author tanjiang
 */
public class QuickSort {
    public static void quickSort(int[] a, int len) {
        quickSortC(a, 0, len - 1);
    }

    private static void quickSortC(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quickSortC(a, p, q - 1);
        quickSortC(a, q + 1, r);
    }

    /**
     * 分区操作
     *
     * @param a 数组
     * @param p 数组首下标
     * @param r 数组尾下标
     * @return
     */
    private static int partition(int[] a, int p, int r) {

        // 分区点
        int pivot = (r + p) >> 1;

        // i表示已经对比的下标 j表示需要对比的下标
        int i = p;
        for (int j = p; j < r; j++) {
            // 取下标为j的值与 pivot对比,若小于pivot的值,则将a[i] 与a[j]的值作替换
            if (a[j] < a[pivot]) {
                swap(a, i, j);
                i++;
            }
        }
        // 最后将分区点的值与当前下标i的值互换
        swap(a, i, pivot);
        return i;
    }

    /**
     * 数组下标为i的值与下标j互换
     *
     * @param arr 目标数组
     * @param i   数组下标
     * @param j   数组下标
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
