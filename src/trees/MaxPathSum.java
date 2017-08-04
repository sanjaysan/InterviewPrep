package trees;

/**
 * Created by sanjay on 8/3/17.
 */
public class MaxPathSum
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

    private static int maxPathSumHelper(TreeNode root, int[] max)
    {
        if (root == null)
        {
            return 0;
        }

        int left = maxPathSumHelper(root.left, max);
        int right = maxPathSumHelper(root.right, max);

        int current = Math.max(root.val, Math.max(left, right) + root.val);
        max[0] = Math.max(max[0], Math.max(current, left + root.val + right));

        return current;
    }

    private static int maxPathSum(TreeNode root)
    {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, max);
        return max[0];
    }

    public static void main (String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        int result = maxPathSum(root);
        System.out.println(result);
    }
}
