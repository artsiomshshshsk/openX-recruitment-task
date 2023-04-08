package com.github.artsiomshshshsk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeServiceTest {

    private TreeService service;

    @BeforeEach
    void setUp() {
        service = new TreeService();
    }


    @Test
    public void testCountLeavesSingleNode() {
        TreeNode tree = new TreeNode(5);
        assertEquals(1, service.countLeaves(tree));
    }

    @Test
    public void testCountLeavesTreeWithOneLeaf() {
        TreeNode node = new TreeNode(10, new TreeNode(20), null);
        int count = service.countLeaves(node);
        assertEquals(1, count);
    }

    @Test
    public void testCountLeavesTreeWithMultipleLeaves() {
        TreeNode node = new TreeNode(10, new TreeNode(20), new TreeNode(30));
        int count = service.countLeaves(node);
        assertEquals(2, count);
    }

    @Test
    public void testCountLeavesForNullTree() {
        TreeNode node = null;
        int count = service.countLeaves(node);
        assertEquals(0, count);
    }

    @Test
    void testLongestPath() {
        /*
         * Test tree:
         *        10
         *       /  \
         *      20  30
         *     / \   / \
         *    40 50 60 70
         */
        TreeNode root = new TreeNode(10,
                new TreeNode(20,
                        new TreeNode(40),
                        new TreeNode(50)),
                new TreeNode(30,
                        new TreeNode(60),
                        new TreeNode(70))
        );

        TreeService treeService = new TreeService();
        int longestPath = treeService.longestPath(root);
        assertEquals(2, longestPath);
    }

    @Test
    void testLongestPathNullNode() {
        TreeService treeService = new TreeService();
        int longestPath = treeService.longestPath(null);

        assertEquals(0, longestPath);
    }

    @Test
    void testLongestPathSingleNode() {
        TreeNode node = new TreeNode(1);
        TreeService treeService = new TreeService();
        int longestPath = treeService.longestPath(node);
        assertEquals(0, longestPath);
    }

    @Test
    void testLongestPathTwoLeaves() {
        /*
         * Test tree:
         *      1
         *     / \
         *    2   3
         *       / \
         *      4   5
         */
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5))
        );
        TreeService treeService = new TreeService();
        int longestPath = treeService.longestPath(root);
        assertEquals(2, longestPath);
    }



}