package trees;

/**
 * Created by sanjay on 8/10/17.
 */
public class MaDepthBST
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

    private static int maxDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main (String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int result = maxDepth(root);
        System.out.println(result);
    }
}
