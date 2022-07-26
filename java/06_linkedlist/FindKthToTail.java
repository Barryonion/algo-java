//一个单链表，返回倒数第K个节点

public class FindKthToTail {
    public ListNode kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        //第一个指针先走k步，考虑k大于链表长度的情况
        while (k-- > 0 && fast != null) {
            fast = fast.next;
        }
        if (fast == null) {
            return null;
        }
        //然后两个指针在同时前进
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
