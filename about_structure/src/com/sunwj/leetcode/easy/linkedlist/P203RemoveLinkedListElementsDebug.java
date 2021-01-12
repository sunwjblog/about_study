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
public class P203RemoveLinkedListElementsDebug {
    public static void main(String[] args) {

        int[] num = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(num);
        System.out.println(head);
        Solution solution = new P203RemoveLinkedListElementsDebug().new Solution();
        // TO TEST
        solution.removeElements(head,6,0);
        System.out.println(head);
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val, int depth) {

            String depthString = generdateDepthString(depth);
            System.out.print(depthString);
            System.out.println("Call: remove " +val+ " in " + head);
            if (head == null){
                System.out.print(depthString);
                System.out.println("Return: " + head);
                return null;
            }
            ListNode result = removeElements(head.next,val, depth + 1);
            System.out.print(depthString);
            System.out.println("After remove " +val+ " : " +result);

            ListNode ret;
            if (head.val == val)
                ret = result;
            else {
                head.next = result;
                ret = head;
            }
            System.out.print(depthString);
            System.out.println("Return: " + ret);
            return ret;

        }

        private String generdateDepthString(int depth) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                res.append("--");
            }
            return res.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}