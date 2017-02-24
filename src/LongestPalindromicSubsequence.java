/**
 * Created by sanjay on 1/3/17.
 */
public class LongestPalindromicSubsequence
{
    private int max(int x, int y)
    {
        return (x > y) ? x : y;
    }
    private int calculateLps(String str)
    {
        int i, j, cl;
        int n = str.length();
        int L[][] = new int[n][n];

        for (i = 0; i < n; i++)
        {
            L[i][i] = 1;
        }

        for (cl = 2; cl <= n; cl++)
        {
            for (i = 0; i < n - cl + 1; i++)
            {
                j = i + cl - 1;
//                if (str.charAt(i) == str.charAt(j) && cl == 2)
//                {
//                    L[i][j] = 2;
//                }
                if (str.charAt(i) == str.charAt(j))
                {
                    L[i][j] = 2 + L[i + 1][j - 1];
                }
                else
                {
                    L[i][j] = max (L[i + 1][j], L[i][j - 1]);
                }
            }
        }
        return L[0][n - 1];
    }

    public static void main(String [] args)
    {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "abgdba";
        int length = lps.calculateLps(str);
        System.out.println(length);
    }
}
