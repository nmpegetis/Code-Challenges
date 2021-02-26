package Solution;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] preorder = new int[] { 3, 9, 20, 15, 7 };
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };

        // when
        TreeNode result = buildTree(preorder, inorder);

        // then
        assertEquals(3, result.val);
        assertEquals(9, result.left.val);
        assertEquals(20, result.right.val);
        assertEquals(15, result.right.left.val);
        assertEquals(7, result.right.right.val);
    }

    int curr_pos;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        curr_pos = 0;

        int pos = 0;
        for (Integer val : inorder) {
            map.put(val, pos++);
        }
        return helper(curr_pos, inorder.length - 1);
    }

    public TreeNode helper(int left_pos, int right_pos) {
        if (left_pos > right_pos) {
            return null;
        }

        int value = preorder[curr_pos];
        TreeNode root = new TreeNode(value);
        int index = map.get(value);

        curr_pos++;
        root.left = helper(left_pos, index - 1);
        root.right = helper(index + 1, right_pos);
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
