package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sanjay on 8/3/17.
 */
public class MinDepthOfBST
{
    static class TreeNode
    {
        int val;
        TreeNode left, right;

        TreeNode(int item)
        {
            val = item;
        }
    }

    static class QItem
    {
        TreeNode node;
        int depth;

        QItem(TreeNode node, int depth)
        {
            this.node = node;
            this.depth = depth;
        }
    }

    private static int minDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        QItem qitem = new QItem(root, 1);
        Queue<QItem> queue = new LinkedList<QItem>();
        queue.add(qitem);

        while (!queue.isEmpty())
        {
            QItem front = queue.poll();

            TreeNode node = front.node;
            int nodeDepth = front.depth;

            if (node.left == null && node.right == null)
            {
                return nodeDepth;
            }

            if (node.left != null)
            {
                queue.add(new QItem(node.left, nodeDepth + 1));
            }

            if (node.right != null)
            {
                queue.add(new QItem(node.right, nodeDepth + 1));
            }
        }
        return 0;
    }

    public static void main (String[] args)
    {
        TreeNode root = new TreeNode(   1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        int result = minDepth(root);
        System.out.println(result);
    }
}
