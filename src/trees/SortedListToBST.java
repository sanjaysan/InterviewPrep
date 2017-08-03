package trees;

/**
 * Created by sanjay on 8/3/17.
 */
public class SortedListToBST
{
    static class ListNode
    {
        int val;
        ListNode next;

        ListNode (int item)
        {
            val = item;
            next = null;
        }
    }

    static class TreeNode
    {
        int val;
        TreeNode left, right;

        TreeNode(int item)
        {
            val = item;
        }
    }

    private static ListNode curr;

    private static int getListSize(ListNode head)
    {
        if (head == null)
        {
            return 0;
        }

        ListNode p = head;
        int len = 0;

        while (p != null)
        {
            len++;
            p = p.next;
        }

        return len;
    }

    private static TreeNode sortedListToBSTHelper(int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode left = sortedListToBSTHelper(start, mid - 1);

        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;

        TreeNode right = sortedListToBSTHelper(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }


    private static TreeNode sortedListToBST(ListNode head)
    {
        curr = head;
        int listSize = getListSize(head);
        return sortedListToBSTHelper(0, listSize - 1);
    }

    private static void inorderTraversal(TreeNode root)
    {
        if (root != null)
        {
            if (root.left != null)
            {
                inorderTraversal(root.left);
            }

            System.out.print(root.val + " ");

            if (root.right != null)
            {
                inorderTraversal(root.right);
            }
        }
    }

    public static void main (String[] args)
    {
        ListNode head = new ListNode(7);
        head.next = new ListNode(6);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);

        TreeNode root = sortedListToBST(head);
        inorderTraversal(root);
    }
}
