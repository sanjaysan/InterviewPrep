package arrays;

import java.util.ArrayList;

/**
 * Created by sanjay on 1/28/17.
 */
public class PascalsTriangle
{
    private static ArrayList<ArrayList<Integer>> generate(int numRows)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0)
        {
            return result;
        }

        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);

        for (int i = 2; i <= numRows; i++)
        {
            ArrayList<Integer> cur = new ArrayList<Integer>();

            cur.add(1);
            for (int j = 0; j < pre.size() - 1; j++)
            {
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            cur.add(1);
            result.add(cur);
            pre = cur;
        }
        return result;
    }

    private static ArrayList<Integer> generateNthRow(int rowIndex)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0)
        {
            return result;
        }
        result.add(1);
        for (int i = 1; i <= rowIndex; i++)
        {
            for (int j = result.size() - 2; j >= 0; j--)
            {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }
    public static void main(String [] args)
    {
        int numRows = 5;
        /*ArrayList<ArrayList<Integer>> result = generate(numRows);
        int spaces = numRows - 1 ;
        for (ArrayList<Integer> a : result)
        {
            for (int j = spaces; j > 0 ; j--)
            {
                System.out.print(" ");
            }
            spaces--;
            for (int i = 0; i < a.size(); i++)
            {
                System.out.print(a.get(i) + " ");
            }
            System.out.println();
        }*/
        ArrayList<Integer> result = generateNthRow(2);
        System.out.println(result);
    }
}
