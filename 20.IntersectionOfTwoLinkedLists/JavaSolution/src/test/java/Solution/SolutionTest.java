package Solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(9);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(4);
        a5.next = null;
        a4.next = a5;
        a3.next = a4;
        a2.next = a3;
        a1.next = a2;
        ListNode b1 = new ListNode(3);
        b1.next = a4;
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(8);
        c2.next = null;
        c1.next = c2;

        // when
        ListNode result1 = getIntersectionNode(a1, b1);
        ListNode result2 = getIntersectionNode(a1, c1);

        // then
        assertEquals(a4, result1);
        assertNull(result2);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
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
