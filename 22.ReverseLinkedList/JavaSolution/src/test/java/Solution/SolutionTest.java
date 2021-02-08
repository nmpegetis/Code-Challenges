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
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // temp in order to keep track of the rest of the list, where to continue after
            // adding curr node in the reversed list.
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            // curr is now again pointing to the initial list, the addition of the node was
            // done above.
            curr = temp;
        }
        return prev;
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
