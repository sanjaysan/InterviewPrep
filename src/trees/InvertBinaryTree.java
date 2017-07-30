package trees;

import sun.reflect.generics.tree.Tree;

/**
 * Created by sanjay on 7/24/17.
 */
public class InvertBinaryTree
{
    static class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data)
        {
            this.data = data;
        }
    }

    private static TreeNode invertTree(TreeNode root)
    {
        if (root != null)
        {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            if (root.left != null)
            {
                invertTree(root.left);
            }
            if (root.right != null)
            {
                invertTree(root.right);
            }
        }
        return root;
    }

    private static void printInorder(TreeNode root)
    {
        if (root != null)
        {
            if (root.left != null)
            {
                printInorder(root.left);
            }

            System.out.print(root.data + " ");

            if (root.right != null)
            {
                printInorder(root.right);
            }
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root = invertTree(root);
        printInorder(root);
    }
}
