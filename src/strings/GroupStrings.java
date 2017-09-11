package strings;

/**
 * Created by sanjay on 9/10/17.
 */
class GroupStrings
{
    private static String groupString(String S, int K)
    {
        // write your code in Java SE 8

        if (K == 1 && S.length() == 1)
        {
            return S.toUpperCase();
        }

        int n = S.length() - 1;

        String result = "";
        int j = 0;
        for (int i = n; i >= 0; i--)
        {
            if (S.charAt(i) != '-' && j < K)
            {
                result = Character.toUpperCase(S.charAt(i)) + result;
                j++;
            }
            if (S.charAt(i) == '-')
            {
                continue;
            }
            if (j == K && i > 0)
            {
                result = '-' + result;
                j = 0;
            }
        }
        return result;
    }

    public static void main (String[] args)
    {
        String S = "2-4sdeg-2dgwas";
        int K = 4;
        String result = groupString(S, K);
        System.out.println(result);
    }
}
