package Solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        a3.next = null;
        a2.next = a3;
        a1.next = a2;
        a1.random = null;
        a2.random = a1;
        a3.random = a3;

        // when
        Node result = copyRandomList(a1);

        // then
        assertEquals(a1.val, result.val);
        assertEquals(a2.val, result.next.val);
        assertEquals(a3.val, result.next.next.val);
        assertNull(result.random);
        assertEquals(a1.val, result.next.random.val);
        assertEquals(a3.val, result.next.next.random.val);
    }

    Map<Node, Node> visited = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node oldNode = head;

        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }

    public Node getClonedNode(Node node) {
        if (node != null) {
            if (this.visited.containsKey(node)) {
                return this.visited.get(node);
            } else {
                this.visited.put(node, new Node(node.val));
                return this.visited.get(node);
            }
        }
        return null;
    }

    class Node {
        int val;
        Node next;
        Node random;

        Node(int x) {
            val = x;
            next = null;
            random = null;
        }
    }
}
