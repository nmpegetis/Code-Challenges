package Solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a3.next = null;
        a2.next = a3;
        a1.next = a2;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b3.next = null;
        b2.next = b3;
        b1.next = b2;

        // when
        ListNode result = mergeTwoLists(a1, b1);

        ListNode c1 = b1;
        ListNode c2 = b2;
        ListNode c3 = b3;
        ListNode c4 = a1;
        ListNode c5 = a2;
        ListNode c6 = a3;

        c6.next = null;
        c3.next = c6;
        c2.next = c3;
        c5.next = c2;
        c4.next = c5;
        c1.next = c4;

        // then
        assertEquals(c1, result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinelNode = new ListNode(0);
        ListNode prev = sentinelNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return sentinelNode.next;
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
