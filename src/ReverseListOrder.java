/**
 * Created by sanjay on 12/27/16.
 */
public class ReverseListOrder
{
    static Node head = null;
    class Node
    {
        int val;
        Node next;
        Node (int val)
        {
            this.val = val;
            this.next = null;
        }
    }

    private void push(int val)
    {
        if (head == null)
        {
            Node node = new Node(val);
            head = node;
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            Node node = new Node(val);
            temp.next = node;
        }
    }

    private Node reverseOrder(Node firstNode)
    {
        Node pre = firstNode;
        if (pre != null)
        {
            Node curr = firstNode.next;
            while (curr != null)
            {
                Node temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }
            firstNode.next = null;
        }
        return pre;
    }

    private Node mergeLists(Node n1, Node n2)
    {
        if (n1 == null || n2 == null)
        {
            return null;
        }

        Node p1 = n1, p2 = n2;
        while (p2 != null)
        {
            Node temp1 = p1.next, temp2 = p2.next;
            p1.next = p2;
            p2.next =  temp1;

            p1 = temp1;
            p2 = temp2;
        }
        return n1;
    }

    private void reorderList()
    {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = slow.next;
        slow.next = null;

        second = reverseOrder(second);
        Node combinedHead = mergeLists(head, second);
        head = combinedHead;
    }

    private void printList()
    {
        Node node = head;
        while (node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static void main(String [] args)
    {
        ReverseListOrder rlo = new ReverseListOrder();
        rlo.push(1);
        rlo.push(2);
        rlo.push(3);
        rlo.push(4);
        rlo.printList();
        rlo.reorderList();
        rlo.printList();
    }
}
