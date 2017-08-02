package trees;

import sun.reflect.generics.tree.Tree;

/**
 * Created by sanjay on 8/1/17.
 */
public class SortedArrayToBST
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

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int rootIndex = (start + end) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);

        root.left = sortedArrayToBSTHelper(nums, start, rootIndex - 1);
        root.right = sortedArrayToBSTHelper(nums, rootIndex + 1, end);

        return root;
    }

    private static TreeNode sortedArrayToBST(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return null;
        }
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
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
        int[] nums = {1, 2, 3, 4};
        TreeNode root = sortedArrayToBST(nums);
        inorderTraversal(root);
    }
}
