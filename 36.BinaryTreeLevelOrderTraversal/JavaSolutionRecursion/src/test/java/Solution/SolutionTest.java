package Solution;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
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

        List<List<Integer>> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        Collections.addAll(l1, 1);
        Collections.addAll(l2, 2, 5);
        Collections.addAll(l3, 3, 4);
        Collections.addAll(l, l1, l2, l3);

        // when
        List<List<Integer>> result = levelOrder(t1);

        // then
        assertEquals(l, result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        levelOrder(list, root, 0);

        return list;
    }

    private void levelOrder(List<List<Integer>> list, TreeNode node, Integer level) {
        if (list.size() == level) {
            list.add(new ArrayList<Integer>());
        }

        list.get(level).add(node.val);
        if (node.left != null) {
            levelOrder(list, node.left, level + 1);
        }
        if (node.right != null) {
            levelOrder(list, node.right, level + 1);
        }
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
