import java.util.Arrays;

/**
 * Created by sanjay on 7/4/17.
 */
public class ThreeSumClosest
{
    private static int threeSumClosest(int[] nums, int target)
    {
        int result = 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if (diff < min)
                {
                    min = diff;
                    result = sum;
                }

                if (sum <= target)
                {
                    j++;
                }
                else
                {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String [] args)
    {
        int nums [] = {-1,2,1,-4};
        int result = threeSumClosest(nums, 1);
        System.out.println(result);
    }
}
