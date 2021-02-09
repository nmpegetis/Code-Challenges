package Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(3);
        ListNode a6 = new ListNode(2);
        ListNode a7 = new ListNode(1);
        a7.next = null;
        a6.next = a7;
        a5.next = a6;
        a4.next = a5;
        a3.next = a4;
        a2.next = a3;
        a1.next = a2;

        ListNode b1 = new ListNode(0);
        ListNode b2 = new ListNode(1);
        b2.next = null;
        b1.next = b2;

        // when
        boolean result = isPalindrome(a1);
        boolean result2 = isPalindrome(b1);

        // then
        assertTrue(result);
        assertFalse(result2);
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null)
            return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val)
                result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
