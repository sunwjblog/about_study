package com.sunwj.leetcode.easy.linkedlist;//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表
// 👍 510 👎 0



//Java：移除链表元素
public class P203RemoveLinkedListElements{
    public static void main(String[] args) {

        int[] num = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(num);
        System.out.println(head);
        Solution solution = new P203RemoveLinkedListElements().new Solution();
        // TO TEST
        solution.removeElements(head,6);
        System.out.println(head);
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {

            /*//未使用虚拟头节点 处理头节点
            while (head != null && head.val == val) {
                ListNode delNode = head;
                head = head.next;
                delNode.next = null;
            }

            if (head == null)
                return null;

            //删除中间的元素
            ListNode prev = head;
            while (prev.next != null) {

                if (prev.next.val == val){
                    ListNode delNode = prev.next;
                    prev.next = delNode.next;
                    delNode.next = null;
                }
                else {
                    prev = prev.next;
                }
            }
            return head;*/

            //虚拟头节点方式
            /*ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode prev = dummyHead;
            while (prev.next != null) {

                if (prev.next.val == val){
                    ListNode delNode = prev.next;
                    prev.next = delNode.next;
                    delNode.next = null;
                }
                else {
                    prev = prev.next;
                }
            }
            return dummyHead.next;*/

            //递归的方式实现
            //最小问题
            if (head == null)
                return null;

            //更小规模的问题
            ListNode res = removeElements(head.next,val);

            //如果头节点需要删除
            if (head.val == val){
                return res;
            }
            else {
                head.next = res;
                return head;
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}