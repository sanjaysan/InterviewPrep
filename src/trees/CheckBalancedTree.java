package trees;

/**
 * Created by sanjay on 2/11/17.
 */
/* Java program to determine if binary tree is
   height balanced or not */

/* A binary tree node has data, pointer to left child,
   and a pointer to right child */

class CheckBalancedTree
{
    static class Node
    {
        int data;
        Node left, right;

        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    static class Height
    {
        int height;
    }

    Node root;
    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
    int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
        {
            return 0;
        }

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /* Returns true if binary tree with root as root is height-balanced */
    boolean isBalanced(Node node, Height height)
    {
        if (node == null)
        {
            height.height = 0;
            return true;
        }

        Height lheight = new Height();
        Height rheight = new Height();

        boolean l = isBalanced(node.left, lheight);
        boolean r = isBalanced(node.right, rheight);

        int lh = lheight.height;
        int rh = rheight.height;

        height.height = Math.max(lh, rh) + 1;

        if (Math.abs(lh - rh) > 1)
        {
            return false;
        }
        else
        {
            return l && r;
        }
    }

    public static void main(String args[])
    {
        Height height = new Height();
        CheckBalancedTree tree = new CheckBalancedTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

        if (tree.isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}

