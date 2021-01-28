package com.pat.java8.lambda;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class MinDemo {
    public static void main(String[] args) {
        int[] nums = {11,33,-99,53,91};

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println(min);
    }
}
