package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjay on 1/11/17.
 */
public class RootLeafPaths
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

    private static void binaryTreePathsHelper(TreeNode root, List<String> rootLeafPaths, StringBuilder sb)
    {
        sb.append(String.valueOf(root.val));

        if (root.left == null && root.right == null)
        {
            rootLeafPaths.add(sb.toString());
            return;
        }

        if (root.left != null)
        {
            sb.append("->");
            binaryTreePathsHelper(root.left, rootLeafPaths, sb);
            int length = sb.lastIndexOf("->");
            sb.setLength(length);

        }
        if (root.right != null)
        {
            sb.append("->");
            binaryTreePathsHelper(root.right, rootLeafPaths, sb);
            int length = sb.lastIndexOf("->");
            sb.setLength(length);
        }
    }

    private static List<String> binaryTreePaths(TreeNode root)
    {
        List<String> paths = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        if (root == null)
        {
            return paths;
        }
        binaryTreePathsHelper(root, paths, sb);
        return paths;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        List<String> result = binaryTreePaths(root);
        System.out.println(result);
    }
}
