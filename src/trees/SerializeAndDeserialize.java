package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sanjay on 10/10/17.
 */
public class SerializeAndDeserialize
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

    private static String serialize(TreeNode root)
    {
        if (root == null)
        {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty())
        {
            TreeNode front = queue.poll();

            if (front != null)
            {
                sb.append(String.valueOf(front.val) + ",");
                queue.add(front.left);
                queue.add(front.right);
            }
            else
            {
                sb.append("#,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static TreeNode deserialize(String data)
    {
        if (data == null || data.length() == 0)
        {
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty())
        {
            TreeNode front = queue.poll();
            if (front == null)
            {
                continue;
            }

            if (!arr[i].equals("#"))
            {
                front.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(front.left);
            }
            else
            {
                front.left = null;
                queue.add(null);
            }
            i++;

            if (!arr[i].equals("#"))
            {
                front.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(front.right);
            }
            else
            {
                front.right = null;
                queue.add(null);
            }
            i++;
        }
        return root;
    }
    private static void inorder(TreeNode root)
    {
        if (root != null)
        {
            if (root.left != null)
            {
                inorder(root.left);
            }

            System.out.print(root.val + " ");

            if (root.right != null)
            {
                inorder(root.right);
            }
        }
    }

    public static void main (String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        String result = serialize(root);
        System.out.println(result);

        TreeNode newRoot = deserialize(result);
        inorder(newRoot);
    }
}
