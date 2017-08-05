package trees;

/**
 * Created by sanjay on 2/11/17.
 */

class CheckBalancedTree
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

    static class Height
    {
        int height;
    }

    private static boolean isBalancedHelper(TreeNode root, Height height)
    {
        if (root == null)
        {
            return true;
        }

        Height lHeight = new Height();
        Height rHeight = new Height();

        boolean isLSubTreeBalanced = isBalancedHelper(root.left, lHeight);
        boolean isRSubTreeBalanced = isBalancedHelper(root.right, rHeight);

        int lSubTreeHeight = lHeight.height;
        int rSubTreeHeight = rHeight.height;

        height.height = Math.max(lSubTreeHeight, rSubTreeHeight) + 1;

        if (Math.abs(lSubTreeHeight - rSubTreeHeight) > 1)
        {
            return false;
        }
        return (isLSubTreeBalanced && isRSubTreeBalanced);
    }

    private static boolean isBalanced(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        Height height = new Height();
        return isBalancedHelper(root, height);
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);

        if (isBalanced(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}

