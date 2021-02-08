package Solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a5.next = null;
        a4.next = a5;
        a3.next = a4;
        a2.next = a3;
        a1.next = a2;

        // when
        ListNode result = reverseList(a1);

        ListNode b1 = a5;
        ListNode b2 = a4;
        ListNode b3 = a3;
        ListNode b4 = a2;
        ListNode b5 = a1;
        b5.next = null;
        b4.next = b5;
        b3.next = b4;
        b2.next = b3;
        b1.next = b2;

        // then
        assertEquals(b1, result);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
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
