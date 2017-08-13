package trees;

/**
 * Created by sanjay on 8/12/17.
 */
public class LargestBSTSubtree
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

    static class Wrapper
    {
        int size;
        int lower, upper;
        boolean isBST;

        Wrapper()
        {
            size = 0;
            lower = Integer.MAX_VALUE;
            upper = Integer.MIN_VALUE;
            isBST = false;
        }
    }

    private static Wrapper largestBSTSubtreeHelper(TreeNode root)
    {
        Wrapper curr = new Wrapper();

        if (root == null)
        {
            curr.isBST = true;
            return curr;
        }

        Wrapper l = largestBSTSubtreeHelper(root.left);
        Wrapper r = largestBSTSubtreeHelper(root.right);

        curr.lower = Math.min(root.val, l.lower);
        curr.upper = Math.max(root.val, r.upper);

        if (l.isBST && r.isBST && l.upper <= root.val && r.lower >= root.val)
        {
            curr.size = l.size + r.size + 1;
            curr.isBST = true;
        }
        else
        {
            curr.size = Math.max(l.size, r.size);
            curr.isBST = false;
        }

        return curr;
    }

    private static int largestBSTSubtree(TreeNode root)
    {
        return largestBSTSubtreeHelper(root).size;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        int result = largestBSTSubtree(root);
        System.out.println(result);
    }
}
