package strings;

/**
 * Created by sanjay on 11/28/17.
 */

class RepeatedStringMatch
{
    private static int repeatedStringMatch(String A, String B)
    {
        if (B == null || B.isEmpty())
        {
            return -1;
        }

        String C = "";
        int count = 0;
        while (!C.contains(B))
        {
            C += A;
            count++;
            if (C.length() > (B.length() + A.length()) && !C.contains(B))
            {
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        String A = "abababaaba";
        String B = "aabaaba";
        int result = repeatedStringMatch(A, B);
        System.out.println(result);
    }
}
