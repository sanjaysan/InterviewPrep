package dp;

/**
 * Created by sanjay on 8/14/17.
 */
public class DistinctSubsequencesTotal
{
    private int numDistincts(String s, String t)
    {
        int m = t.length();
        int n = s.length();

        int[][] result = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
        {
            result[i][0] = 0;
        }

        for (int j = 0; j <= n; j++)
        {
            result[0][j] = 1;
        }

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (t.charAt(i - 1) == s.charAt(j - 1))
                {
                    result[i][j] = result[i][j - 1] + result[i - 1][j - 1];
                }
                else
                {
                    result[i][j] = result[i][j - 1];
                }
            }
        }
        return result[m][n];
    }

    public static void main (String[] args)
    {
        String s = "banana";
        String t = "ban";

        DistinctSubsequencesTotal dst = new DistinctSubsequencesTotal();

        int res = dst.numDistincts(s, t);
        System.out.println(res);
    }
}
