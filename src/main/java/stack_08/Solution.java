package stack_08;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);

        listNode1.next = listNode3;
        listNode3.next = listNode2;
        ListNode head = listNode1;
        int[] result = reversePrint(head);

    }

    public static int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ListNode p = head;
        while(p!=null){
            stack.push(p.val);
            p = p.next;
        }
        int[] result = new int[stack.size()];
        int size = stack.size();
        for(int i=0; i<size; i++){
            result[i]= stack.pop();
        }
        return result;
    }

    List<Integer> result = new ArrayList<>();

    public int[] reversePrintRecursion(ListNode head) {
        reverseTravel(head);
        int[] resultArr = new int[result.size()];
        int i = 0;
        for (Integer k : result) {
            resultArr[i++] = k;
        }
        return resultArr;
    }

    private void reverseTravel(ListNode head) {
        if(head == null) {
            return;
        }
        reverseTravel(head.next);
        result.add(head.val);
    }


}
