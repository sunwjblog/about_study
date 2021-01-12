package com.sunwj.leetcode.easy.linkedlist;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/10 9:28 下午
 */
public class Sum {

    public static int sum(int[] arr){
        return sum(arr,0);
    }
    public static int sum(int[] arr,int l) {
        if (l == arr.length)
            return 0; //求解最基本问题
        return arr[l] + sum(arr,l + 1); //把愿问题的转换成更小的问题
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println(sum(arr));
    }
}
