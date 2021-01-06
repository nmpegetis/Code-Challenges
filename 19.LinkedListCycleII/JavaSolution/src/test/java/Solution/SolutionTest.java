package Solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashSet;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(-4);
        four.next = two;
        three.next = four;
        two.next = three;
        one.next = two;

        // when
        ListNode result1 = detectCycle(one);
        four.next = null;
        ListNode result2 = detectCycle(one);

        // then
        assertEquals(two, result1);
        assertNull(result2);
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
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
