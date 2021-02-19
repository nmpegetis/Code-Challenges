package Solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2, t3, t4);
        TreeNode t1 = new TreeNode(1, t2, t5);

        // when
        int result = maxDepth(t1);

        // then
        assertEquals(3, result);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        int maxDepth = 1;
        maxDepth = maxDepth(root, maxDepth, depth);
        return maxDepth;
    }

    private int maxDepth(TreeNode node, int maxDepth, int depth) {
        if (node == null) {
            return maxDepth;
        }
        if (node.left == null && node.right == null) {
            return depth;
        }
        int maxDepthL = maxDepth(node.left, maxDepth, depth + 1);
        int maxDepthR = maxDepth(node.right, maxDepth, depth + 1);
        maxDepth = Math.max(maxDepthL, maxDepthR);
        return maxDepth;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
