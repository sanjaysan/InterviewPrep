package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sanjay on 2/21/17.
 */
public class TriangleMinPathSum
{
    private static int minimumTotal(List<List<Integer>> triangle)
    {
        int [] total = new int [triangle.size()];
        int l = triangle.size() - 1;

        for (int i = 0; i < triangle.get(l).size(); i++)
        {
            total[i] = triangle.get(l).get(i);
        }
        for (int i = triangle.size() - 2; i >=0 ; i--)
        {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++)
            {
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
            }
        }
        return total[0];
    }

    public static void main (String [] args)
    {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
//        triangle.add(new ArrayList<Integer>(Arrays.asList(2)));
//        triangle.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
//        triangle.add(new ArrayList<Integer>(Arrays.asList(6, 5, 9)));
//        triangle.add(new ArrayList<Integer>(Arrays.asList(4, 4, 8, 0)));

        triangle.add(new ArrayList<Integer>(Arrays.asList(1)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(1, -1, -3)));
        int result = minimumTotal(triangle);
        System.out.println(result);
    }
}
