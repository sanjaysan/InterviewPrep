package matrices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjay on 9/10/17.
 */
class EmptyRoses
{
    private static int solution(int[] P, int K)
    {
        // write your code in Java SE 8
        int n = P.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++)
        {
            int j = P[i];
            result[i][j - 1] = 1;
            for (int k = i + 1; k < n; k++)
            {
                result[k][j - 1] = 1;
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < result.length; i++)
        {
            int count = 0;
            for (int j = 0; j < result[0].length; j++)
            {
                if (result[i][j] == 0)
                {
                    count++;
                }
                else if (result[i][j] != 0 && count == K)
                {
                    return i + 1;
                }
                else if (result[i][j] != 0 && count < K)
                {
                    count = 0;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] P = {2, 5, 1, 4, 3};
        int K = 2;
        int result = solution(P, K);
        System.out.println(result);
    }
}
