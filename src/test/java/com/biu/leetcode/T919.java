package com.biu.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Class_name T919
 * @Description ……
 * @Author longbiu
 * @Date 2022/7/25 22:54
 **/
public class T919 {
    Queue<TreeNode> candidate;
    TreeNode root;

    public T919(TreeNode root) {
        this.candidate = new ArrayDeque<TreeNode>();
        this.root = root;

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left ! = null){
                queue.offer(node.right);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (!(node.left != null && node.right != null)) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        int ret = node.val;
        if (node.left == null) {
            node.left = child;
        } else {
            node.right = child;
            candidate.poll();
        }
        candidate.offer(child);
        return ret;
    }

    public TreeNode get_root() {
        System.out.println(root.toString());
        return root;
    }
}
