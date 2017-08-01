package trees;

/**
 * Created by sanjay on 1/10/17.
 */
public class TreePathSum
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

    private static boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null)
        {
            return false;
        }

        if (root.val == sum && (root.left == null && root.right == null))
        {
            return true;
        }

        return hasPathSum(root.left, (sum - root.val)) || hasPathSum(root.right, (sum - root.val));
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        //int result = tree.findKthSmallestElement(tree.root, 3);

        boolean result = hasPathSum(root, 14);
        System.out.println(result);
    }
}
