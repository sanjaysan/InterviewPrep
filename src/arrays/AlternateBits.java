package arrays;

/**
 * Created by sanjay on 10/7/17.
 */
public class AlternateBits
{
    private static boolean hasAlternatingBits(int n)
    {
        if (n == 0)
        {
            return false;
        }

        int prev = n % 2;
        n /= 2;

        while (n > 0)
        {
            int curr = n % 2;
            n /= 2;

            if (prev == curr)
            {
                return false;
            }
            prev = curr;
        }
        return true;
    }

    public static void main(String[] args)
    {
        int n = 1;
        boolean result = hasAlternatingBits(n);
        System.out.println(result);
    }
}

