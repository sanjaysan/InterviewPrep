package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjay on 1/11/17.
 */
public class RootLeafPaths
{

    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    Node root;

    private void printPaths(List<Integer> path)
    {
        for (int a : path)
        {
            System.out.print(a + " ");
        }
        System.out.println();
    }
    private void printRootLeafPaths(Node node, List<Integer> path)
    {
        if ( node == null )
        {
            return;
        }
        path.add(node.data);
        if ( node.left == null && node.right == null)
        {
            printPaths(path);
        }

        if (node.left != null)
        {
            printRootLeafPaths(node.left, path);
            path.remove(path.size() - 1);
        }

        if (node.right != null)
        {
            printRootLeafPaths(node.right, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        RootLeafPaths tree = new RootLeafPaths();

        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right = new Node(2);
        tree.root.right.left = new Node(2);
        tree.printRootLeafPaths(tree.root, new ArrayList<Integer>());
    }
}
