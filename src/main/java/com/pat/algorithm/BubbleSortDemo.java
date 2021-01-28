package com.pat.algorithm;

/**
 * @Description: 冒泡排序
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/24
 * @Modify
 * @since
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arrays = {4,5,6,2,3,1};
        printResult(arrays);
        bubbleSort(arrays, arrays.length);
        printResult(arrays);
    }


    // 冒泡排序，a表示数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    public static void printResult(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
