package trees; /**
 * Created by sanjay on 1/9/17.
 */
import java.util.Stack;
public class KthSmallestElBST
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

    private int findKthSmallestElement(Node root, int k)
    {
        Stack<Node> stack = new Stack<Node>();
        Node p = root;
        int result = 0;

        while (!stack.isEmpty() || p != null)
        {
            if (p != null)
            {
                stack.push(p);
                p = p.left;
            }
            else
            {
                Node t = stack.pop();
                k--;
                if (k == 0)
                {
                    result = t.data;
                }
                p = t.right;
            }
        }
        return result;
    }
    private void findLongestConsecutiveSeq(Node root, int currLength, int expected, int [] res)
    {
        if (root == null)
        {
            return;
        }

        if (root.data == expected)
        {
            currLength++;
        }
        else
        {
            currLength = 1;
        }

        res[0] = Math.max(currLength, res[0]);
        findLongestConsecutiveSeq(root.left, currLength, root.data + 1, res);
        findLongestConsecutiveSeq(root.right, currLength, root.data + 1, res);
    }

    private int findLongest(Node root)
    {
        if (root == null)
        {
            return 0;
        }
        int res [] = new int[1];
        res[0] = 0;
        findLongestConsecutiveSeq(root, 0, root.data, res);
        return res[0];
    }
    public static void main(String[] args)
    {
        KthSmallestElBST tree = new KthSmallestElBST();

        tree.root = new Node(6);
        tree.root.right = new Node(9);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(10);
        tree.root.right.right.right = new Node(11);
        //int result = tree.findKthSmallestElement(tree.root, 3);
        int lcp = tree.findLongest(tree.root);
        System.out.println(lcp);
    }
}
