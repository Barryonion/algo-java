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


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = q;
        }
        return dummy.next;
    }

    public ListNode reverseListRecursion(ListNode head) {
        if (head == null) {
            return  null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public double myPow(double x, int n) {
        if (n >= 0) {
            return rPow(x, n);
        } else {
            return 1 / (rPow(x, -1 * (n + 1)) * x);
        }
    }

    private double rPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double halfPow = rPow(x, n / 2);
        if (n % 2 == 1) {
            return halfPow * halfPow * x;
        } else {
            return halfPow * halfPow;
        }
    }

    public int multiply(int A, int B) {
        // a个b相加
        if (A == 1) {
            return B;
        }
        int halfValue = multiply(A / 2, B);
        if (A % 2 == 1) {
            return halfValue + halfValue + B;
        } else {
            return halfValue + halfValue;
        }
    }

    public int multiply1(int A, int B) {
        int n = Math.min(A, B);
        int k = Math.max(A, B);
        if (n == 1) {
            return k;
        }
        int halfValue = multiply1(n / 2, k);
        if (n % 2 == 1) {
            return halfValue + halfValue + k;
        } else {
            return halfValue + halfValue;
        }
    }






}
