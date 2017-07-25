package lists;

/**
 * Created by sanjay on 12/28/16.
 */
public class DeleteNodesGTX
{
    public static class LinkedListNode
    {
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value)
        {
            val = node_value;
            next = null;
        }
    }

    public static LinkedListNode insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val)
    {
        if (head == null)
        {
            head = new LinkedListNode(val);
            tail = head;
        }
        else
        {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }

    static LinkedListNode removeNodes(LinkedListNode list, int x)
    {
        LinkedListNode prev = null, curr = list;
        while (curr != null)
        {
            if (curr.val > x)
            {
                if (null != curr.next)
                {
                    curr.val = curr.next.val;
                    curr.next = curr.next.next;
                    continue;
                }
                else
                {
                    prev.next = null;
                }
            }
            prev = curr;
            curr = curr.next;
        }
        return list;
    }
    
    private void printList(LinkedListNode head)
    {
        LinkedListNode node = head;
        while (node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args)
    {
        DeleteNodesGTX dngtx = new DeleteNodesGTX();
        LinkedListNode head = null, tail = null;
        head = tail = dngtx.insert_node_into_singlylinkedlist(head, tail, 30);
        tail = dngtx.insert_node_into_singlylinkedlist(head, tail, 1);
        tail = dngtx.insert_node_into_singlylinkedlist(head, tail, 2);
        tail = dngtx.insert_node_into_singlylinkedlist(head, tail, 20);
        tail = dngtx.insert_node_into_singlylinkedlist(head, tail, 3);
        tail = dngtx.insert_node_into_singlylinkedlist(head, tail, 10);
        tail = dngtx.insert_node_into_singlylinkedlist(head, tail, 15);
        tail = dngtx.insert_node_into_singlylinkedlist(head, tail, 4);
        //dngtx.printList(head);
        head = dngtx.removeNodes(head, 3);
        dngtx.printList(head);
    }
}
