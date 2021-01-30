package Solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        ListNode result1 = detectCycle(one);
        four.next = null;
        ListNode result2 = detectCycle(one);

        // then
        assertEquals(two, result1);
        assertNull(result2);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = intersect;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    private ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
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
