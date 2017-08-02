package trees;

/**
 * Created by sanjay on 8/1/17.
 */
public class BuildTreeFromTraversal
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

    private static TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
                                            int[] postorder, int postStart, int postEnd)
    {
        if (inStart > inEnd || postStart > postEnd)
        {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++)
        {
            if (inorder[i] == rootVal)
            {
                rootIndex = i;
                break;
            }
        }

        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1,
                postorder, postStart, postStart + rootIndex - (inStart + 1));

        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd,
                postorder, postStart + rootIndex - inStart, postEnd - 1);

        return root;
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder)
    {
        int inStart = 0, inEnd = inorder.length - 1;
        int postStart = 0, postEnd = postorder.length - 1;

        return buildTreeHelper(inorder, inStart, inEnd, postorder, postStart, postEnd);
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
        int[] postorder = {4, 5, 2, 6, 7, 8, 3, 1};
        TreeNode root = buildTree(inorder, postorder);

        inorderTraversal(root);
    }
}
