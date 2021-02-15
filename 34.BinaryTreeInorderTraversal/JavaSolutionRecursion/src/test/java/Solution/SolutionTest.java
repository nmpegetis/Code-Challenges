package Solution;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

        List<Integer> l = new LinkedList<>();
        Collections.addAll(l, 3, 2, 4, 1, 5);

        // when
        List<Integer> result = preorderTraversal(t1);

        // then
        assertEquals(l, result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        list.addAll(preorderTraversal(root.left));
        list.add(root.val);
        list.addAll(preorderTraversal(root.right));

        return list;
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
