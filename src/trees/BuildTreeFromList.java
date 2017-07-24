package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sanjay on 2/24/17.
 */
public class BuildTreeFromList
{
    static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
        }
    }
    static Node root;

    private static List<Integer> storeTreeInList(Node root)
    {
        // Queue for BFS
        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        if (root != null)
        {
            queue.add(root);
        }
        while (!queue.isEmpty())
        {
            // Remove the node from the queue
            Node node = queue.remove();

            // Add the node's value to the list
            list.add(node.data);

            // Add the node's left and right children
            if (node.left != null)
            {
                queue.add(node.left);
            }
            if (node.right != null)
            {
                queue.add(node.right);
            }
        }
        return list;
    }

    private static Node buildTreeFromList(Node node, List<Integer> list, int start, int size)
    {
        // Left child : 2i + 1
        int left = (2 * start) + 1;

        // Right child: 2i + 2
        int right = (2 * start) + 2;

        // If left and right indices are greater than size of list, then traversal
        // is done, return the root
        if (left > size || right > size)
        {
            return root;
        }

        // If root is null, create a new root
        if (node == null)
        {
            node = new Node(list.get(start));
            root = node;
        }

        // If the left and right child are null, populate them by referencing the
        // array elements indexed at left and right
        if (node.left == null && node.right == null)
        {
            if (left < size)
            {
                node.left = new Node(list.get(left));
            }
            if (right < size)
            {
                node.right = new Node(list.get(right));
            }
        }

        // Recurse for left and right sub trees
        buildTreeFromList(node.left, list, left, size);
        buildTreeFromList(node.right, list, right, size);

        return root;
    }

    public static void main (String [] args)
    {
        BuildTreeFromList tree = new BuildTreeFromList();
        tree.root = new Node(0);
        tree.root.left = new Node(1);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(8);
        tree.root.left.right.left = new Node(9);

        // Storing tree in list
        System.out.print("Tree to list: ");
        List<Integer> list = storeTreeInList(tree.root);
        for (int i : list)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        tree.root = null;

        // Reconstructing the tree from the list
        buildTreeFromList(tree.root, list, 0, list.size());

        // Now tree is built. To check if it is right, store it in another
        // list and print it out
        System.out.print("List to Tree: ");
        List<Integer> list1 = storeTreeInList(tree.root);
        for (int i : list)
        {
            System.out.print(i + " ");
        }
    }
}
