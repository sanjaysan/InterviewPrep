/**
 * Created by sanjay on 1/10/17.
 */
public class TreePathSum
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

    private boolean hasPathSum(Node node, int sum)
    {
        if (node == null)
        {
            return false;
        }
        if (node.data == sum && node.left == null && node.right == null)
        {
            return true;
        }
        return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
    }

    public static void main(String[] args)
    {
        TreePathSum tree = new TreePathSum();

        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right = new Node(2);
        tree.root.right.right = new Node(2);
        //int result = tree.findKthSmallestElement(tree.root, 3);
        boolean result = tree.hasPathSum(tree.root, 23);
        System.out.println(result);
    }
}
