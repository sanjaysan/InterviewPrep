package matrices;

/**
 * Created by sanjay on 9/24/17.
 */
public class EmptyRosesII
{
    private static int solution(int[] flowers, int k)
    {
        // write your code in Java SE 8
        int n = flowers.length;
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++)
        {
            result[flowers[i]] = 1;
            int l = flowers[i] - 1;
            int r = flowers[i] + 1;
            while (l >= 1)
            {
                if (result[l] == 1)
                {
                    break;
                }
                l--;
            }
            if (l >= 1 && flowers[i] - l - 1 == k)
            {
                return i + 1;
            }
            while (r <= n)
            {
                if (result[r] == 1)
                {
                    break;
                }
                r++;
            }
            if (r <= n && r - flowers[i] - 1 == k)
            {
                return i + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] P = {6, 5, 8, 9, 7, 1, 10, 2, 3, 4};
        int K = 2;
        int result = solution(P, K);
        System.out.println(result);
    }
}
