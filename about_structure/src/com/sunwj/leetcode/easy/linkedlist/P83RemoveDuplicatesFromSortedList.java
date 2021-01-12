package com.sunwj.leetcode.easy.linkedlist;//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表
// 👍 447 👎 0



//Java：删除排序链表中的重复元素
public class P83RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        // TO TEST
        int[] test = new int[]{1,1,2};
        ListNode listNode = new ListNode(test);
        System.out.println(solution.deleteDuplicates(listNode));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            //最小问题
            if (head == null || head.next == null)
                return head;

            head.next = deleteDuplicates(head.next);

            return head.val == head.next.val ? head.next : head;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}