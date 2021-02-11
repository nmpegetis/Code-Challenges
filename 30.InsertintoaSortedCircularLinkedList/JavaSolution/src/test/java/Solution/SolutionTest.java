package Solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        Node a1 = new Node(3);
        Node a2 = new Node(4);
        Node a3 = new Node(1);
        a3.next = a1;
        a2.next = a3;
        a1.next = a2;

        // when
        Node result = insert(a1, 2);

        // then
        assertEquals(a1, result);
        assertEquals(a2, result.next);
        assertEquals(a3, result.next.next);
        assertEquals(2, result.next.next.next.val);
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node prev = head;
        Node curr = head.next;
        boolean isBetween = false;
        boolean isBeyondMinMax = false;
        do {
            isBetween = prev.val <= insertVal && insertVal <= curr.val;
            isBeyondMinMax = (prev.val > curr.val) && (insertVal >= prev.val || insertVal <= curr.val);
            if (isBetween || isBeyondMinMax) {
                Node node = new Node(insertVal);
                prev.next = node;
                node.next = curr;
                return head;
            }

            prev = curr;
            curr = curr.next;
        } while (prev != head);

        // case that the loop was finished but there was nothing returned = all vals in
        // the nodes are equal and the insertedVal is different
        Node node = new Node(insertVal);
        prev.next = node;
        node.next = curr;
        return head;
    }

    class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }
}
