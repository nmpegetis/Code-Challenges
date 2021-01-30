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
        ListNode b1 = a1;
        ListNode b2 = a2;
        ListNode b3 = a3;
        ListNode b4 = a5;
        b4.next = null;
        b3.next = b4;
        b2.next = b3;
        b1.next = b2;

        // when
        ListNode result = removeNthFromEnd(a1, 2);

        // then
        assertEquals(b1, result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int l = 0;
        ListNode first = head;
        while (first != null) {
            first = first.next;
            l++;
        }
        l -= n;
        ListNode second = dummy;
        while (l > 0) {
            second = second.next;
            l--;
        }
        second.next = second.next.next;
        return dummy.next;
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
