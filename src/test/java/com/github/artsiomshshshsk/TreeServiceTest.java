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

}