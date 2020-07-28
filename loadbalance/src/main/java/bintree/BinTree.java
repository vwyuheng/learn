package bintree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class BinTree {

    public int maxDepth(TreeNode root) {

        int depth = 0;
        if (root != null) {
            depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        return depth;
    }


    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size>0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                size --;
            }
            depth++;
        }
        return depth;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val= x;
        }
    }


    public static void main(String[] args) {

        TreeNode root = new BinTree().new TreeNode(3);
        TreeNode t1 = new BinTree().new TreeNode(9);
        TreeNode t2 = new BinTree().new TreeNode(20);
        TreeNode t3 = new BinTree().new TreeNode(15);
        TreeNode t4 = new BinTree().new TreeNode(7);

        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;

        BinTree binTree = new BinTree();

        System.out.println(binTree.maxDepth(root));
    }
}
