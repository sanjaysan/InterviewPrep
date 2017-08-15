package dp;

/**
 * Created by sanjay on 8/14/17.
 */
public class EditDistance
{
    private int minDistance(String word1, String word2)
    {
        int m = word1.length();
        int n = word2.length();

        int[][] result = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0)
                {
                    result[i][j] = j;
                }

                else if (j == 0)
                {
                    result[i][j] = i;
                }

                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                {
                    result[i][j] = result[i - 1][j - 1];
                }

                else
                {
                    result[i][j] = 1 + Math.min(result[i][j - 1],Math.min(result[i - 1][j - 1], result[i - 1][j]));
                }
            }
        }
        return result[m][n];
    }

    public static void main (String[] args)
    {
        String word1 = "sunday";
        String word2 = "saturday";

        EditDistance ed = new EditDistance();
        int result = ed.minDistance(word1, word2);
        System.out.println(result);
    }
}
