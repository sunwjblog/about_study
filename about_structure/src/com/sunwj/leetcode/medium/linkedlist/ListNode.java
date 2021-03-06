package com.sunwj.leetcode.medium.linkedlist;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/10 9:18 下午
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode(int[] arr) {

        if (arr == null || arr.length ==0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
