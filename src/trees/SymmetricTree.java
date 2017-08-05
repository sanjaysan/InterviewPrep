package trees;

/**
 * Created by sanjay on 8/4/17.
 */
public class SymmetricTree
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

    private static boolean isSymmetrichelper(TreeNode l, TreeNode r)
    {
        if (l == null && r == null)
        {
            return true;
        }

        if (l == null || r == null)
        {
            return false;
        }

        if (l.val != r.val)
        {
            return false;
        }

        if (!isSymmetrichelper(l.left, r.right) || !isSymmetrichelper(l.right, r.left))
        {
            return false;
        }

        return true;
    }

    private static boolean isSymmetric(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        return isSymmetrichelper(root.left, root.right);
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = isSymmetric(root);
        System.out.println(result);
    }
}
