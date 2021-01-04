package Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(-4);
        four.next = two;
        three.next = four;
        two.next = three;
        one.next = two;

        // when
        boolean result1 = hasCycle(one);
        four.next = null;
        boolean result2 = hasCycle(one);

        // then
        assertTrue(result1);
        assertFalse(result2);
    }

    /**
     * Definition for singly-linked list.
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
