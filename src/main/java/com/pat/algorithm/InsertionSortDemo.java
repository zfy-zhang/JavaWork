package com.pat.algorithm;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/24
 * @Modify
 * @since
 */
public class InsertionSortDemo {

    public static void main(String[] args) {
        int[] arrays = {4,5,6,2,3,1};
        printResult(arrays);
        insertionSort(arrays, arrays.length);
        printResult(arrays);

    }


    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }

    public static void printResult(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
