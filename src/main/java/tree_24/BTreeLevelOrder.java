package tree_24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversedList = new ArrayList<List<Integer>>();
        if (root == null) {//非空校验
            return traversedList;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);//根节点入队
        while (!queue.isEmpty()) {
            List<Integer> levelValue = new ArrayList<Integer>();
            int currentLevelNodes = queue.size();
            for (int i = 1; i <= currentLevelNodes; ++i) {
                TreeNode node = queue.poll();//出队
                levelValue.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            traversedList.add(levelValue);
        }

        return traversedList;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        System.out.println("length is " + ints.length);
//        TreeNode left1 = new TreeNode(1);
//        TreeNode right1 = new TreeNode(2);
//        TreeNode root = new TreeNode(0, left1, right1);
//        BTreeLevelOrder bTreeLevelOrder = new BTreeLevelOrder();
//        List<List<Integer>> lists = bTreeLevelOrder.levelOrder(root);
//        System.out.println(lists);
    }
}
