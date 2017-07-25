package lists;

/**
 * Created by sanjay on 1/18/17.
 */
//  Definition for singly-linked list.
class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
        next = null;
    }
}

// Definition for binary tree
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x)
    {
        val = x;
    }
}

public class SortedListToBST
{
    static ListNode h;

    private static TreeNode sortedListToBST(ListNode head)
    {
       if (head == null)
       {
           return null;
       }
       int length = getLength(head);
       return sortedListToBST(0, length - 1);
    }

    // get list length
    private static int getLength(ListNode head)
    {
        int len = 0;
        ListNode p = head;

        while (p != null)
        {
            len++;
            p = p.next;
        }
        return len;
    }

    // build tree bottom-up
    private static TreeNode sortedListToBST(int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode left = sortedListToBST(start, mid - 1);

        TreeNode root = new TreeNode(h.val);
        root.left = left;

        h = h.next;

        TreeNode right = sortedListToBST(mid + 1, end);
        root.right = right;

        return root;
    }

    private static void inOrderTraversal(TreeNode root)
    {
        if (root != null)
        {
            if (root.left != null)
            {
                inOrderTraversal(root.left);
            }
            System.out.println(root.val);
            if (root.right != null)
            {
                inOrderTraversal(root.right);
            }
        }
    }

    public static void main (String [] args)
    {
        h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
//        h.next.next.next = new lists.ListNode(4);
//        h.next.next.next.next = new lists.ListNode(5);
//        h.next.next.next.next.next = new lists.ListNode(6);
//        h.next.next.next.next.next.next = new lists.ListNode(7);
        SortedListToBST slb = new SortedListToBST();
        TreeNode root = slb.sortedListToBST(h);
        slb.inOrderTraversal(root);
    }
}
