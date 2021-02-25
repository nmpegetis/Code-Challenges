package Solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        TreeNode t5 = new TreeNode(5, null, t6);
        TreeNode t2 = new TreeNode(1, t3, t4);
        TreeNode t1 = new TreeNode(5, t2, t5);

        // when
        int result = countUnivalSubtrees(t1);

        // then
        assertEquals(4, result);
    }

    int count = 0;

    boolean is_uni(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }

        boolean is_unival = true;
        if (node.left != null) {
            is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
        }
        if (node.right != null) {
            is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
        }
        if (!is_unival)
            return false;

        count++;
        return true;
    }

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;
        is_uni(root);
        return count;
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
