package Solution;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };
        int[] postorder = new int[] { 9, 15, 7, 20, 3 };

        // when
        TreeNode result = buildTree(inorder, postorder);

        // then
        assertEquals(3, result.val);
        assertEquals(9, result.left.val);
        assertEquals(20, result.right.val);
        assertEquals(15, result.right.left.val);
        assertEquals(7, result.right.right.val);
    }

    int curr_pos;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        curr_pos = inorder.length - 1;

        int pos = 0;
        for (Integer val : inorder) {
            map.put(val, pos++);
        }
        return helper(0, curr_pos);
    }

    public TreeNode helper(int left_pos, int right_pos) {
        if (left_pos > right_pos) {
            return null;
        }

        int value = postorder[curr_pos];
        TreeNode root = new TreeNode(value);
        int index = map.get(value);

        curr_pos--;
        root.right = helper(index + 1, right_pos);
        root.left = helper(left_pos, index - 1);
        return root;
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
