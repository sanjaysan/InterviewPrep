import java.util.List;

/**
 * Created by sanjay on 12/28/16.
 */
public class PalindromeLL
{
    static ListNode firstNode;
    public class ListNode
    {
      int val;
      ListNode next;
      ListNode(int x)
      {
          val = x;
      }
    }

    private void push(int val)
    {
        if (firstNode == null)
        {
            ListNode node = new ListNode(val);
            firstNode = node;
        }
        else
        {
            ListNode temp = firstNode;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            ListNode node = new ListNode(val);
            temp.next = node;
        }
    }
    private void printList()
    {
        ListNode node = firstNode;
        while (node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private ListNode reverseOrder(ListNode head)
    {
        ListNode pre = head;
        if (pre != null)
        {
            ListNode curr = pre.next;
            while (curr != null)
            {
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }
            head.next = null;
        }
        return pre;
    }

    private boolean compareLists(ListNode list1, ListNode list2)
    {
        if (list1 == null || list2 == null)
        {
            return false;
        }
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null)
        {
            if (p1.val == p2.val)
            {
                p1 = p1.next;
                p2 = p2.next;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    private boolean isPalindrome(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return true;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        second = reverseOrder(second);
        boolean isPalin = compareLists(head, second);
        return isPalin;
    }
    public static void main(String [] args)
    {
        PalindromeLL pll = new PalindromeLL();
        pll.push(1);
        boolean isPalin = pll.isPalindrome(firstNode);
        System.out.println(isPalin);
    }
}
