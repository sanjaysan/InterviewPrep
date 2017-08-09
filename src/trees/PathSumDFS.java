package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjay on 7/31/17.
 */
public class PathSumDFS
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

    private static void dfs(TreeNode node, int sum, List<Integer> pathList, List<List<Integer>> result)
    {
        if ((node.left == null && node.right == null) && node.val == sum)
        {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(pathList);
            result.add(temp);
        }

        if (node.left != null)
        {
            pathList.add(node.left.val);
            dfs(node.left, (sum - node.val), pathList, result);
            pathList.remove(pathList.size() - 1);
        }

        if (node.right != null)
        {
            pathList.add(node.right.val);
            dfs(node.right, (sum - node.val), pathList, result);
            pathList.remove(pathList.size() - 1);
        }
    }

    private static List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null)
        {
            return result;
        }

        ArrayList<Integer> pathList = new ArrayList<Integer>();
        pathList.add(root.val);
        dfs(root, sum, pathList, result);
        return result;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> result = pathSum(root, 22);
        System.out.println(result);
    }
}
