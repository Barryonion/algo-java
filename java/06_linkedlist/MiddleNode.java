//链表的中间结点
//
//给定一个头结点为 head 的非空单链表，返回链表的中间结点。
//
//如果有两个中间结点，则返回第二个中间结点。
//
//示例 1：
//
//输入：[1,2,3,4,5]
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
//示例 2：
//
//输入：[1,2,3,4,5,6]
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
//
//
//提示：
//
//给定链表的结点数介于 1 和 100 之间。
//
//链接：https://leetcode.cn/problems/middle-of-the-linked-list
public class MiddleNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        MiddleNode solution = new MiddleNode();
//        MiddleNode.ListNode node7 = new MiddleNode.ListNode(6, null);
        MiddleNode.ListNode node6 = new MiddleNode.ListNode(5,null);
        MiddleNode.ListNode node5 = new MiddleNode.ListNode(4,node6);
        MiddleNode.ListNode node4 = new MiddleNode.ListNode(3,node5);
        MiddleNode.ListNode node3 = new MiddleNode.ListNode(6,node4);
        MiddleNode.ListNode node2 = new MiddleNode.ListNode(2,node3);
        MiddleNode.ListNode head = new MiddleNode.ListNode(1, node2);
        MiddleNode.ListNode middleNode = solution.middleNode(head);
        while (middleNode != null) {
            System.out.println(middleNode.val);
            middleNode = middleNode.next;
        }
    }

    //快慢指针
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (p!=null&&p.next!=null) {
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

}
