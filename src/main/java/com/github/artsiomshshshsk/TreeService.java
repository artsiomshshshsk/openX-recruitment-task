package com.github.artsiomshshshsk;

public class TreeService {

    /**
     * Calculate number of all leaves (nodes without children)
     *
     * @param node root node of subtree
     * @return number of all leaves
     */
    public int countLeaves(TreeNode node) {
        if (node == null) return 0;
        if (node.getLeft() == null && node.getRight() == null) return 1;
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }


    /**
     * Calculate the largest number of edges in a path
     * from the root node to a leaf node
     *
     * @param node root node of subtree
     * @return median of nodes
     */
    public int longestPath(TreeNode node) {
        if (node == null) return 0;

        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        }
        return 1 + Math.max(longestPath(node.getLeft()), longestPath(node.getRight()));
    }


    /**
     * Check two trees for equality
     *
     * @param tree1 root node of the first tree
     * @param tree2 root node of the second tree
     * @return boolean - result of equality check
     */
    public boolean checkForEquality(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        if (tree1.getVal() != tree2.getVal()) return false;
        return checkForEquality(tree1.getLeft(), tree2.getLeft()) &&
                checkForEquality(tree1.getRight(), tree2.getRight());
    }
}
