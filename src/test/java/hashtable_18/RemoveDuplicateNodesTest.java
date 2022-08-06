package hashtable_18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@Tag("fast")
public class RemoveDuplicateNodesTest {
    @Test()
    @DisplayName("remove duplicate nodes")
    void removeDuplicateNodes(TestInfo testInfo) {
        RemoveDuplicateNodes solution = new RemoveDuplicateNodes();
        RemoveDuplicateNodes.ListNode listNode1 = new RemoveDuplicateNodes.ListNode(1);
        RemoveDuplicateNodes.ListNode listNode2 = new RemoveDuplicateNodes.ListNode(1);
        RemoveDuplicateNodes.ListNode listNode3 = new RemoveDuplicateNodes.ListNode(1);
        RemoveDuplicateNodes.ListNode listNode33 = new RemoveDuplicateNodes.ListNode(3);
        RemoveDuplicateNodes.ListNode listNode22 = new RemoveDuplicateNodes.ListNode(2);
        RemoveDuplicateNodes.ListNode listNode11 = new RemoveDuplicateNodes.ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode33;
        listNode33.next = listNode22;
        listNode22.next = listNode11;
        RemoveDuplicateNodes.ListNode removedListHead = solution.removeDuplicateNodesNoCache(listNode1);
        RemoveDuplicateNodes.ListNode p = removedListHead;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
