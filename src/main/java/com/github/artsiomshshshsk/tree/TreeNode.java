package com.github.artsiomshshshsk.tree;

import lombok.Getter;

@Getter
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}