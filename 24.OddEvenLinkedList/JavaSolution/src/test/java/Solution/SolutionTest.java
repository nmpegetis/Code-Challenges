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
        ListNode result = oddEvenList(a1);

        ListNode b1 = a1;
        ListNode b2 = a2;
        ListNode b3 = a3;
        ListNode b4 = a4;
        ListNode b5 = a5;
        ListNode b6 = a6;
        ListNode b7 = a7;
        b6.next = null;
        b4.next = b6;
        b2.next = b4;
        b7.next = b2;
        b5.next = b7;
        b3.next = b5;
        b1.next = b3;

        // then
        assertEquals(b1, result);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        ListNode evenHead = evenPtr;
        while (evenPtr != null && evenPtr.next != null) {
            oddPtr.next = evenPtr.next;
            oddPtr = oddPtr.next;
            evenPtr.next = oddPtr.next;
            evenPtr = evenPtr.next;
        }
        oddPtr.next = evenHead;
        return head;
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
