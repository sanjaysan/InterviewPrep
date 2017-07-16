/**
 * Created by sanjay on 7/15/17.
 */
public class MinSizeSubarraySum
{
    private static int minSubArrayLen(int s, int[] nums)
    {
        int arrSize = nums.length;
        int start = 0, end = 0, sum =0, minLen = Integer.MAX_VALUE;
        while(end < arrSize)
        {
            sum = sum + nums[end++];
            if (sum >= s)
            {
                while(sum >= s && start < arrSize)
                {
                    minLen = Math.min(minLen, end - start);
                    sum = sum - nums[start++];
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    public static void main (String [] args)
    {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = minSubArrayLen(target, nums);
        System.out.println(result);
    }
}
