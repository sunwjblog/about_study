package com.sunwj.leetcode.easy.linkedlist;//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 链表
// 👍 83 👎 0


import java.util.ArrayList;

//Java：从尾到头打印链表
public class P剑指Offer06CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指Offer06CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        // TO TEST
            int[] arr = new int[]{1,2,3,4};
            ListNode listNode = new ListNode(arr);
            System.out.println(solution.reversePrint(listNode));
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        System.out.println("Call recur :" + head);
        if(head == null) {
            System.out.println("Return: " + head);
            return;
        }
        recur(head.next);
        tmp.add(head.val);
        System.out.println(tmp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}