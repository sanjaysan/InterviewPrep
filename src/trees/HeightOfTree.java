package trees;

/**
 * Created by sanjay on 1/7/17.
 */
// Java program to find height of tree

// A binary tree node

class HeightOfTree
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

    /* Compute the "maxDepth" of a tree -- the number of
       nodes along the longest path from the root node
       down to the farthest leaf node.*/
    int maxDepth(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    private void InorderTraversal(Node root)
    {
        if (root != null)
        {
            System.out.println(root.data);
            if (root.left != null)
            {
                InorderTraversal(root.left);
            }
            if (root.right != null)
            {
                InorderTraversal(root.right);
            }
        }
    }
    /* Print nodes at the given level */
    private void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    private void printLevelOrder()
    {
        int h = maxDepth(root);
        int i;
        for (i=h; i>=1; i--)
            printGivenLevel(root, i);
    }

    private Node invertBinaryTree(Node root)
    {
        if (root != null)
        {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;

            if (root.left != null)
            {
                invertBinaryTree(root.left);
            }

            if (root.right != null)
            {
                invertBinaryTree(root.right);
            }
        }
        return root;
    }

    private void inOrderTraversal(Node root)
    {
        if (root != null)
        {
            if (root.left != null)
            {
                inOrderTraversal(root.left);
            }
            System.out.println(root.data);
            if (root.right != null)
            {
                inOrderTraversal(root.right);
            }
        }
    }

    /* Driver program to testabove functions */
    public static void main(String[] args)
    {
        HeightOfTree tree = new HeightOfTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
//        tree.printLevelOrder();
//        tree.InorderTraversal(tree.root);
//        System.out.println("Height of tree is : " +
//                tree.maxDepth(tree.root));
        tree.root = tree.invertBinaryTree(tree.root);
        tree.inOrderTraversal(tree.root);
    }
}