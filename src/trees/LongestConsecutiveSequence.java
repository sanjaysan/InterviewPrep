package trees;

/**
 * Created by sanjay on 7/30/17.
 */
public class LongestConsecutiveSequence
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

    private static int longestConsecutiveHelper(TreeNode root, int curLength, int expected)
    {
        if (root == null)
        {
            return 0;
        }

        if (root.data == expected)
        {
            curLength++;
        }
        else
        {
            curLength = 1;
        }

        int leftLength = longestConsecutiveHelper(root.left, curLength, root.data + 1);
        int rightLength = longestConsecutiveHelper(root.right, curLength, root.data + 1);

        return Math.max(curLength, Math.max(leftLength, rightLength));
    }

    private static int longestConsecutive(TreeNode root)
    {
        return longestConsecutiveHelper(root, 0, root.data);
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(6);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);
        root.right.right.right = new TreeNode(11);
        int result = longestConsecutive(root);
        System.out.println(result);
    }
}
