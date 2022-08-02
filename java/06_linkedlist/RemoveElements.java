//移除链表元素
//
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]

//示例 2：
//输入：head = [], val = 1
//输出：[]

//示例 3：
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//提示：
//
//列表中的节点数目在范围 [0, 104] 内
//1 <= Node.val <= 50
//0 <= val <= 50
//
//链接：https://leetcode.cn/problems/remove-linked-list-elements
public class RemoveElements {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        RemoveElements solution = new RemoveElements();
        ListNode node7 = new ListNode(6, null);
        ListNode node6 = new ListNode(5,node7);
        ListNode node5 = new ListNode(4,node6);
        ListNode node4 = new ListNode(3,node5);
        ListNode node3 = new ListNode(6,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1, node2);
        ListNode newLinked = solution.removeElements1(head, 6);
        while (newLinked != null) {
            System.out.println(newLinked.val);
            newLinked = newLinked.next;
        }
    }

    //zheng wang's solution
    public ListNode removeElements(ListNode head, int val) {
        //特判
        if (head == null) return null;
        //prev指向待删除节点的前驱节点
        ListNode prev = head;
        while (prev.next != null) {//当prev指向尾节点时退出循环
            if (prev.next.val == val) {
                prev.next = prev.next.next;//删除prev的下一个节点
            } else {
                prev = prev.next;//prev继续向前
            }
        }
        //处理头节点包含目标值的特殊情况
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        //引入虚拟头节点，消除需要特判的逻辑
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }


}

















































