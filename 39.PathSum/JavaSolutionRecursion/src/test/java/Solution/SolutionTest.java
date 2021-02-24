package Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        TreeNode t10 = new TreeNode(3);
        TreeNode t9 = new TreeNode(3);
        TreeNode t8 = new TreeNode(2, t10, null);
        TreeNode t7 = new TreeNode(2, null, t9);
        TreeNode t6 = new TreeNode(1, t7, t8);

        // when
        boolean result1 = hasPathSum(t1, 7);
        boolean result2 = hasPathSum(t6, 7);

        // then
        assertTrue(result1);
        assertFalse(result2);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
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
