package com.github.artsiomshshshsk;

import com.github.artsiomshshshsk.tree.TreeNode;
import com.github.artsiomshshshsk.tree.TreeService;
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
    void testCountLeavesSingleNode() {
        TreeNode tree = new TreeNode(5);
        assertEquals(1, service.countLeaves(tree));
    }

    @Test
    void testCountLeavesTreeWithOneLeaf() {
        TreeNode node = new TreeNode(10, new TreeNode(20), null);
        int count = service.countLeaves(node);
        assertEquals(1, count);
    }

    @Test
    void testCountLeavesTreeWithMultipleLeaves() {
        /*
         * Test tree:
         *        10
         *       /  \
         *      20  30
         */
        TreeNode node = new TreeNode(10,
                new TreeNode(20),
                new TreeNode(30)
        );
        int count = service.countLeaves(node);
        assertEquals(2, count);
    }

    @Test
    void testCountLeavesForNullTree() {
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

    @Test
    void testCheckForEquality() {
        /*
         * Test trees:
         * Tree 1       Tree 2
         *   10            10
         *  /  \             \
         * 20  30            30
         *                    \
         *                    40
         */
        TreeNode tree1 = new TreeNode(10,
                new TreeNode(20),
                new TreeNode(30)
        );
        TreeNode tree2 = new TreeNode(10,
                null,
                new TreeNode(30,
                        null,
                        new TreeNode(40))
        );

        TreeService treeService = new TreeService();
        boolean isEqual = treeService.checkForEquality(tree1, tree2);
        assertFalse(isEqual);
    }

    @Test
    void testCheckForEqualityNullNodes() {
        TreeService treeService = new TreeService();
        boolean isEqual = treeService.checkForEquality(null, null);
        assertTrue(isEqual);
    }

    @Test
    void testCheckForEqualityOneNullNode() {
        TreeNode node = new TreeNode(1);
        TreeService treeService = new TreeService();
        boolean isEqual = treeService.checkForEquality(node, null);

        assertFalse(isEqual);
    }

    @Test
    void testCheckForEqualitySameNodes() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeService treeService = new TreeService();
        boolean isEqual = treeService.checkForEquality(node1, node2);

        assertTrue(isEqual);
    }

    @Test
    void testCheckForEqualityDifferentNodes() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeService treeService = new TreeService();
        boolean isEqual = treeService.checkForEquality(node1, node2);

        assertFalse(isEqual);
    }


    @Test
    void testCheckForEqualitySameTrees() {
        /*
         * Test trees:
         * Tree 1       Tree 2
         *   10            10
         *  /  \          /  \
         * 20  30        20  30
         */
        TreeNode tree1 = new TreeNode(10,
                new TreeNode(20),
                new TreeNode(30)
        );
        TreeNode tree2 = new TreeNode(10,
                new TreeNode(20),
                new TreeNode(30)
        );

        TreeService treeService = new TreeService();
        boolean isEqual = treeService.checkForEquality(tree1, tree2);
        assertTrue(isEqual);
    }



}