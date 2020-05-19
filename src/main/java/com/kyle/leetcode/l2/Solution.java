package com.kyle.leetcode.l2;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
/* * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 第一个节点可以不返回，直接返回result.next 即可
        ListNode result = new ListNode(0);
        ListNode data = result;
        int pre = 0;
        int val;
        while (true) {
            if (l1 == null) {
                if (l2 == null) {
                    break;
                } else {
                    val = l2.val + pre;
                }
            } else {
                if (l2 == null) {
                    val = l1.val + pre;
                } else {
                    val = l1.val + l2.val + pre;
                }
            }
            if (val > 9) {
                pre = 1;
                val = val - 10;
            } else {
                pre = 0;
            }
            data.next = new ListNode(val);
            data = data.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if (pre != 0) {
            data.next = new ListNode(pre);
        }
        return result.next;
    }
    public static void main(String[] args) {
        ListNode l1;
        l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2;
        l2 = new ListNode(8);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(6);
        new Solution().addTwoNumbers(l1, l2);
    }

}

//leetcode submit region end(Prohibit modification and deletion)
