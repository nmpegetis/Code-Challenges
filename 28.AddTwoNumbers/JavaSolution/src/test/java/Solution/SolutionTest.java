package Solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a3.next = null;
        a2.next = a3;
        a1.next = a2;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b3.next = null;
        b2.next = b3;
        b1.next = b2;

        ListNode c1 = new ListNode(7);
        ListNode c2 = new ListNode(0);
        ListNode c3 = new ListNode(8);
        c3.next = null;
        c2.next = c3;
        c1.next = c2;

        // when
        ListNode result = addTwoNumbers(a1, b1);

        // then
        assertEquals(c1.val, result.val);
        assertEquals(c1.next.val, result.next.val);
        assertEquals(c1.next.next.val, result.next.next.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
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
