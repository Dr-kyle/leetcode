package com.kyle.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 解题思路：遍历链表的记录头结点， 带 a.b  判断a 非空
 *
 */
public class Two {
    public static void main(String[] args) {
        Two two = new Two();
        ListNode l1 = new ListNode(1);
        ListNode result = two.addTwoNumbers(l1, null);
        ListNode cur = result;
        while (null != cur) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        // 进位
        int next = 0;
        int sum;
        int l1Val;
        int l2Val;
        ListNode result = new ListNode(0);
        // result的第一个值不返回，返回的是result.next;
        ListNode curResult = result;
        while (null != l1 || null != l2) {
            l1Val = l1 == null ? 0 : l1.val;
            l2Val = l2 == null ? 0 : l2.val;
            sum = l1Val + l2Val + next;
            next = 0;
            if (sum > 9) {
                next = 1;
                sum = sum - 10;
            }
            curResult.next = new ListNode(sum);
            curResult = curResult.next;
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        if (next == 1) {
            curResult.next = new ListNode(next);
        }
        return  result.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
