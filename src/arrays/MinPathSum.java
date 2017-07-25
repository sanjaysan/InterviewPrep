package arrays; /**
 * Created by sanjay on 12/26/16.
 */
/* Java program for Dynamic Programming implementation
of Min Cost Path problem */
import java.util.*;

class MinPathSum
{
    /* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }

    public static int minPathSum(int[][] cost, int m, int n)
    {
        if(cost == null || cost.length == 0)
        {
            return 0;
        }

        int tc [][] = new int [m + 1][n + 1];
        tc[0][0] = cost[0][0];

        for (int i = 1; i <= m; i++)
        {
            tc[i][0] = tc[i - 1][0] + cost[i][0];
        }
        for (int j = 1; j <= n; j++)
        {
            tc[0][j] = tc[0][j - 1] + cost[0][j];
        }
        // fill up the tc table
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                tc[i][j] = min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]) + cost[i][j];
            }
        }
        return tc[m][n];
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        System.out.println("minimum cost to reach (2,2) = " + minPathSum(cost,2,2));
    }
}