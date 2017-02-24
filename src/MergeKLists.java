import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sanjay on 1/6/17.
 */
public class MergeKLists
{
    static ListNode firstNode;
    static public class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
        }
    }
    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists==null||lists.length==0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>()
        {
            @Override
            public int compare(ListNode l1, ListNode l2)
            {
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode list: lists)
        {
            if(list!=null)
                queue.offer(list);
        }

        while(!queue.isEmpty())
        {
            ListNode n = queue.poll();
            p.next = n;
            p=p.next;

            if(n.next!=null)
                queue.offer(n.next);
        }

        return head.next;
    }
    private void printList(ListNode head)
    {
        ListNode node = head;
        while (node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static void main(String [] args)
    {
        MergeKLists mklists = new MergeKLists();

        ListNode lists[] = new ListNode[3];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(3);
        lists[0].next.next = new ListNode(5);
        lists[0].next.next.next = new ListNode(7);

        lists[1] = new ListNode(2);
        lists[1].next = new ListNode(4);
        lists[1].next.next = new ListNode(6);
        lists[1].next.next.next = new ListNode(8);

        lists[2] = new ListNode(0);
        lists[2].next = new ListNode(9);
        lists[2].next.next = new ListNode(10);
        lists[2].next.next.next = new ListNode(11);


        ListNode head = mklists.mergeKLists(lists);

        mklists.printList(head);
    }
}
