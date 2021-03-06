package Solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);

        // when
        TreeNode result = connect(t1);

        // then
        assertEquals(1, result.val);
        assertNull(result.next);
        assertEquals(2, result.left.val);
        assertEquals(3, result.left.next.val);
        assertNull(result.right.next);
        assertEquals(4, result.left.left.val);
        assertEquals(5, result.left.left.next.val);
        assertEquals(6, result.left.right.next.val);
        assertEquals(7, result.right.left.next.val);
        assertNull(result.right.right.next);
    }

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftmost = root;

        while (leftmost.left != null) {
            TreeNode head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

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

        TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

}
