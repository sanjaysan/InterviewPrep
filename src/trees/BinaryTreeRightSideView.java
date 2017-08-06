package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjay on 8/5/17.
 */
public class BinaryTreeRightSideView
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

    static class Level
    {
        int level;
    }

    private static void rightSideViewHelper(TreeNode root, int level, Level maxLevel, List<Integer> res)
    {
        if (root == null)
        {
            return;
        }

        if (level > maxLevel.level)
        {
            res.add(root.val);
            maxLevel.level = level;
        }

        rightSideViewHelper(root.right, level + 1, maxLevel, res);
        rightSideViewHelper(root.left, level + 1, maxLevel, res);
    }

    private static List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
        {
            return result;
        }

        Level maxLevel = new Level();
        maxLevel.level = 0;

        rightSideViewHelper(root, 1, maxLevel, result);
        return result;
    }

    public static void main (String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        List<Integer> result = rightSideView(root);
        System.out.println(result);
    }
}
