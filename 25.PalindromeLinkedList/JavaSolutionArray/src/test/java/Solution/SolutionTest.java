package Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> array = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            array.add(curr.val);
            curr = curr.next;
        }

        int start = 0;
        int end = array.size() - 1;
        while (start < end) {
            if (!array.get(start).equals(array.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
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
