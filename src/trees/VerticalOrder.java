package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by sanjay on 10/7/17.
 */
public class VerticalOrder
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

    private static void verticalOrderHelper(TreeNode node, int hd, TreeMap<Integer, List<Integer>> map)
    {
        if (node == null)
        {
            return;
        }

        if (map.containsKey(hd))
        {
            map.get(hd).add(node.data);
        }
        else
        {
            List<Integer> list = new ArrayList<>();
            list.add(node.data);
            map.put(hd, list);
        }

        verticalOrderHelper(node.left, hd - 1, map);
        verticalOrderHelper(node.right, hd + 1, map);
    }

    private static List<List<Integer>> verticalOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        if (root == null)
        {
            return result;
        }

        // Horizontal distance from root
        int hd = 0;
        verticalOrderHelper(root, hd, map);

        result.addAll(map.values());

        return result;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        List<List<Integer>> result = verticalOrder(root);
        for (List<Integer> l : result)
        {
            System.out.println(l.toString());
        }
    }
}
