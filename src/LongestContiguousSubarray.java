import java.util.Arrays;

/**
 * Created by sanjay on 2/3/17.
 */
public class LongestContiguousSubarray
{

    private static int findLengthOfLongestContiguousSubarray(int [] a)
    {
        Arrays.sort(a);
        int length = a.length, temp = Integer.MIN_VALUE;
        int count = 1, max = 1;
        for (int i = 0; i < length - 1; i++)
        {
            if (a[i] == a[i + 1])
            {
                temp = a[i];
                continue;
            }
            if (temp != a[i] && a[i] + 1 == a[i + 1])
            {
                count++;
                max = Math.max(count, max);
            }
            else
            {
                count = 1;
            }
        }
        return max;
    }
    public static void main (String [] args)
    {
        //int [] a = {10, 12, 12, 10, 10, 11, 10};  // with duplicates
        int [] a = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};  // without duplicates
        int result = findLengthOfLongestContiguousSubarray(a);
        System.out.println(result);
    }
}
