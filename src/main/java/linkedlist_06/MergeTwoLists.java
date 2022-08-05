package linkedlist_06;

//合并两个排序的链表
//
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
//示例1：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//限制：
//
//0 <= 链表长度 <= 1000
//
//
//链接：https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
//
//
public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        l1.next = node2;
        node2.next = node3;

        ListNode l2 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node33 = new ListNode(4);
        l2.next = node22;
        node22.next = node33;
        MergeTwoLists solution = new MergeTwoLists();
        ListNode merge = solution.mergeTwoLists(l1, l2);
        while (merge != null) {
            if (merge.next != null) {
                System.out.print(merge.val + "-->");
            } else {
                System.out.print(merge.val);
            }
            merge = merge.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //思路：新建一个头节点，对比l1、l2大小，将更小的值插入链表尾部
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1==null) tail.next = l2;
        if (l2==null) tail.next = l1;
        return dummyHead.next;
    }
}
