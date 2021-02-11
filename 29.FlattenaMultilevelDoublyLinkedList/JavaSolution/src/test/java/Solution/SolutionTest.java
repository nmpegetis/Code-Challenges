package Solution;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        Node a6 = new Node(6);
        a6.next = null;
        a5.next = a6;
        a4.next = a5;
        a3.next = a4;
        a2.next = a3;
        a2.prev = a1;
        a1.next = a2;

        Node b1 = new Node(7);
        Node b2 = new Node(8);
        Node b3 = new Node(9);
        Node b4 = new Node(10);
        b4.next = null;
        b3.next = b4;
        b2.next = b3;
        b1.next = b2;

        Node c1 = new Node(11);
        Node c2 = new Node(12);
        c2.next = null;
        c1.next = c2;

        a3.child = b1;
        b2.child = c1;

        // when
        Node result = flatten(a1);

        // then
        assertEquals(a1, result);
        assertEquals(a2, result.next);
        assertEquals(a3, result.next.next);
        assertEquals(b1, result.next.next.next);
        assertEquals(b2, result.next.next.next.next);
        assertEquals(c1, result.next.next.next.next.next);
        assertEquals(c2, result.next.next.next.next.next.next);
        assertEquals(b3, result.next.next.next.next.next.next.next);
        assertEquals(b4, result.next.next.next.next.next.next.next.next);
        assertEquals(a4, result.next.next.next.next.next.next.next.next.next);
        assertEquals(a5, result.next.next.next.next.next.next.next.next.next.next);
        assertEquals(a6, result.next.next.next.next.next.next.next.next.next.next.next);
    }

    public Node flatten(Node head) {
        if (head == null)
            return head;

        Node pseudoHead = new Node(0);
        Node curr, prev = pseudoHead;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null)
                stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                // don't forget to remove all child pointers.
                curr.child = null;
            }
            prev = curr;
        }
        // detach the pseudo node from the result
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int x) {
            val = x;
            prev = null;
            next = null;
            child = null;
        }
    }
}
