package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sanjay on 8/7/17.
 */
public class PopulateNextRightPointer
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

    static class NodeDepth
    {
        TreeLinkNode node;
        int depth;

        NodeDepth(TreeLinkNode node, int depth)
        {
            this.node = node;
            this.depth = depth;
        }
    }

    private static void connect(TreeLinkNode root)
    {
        if (root == null)
        {
            return;
        }

        Queue<NodeDepth> q = new LinkedList<NodeDepth>();
        q.add(new NodeDepth(root, 1));

        while (!q.isEmpty())
        {
            NodeDepth front = q.poll();
            if (q.isEmpty())
            {
                front.node.next = null;
            }
            else if (front.depth == q.peek().depth)
            {
                front.node.next = q.peek().node;
            }
            else if (front.depth < q.peek().depth)
            {
                front.node.next = null;
            }

            if (front.node.left != null)
            {
                q.add(new NodeDepth(front.node.left, front.depth + 1));
            }

            if (front.node.right != null)
            {
                q.add(new NodeDepth(front.node.right, front.depth + 1));
            }
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

    public static void main (String[] args)
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

