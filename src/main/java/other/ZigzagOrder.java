package other;
//二叉树的锯齿形层序遍历

import java.util.*;

public class ZigzagOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        ZigzagOrder solution1 = new ZigzagOrder();
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode root = new TreeNode(3,node9,node20);
        List<List<Integer>> lists = solution1.zigZagTraversal(root);
        System.out.println(lists.toString());

    }

    public List<List<Integer>> zigZagTraversal(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int odd = 1;
        while (!deque.isEmpty()) {
            ArrayList<Integer> levelList = new ArrayList<>();
            int levelCount = deque.size();
            if (odd % 2 == 1) {//奇数层
                for (int i = 0; i < levelCount; i++) {
                    TreeNode first = deque.pollFirst();
                    levelList.add(first.val);
                    if (null != first.left) {
                        deque.addLast(first.left);
                    }
                    if (null != first.right) {
                        deque.addLast(first.right);
                    }
                }
            } else {//偶数层，从右往左
                for (int i = 0; i < levelCount; i++) {
                    TreeNode last = deque.pollLast();
                    levelList.add(last.val);
                    if (null != last.right) {
                        deque.addFirst(last.right);
                    }
                    if (null != last.left) {
                        deque.addFirst(last.left);
                    }
                }
            }
            result.add(levelList);
            odd++;
        }
        return result;
    }


    //leetcode offical solution
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (null == root) {
            return ans;
        }

        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    deque.offerLast(curNode.val);
                } else {
                    deque.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<>(deque));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }















}
