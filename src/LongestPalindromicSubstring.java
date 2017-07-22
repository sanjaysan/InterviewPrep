/**
 * Created by sanjay on 07/21/17.
 */
public class LongestPalindromicSubstring
{
    private static String longestPalindrome(String s)
    {
        int n = s.length();
        boolean L[][] = new boolean[n][n];

        for (int i = 0; i < n; i++)
        {
            L[i][i] = true;
        }

        int start = 0, maxLength = 1;

        // Length 2 substrings
        for (int i = 0; i < n - 1; i++)
        {
            if (s.charAt(i) == s.charAt(i + 1))
            {
                L[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Length > 2 substrings
        for (int k = 3; k <= n; k++)
        {
            for (int i = 0 ; i < n - k + 1; i++)
            {
                int j = i + k - 1;

                if (L[i + 1][j - 1] && s.charAt(i) == s.charAt(j))
                {
                    L[i][j] = true;

                    if (k > maxLength)
                    {
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
    public static void main (String[] args)
    {
        String s = "forgeekskeegfor";
        String result = longestPalindrome(s);
        System.out.println(result);
    }
}
