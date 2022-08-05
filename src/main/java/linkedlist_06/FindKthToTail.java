package linkedlist_06;//一个单链表，返回倒数第K个节点

public class FindKthToTail {
    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(7);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        FindKthToTail findKthToTail = new FindKthToTail();
        ListNode listNode = findKthToTail.kthToLast(listNode0, 1);
        System.out.println("the K's Countdown node is :" + listNode.val);
    }
    public ListNode kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        //第一个指针先走k步，考虑k大于链表长度的情况
        while (k > 0 && fast != null) {
            k--;
            fast = fast.next;
        }
        //特判，刚好是倒数第k个节点（k是链表长度，即定位到第一个节点）
        if (fast == null && k == 0) {
            return slow;
        }
        //然后两个指针在同时前进
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
