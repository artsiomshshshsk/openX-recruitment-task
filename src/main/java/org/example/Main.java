package org.example;

import org.task1.TreeNode;
import org.task1.TreeService;

public class Main {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                null,null),
                        new TreeNode(5,
                                null,null)),
                new TreeNode(7,
                        new TreeNode(1,
                                null,null),
                        new TreeNode(0,
                                new TreeNode(2,
                                        null,null),
                                new TreeNode(8,
                                        null,new TreeNode(5,null,null))))
        );

        TreeNode tree2 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                null,null),
                        new TreeNode(5,
                                null,null)),
                null
        );

        TreeService service = new TreeService();

        System.out.println("total nodes without children:" + service.countLeaves(tree));
        System.out.println("largest number of edges in a path from the root node to a leaf node:" + service.longestPath(tree));
        System.out.println("equal trees equality check:" + service.checkForEquality(tree,tree2));

    }
}