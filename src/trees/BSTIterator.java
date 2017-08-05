package trees;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by sanjay on 8/5/17.
 */
public class BSTIterator
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

    Stack<TreeNode> stack;

    private BSTIterator(TreeNode root)
    {
        stack = new Stack<TreeNode>();
        while (root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    private boolean hasNext()
    {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    private int next()
    {
        TreeNode nextNode = stack.pop();
        int nextVal = nextNode.val;

        if (nextNode.right != null)
        {
            nextNode = nextNode.right;
            while (nextNode != null)
            {
                stack.push(nextNode);
                nextNode = nextNode.left;
            }
        }

        return nextVal;
    }

    public static void main (String[] args)
    {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        BSTIterator i = new BSTIterator(root);
        while (i.hasNext())
        {
            int nextVal = i.next();
            System.out.println("next: " + nextVal);
        }
    }
}

