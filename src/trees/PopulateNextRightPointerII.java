package trees;

/**
 * Created by sanjay on 10/9/17.
 */
public class PopulateNextRightPointerII
{
    static class TreeLinkNode
    {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x)
        {
            val = x;
        }
    }

    private static void connect(TreeLinkNode root)
    {
        if (root == null)
        {
            return;
        }

        TreeLinkNode lastHead = root;
        TreeLinkNode lastCurrent = null;
        TreeLinkNode currentHead = null;
        TreeLinkNode current = null;

        while (lastHead != null)
        {
            lastCurrent = lastHead;

            while (lastCurrent != null)
            {
                if (currentHead == null)
                {
                    currentHead = lastCurrent.left;
                    current = lastCurrent.left;
                }
                else
                {
                    current.next = lastCurrent.left;
                    current = current.next;
                }

                if (currentHead != null)
                {
                    current.next = lastCurrent.right;
                    current = current.next;
                }

                lastCurrent = lastCurrent.next;
            }
            lastHead = currentHead;
            currentHead = null;
        }
    }

    private static void printTreeLinkedList(TreeLinkNode root)
    {
        if (root == null)
        {
            return;
        }

        TreeLinkNode p = root;
        while (p != null)
        {
            System.out.print(p.val + " ");
            p = p.next;
        }

        System.out.println();
        printTreeLinkedList(root.left);
    }

    public static void main(String[] args)
    {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        connect(root);
        printTreeLinkedList(root);
    }
}
