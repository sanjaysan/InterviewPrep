package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjay on 8/12/17.
 */
public class FindLeaves
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

    // Traverse the tree bottom-up recursively
    private static int findLeavesHelper(TreeNode root, List<List<Integer>> result)
    {
        if (root == null)
        {
            return -1;
        }

        int left = findLeavesHelper(root.left, result);
        int right = findLeavesHelper(root.right, result);
        int curr = Math.max(left, right) + 1;

        if (result.size() <= curr)
        {
            result.add(new ArrayList<>());
        }

        result.get(curr).add(root.val);

        return curr;
    }

    private static List<List<Integer>> findLeaves(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findLeavesHelper(root, result);
        return result;
    }

    public static void main (String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.left.left =  new TreeNode(4);
        root.left.right =  new TreeNode(5);
        root.right =  new TreeNode(3);

        List<List<Integer>> result = findLeaves(root);
        System.out.println(result);
    }
}
