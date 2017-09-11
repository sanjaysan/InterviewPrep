package arrays;

import java.util.Arrays;

/**
 * Created by sanjay on 9/1/17.
 */
public class LargestNumber
{
    private static String largestNumber(int[] nums)
    {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (String a, String b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s: arr)
        {
            sb.append(s);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1)
        {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main (String[] args)
    {
        int[] nums = {3, 30, 34, 5, 9};
        String result = largestNumber(nums);
        System.out.println(result);
    }
}
