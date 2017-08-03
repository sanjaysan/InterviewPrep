package trees;

import sun.reflect.generics.tree.Tree;

/**
 * Created by sanjay on 8/3/17.
 */
public class BuildTreeFromInPreTraversal
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

    static class Index
    {
        int index;
    }

    private static TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] preorder, Index preIndex)
    {
        if (inStart > inEnd)
        {
            return null;
        }

        int rootVal = preorder[preIndex.index++];
        TreeNode root = new TreeNode(rootVal);

        if (inStart == inEnd)
        {
            return root;
        }

        int rootIndex = 0;
        for (int i = 0;i < inorder.length; i++)
        {
            if (inorder[i] == rootVal)
            {
                rootIndex = i;
                break;
            }
        }

        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1, preorder, preIndex);
        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd, preorder, preIndex);

        return root;
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if (inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0)
        {
            return null;
        }

        int inStart = 0, inEnd = inorder.length - 1;
        Index preIndex = new Index();
        preIndex.index = 0;

        return buildTreeHelper(inorder, inStart, inEnd, preorder, preIndex);
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

    public static void main(String[] args)
    {
        int[] inorder = {4, 2, 5, 1, 6, 7, 3, 8};
        int[] preorder = {1, 2, 4, 5, 3, 7, 6, 8};
        TreeNode root = buildTree(preorder, inorder);

        inorderTraversal(root);
    }
}
