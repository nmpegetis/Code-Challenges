package Solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(5);
        ListNode a7 = new ListNode(6);
        a7.next = null;
        a6.next = a7;
        a5.next = a6;
        a4.next = a5;
        a3.next = a4;
        a2.next = a3;
        a1.next = a2;

        // when
        ListNode result = removeElements(a1, 6);

        ListNode b1 = a1;
        ListNode b2 = a2;
        ListNode b3 = a4;
        ListNode b4 = a5;
        ListNode b5 = a6;
        b5.next = null;
        b4.next = b5;
        b3.next = b4;
        b2.next = b3;
        b1.next = b2;

        // then
        assertEquals(b1, result);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinelNode = new ListNode(0);
        sentinelNode.next = head;
        ListNode curr = head;
        ListNode prev = sentinelNode;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
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
