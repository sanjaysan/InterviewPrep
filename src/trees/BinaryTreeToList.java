package trees;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by sanjay on 7/31/17.
 */
public class BinaryTreeToList
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

    private static void flatten(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null || !stack.empty())
        {

            if (p.right != null)
            {
                stack.push(p.right);
            }

            if (p.left != null)
            {
                p.right = p.left;
                p.left = null;
            }
            else if (!stack.empty())
            {
                p.right = stack.pop();
            }

            p = p.right;
        }
    }

    private static void inOrderTraversal(TreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.val + " ");
        }

        if (root.left != null)
        {
            inOrderTraversal(root.left);
        }

        if (root.right != null)
        {
            inOrderTraversal(root.right);
        }
    }

    public static void main (String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        flatten(root);
        inOrderTraversal(root);
    }
}
