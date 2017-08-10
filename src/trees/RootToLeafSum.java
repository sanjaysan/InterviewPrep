package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjay on 8/7/17.
 */
public class RootToLeafSum
{
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int item)
        {
            this.val = item;
        }
    }

    private static void dfs(TreeNode root, List<Integer> pathList, List<List<Integer>> result)
    {
        if (root.left == null && root.right == null)
        {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(pathList);
            result.add(temp);
        }

        if (root.left != null)
        {
            pathList.add(root.left.val);
            dfs(root.left, pathList, result);
            pathList.remove(pathList.size() - 1);
        }

        if (root.right != null)
        {
            pathList.add(root.right.val);
            dfs(root.right, pathList, result);
            pathList.remove(pathList.size() - 1);
        }
    }

    private static int sumNumbers(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        List<Integer> pathList = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        pathList.add(root.val);

        dfs(root, pathList, result);

        int sum = 0;
        for (List<Integer> path: result)
        {
            int n = path.size() - 1;
            for (int val: path)
            {
                sum += val * Math.pow(10, n--);
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(1);

        int result = sumNumbers(root);
        System.out.println(result);
    }
}
