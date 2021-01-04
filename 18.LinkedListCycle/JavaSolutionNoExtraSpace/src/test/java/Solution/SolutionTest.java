package Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
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
