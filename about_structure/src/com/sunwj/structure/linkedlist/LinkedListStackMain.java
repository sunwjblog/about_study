package com.sunwj.structure.linkedlist;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/10 7:48 下午
 */
public class LinkedListStackMain {

    public static void main(String[] args) {
        LinkedListStatck<Integer> stack = new LinkedListStatck<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
