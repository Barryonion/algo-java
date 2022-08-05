package hashtable_18;

import java.util.HashSet;

//移除重复节点
//
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
//示例1:
//
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
//示例2:
//
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
//提示：
//
//链表长度在[0, 20000]范围内。
//链表元素在[0, 20000]范围内。
//进阶：
//
//如果不得使用临时缓冲区，该怎么解决？
//
//链接：https://leetcode.cn/problems/remove-duplicate-node-lcci
//

public class RemoveDuplicateNodes {
    public static class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }
    }
    //TDD
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        HashSet<Integer> set = new HashSet<>();
        ListNode p = head;
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        while (p != null) {
            if (set.contains(p.val)) {
                p = p.next;
                continue;
            }
            set.add(p.val);
            ListNode tmpNext = p.next;
            tail.next = p;
            p.next = null;
            tail = tail.next;
            p = tmpNext;
        }
        return newHead.next;
    }

    //时间O(n^2) 空间O(1)
    public ListNode removeDuplicateNodesNoCache(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            while (temp.next != null) {
                if (temp.next.val == cur.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }


    //zheng's solution
    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) return null;
        HashSet<Object> set = new HashSet<>();
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            if (!set.contains(p.val)) {
                set.add(p.val);
                tail.next = p;
                tail = p;
                tail.next = null;
            }
            p = tmp;
        }
        return newHead.next;
    }




















}


