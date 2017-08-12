package trees;

/**
 * Created by sanjay on 8/10/17.
 */
public class RecoverBST
{
    static TreeNode pre;
    static TreeNode first;
    static TreeNode second;

    static class TreeNode
    {
        int val;
        TreeNode left, right;

        TreeNode(int item)
        {
            val = item;
        }
    }

    private static void inorder(TreeNode root)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left);

        if (pre == null)
        {
            pre = root;
        }
        else
        {
            if (root.val < pre.val)
            {
                if (first == null)
                {
                    first = pre;
                }
                second = root;
            }
            pre = root;
        }

        inorder(root.right);
    }

    private static void recoverTree(TreeNode root)
    {
        if (root == null)
        {
            return;
        }

        inorder(root);
        if (first != null && second != null)
        {
            int val = first.val;
            first.val = second.val;
            second.val = val;
        }
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);

        recoverTree(root);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
