package com.biu.leetcode;

/**
 * @Class_name T814
 * @Description https://leetcode.cn/problems/binary-tree-pruning/
 * @Author longbiu
 * @Date 2022/7/21 20:52
 **/
public class T814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
