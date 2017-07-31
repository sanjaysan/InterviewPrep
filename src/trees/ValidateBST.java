package trees;

/**
 * Created by sanjay on 7/30/17.
 */
public class ValidateBST
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

    private static boolean isValidBSTHelper(TreeNode node, double min, double max)
    {
        if (node == null)
        {
            return true;
        }

        if (node.data <= min || node.data >= max)
        {
            return false;
        }

        return (isValidBSTHelper(node.left, min, node.data) &&
                isValidBSTHelper(node.right, node.data, max));
    }

    private static boolean isValidBST(TreeNode root)
    {
        return isValidBSTHelper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        boolean result = isValidBST(root);
        System.out.println(result);
    }
}
