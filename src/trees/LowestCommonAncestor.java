package trees;

/**
 * Created by sanjay on 8/5/17.
 */
public class LowestCommonAncestor
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

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)
        {
            return null;
        }

        if (root.val < p.val && root.val < q.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }

        else if (root.val > p.val && root.val > q.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    public static void main (String[] args)
    {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        root.right = new TreeNode(22);
        TreeNode result = lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(result.val);
    }
}
