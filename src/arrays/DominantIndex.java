package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by sanjay on 12/23/17.
 */
public class DominantIndex
{
    private static int dominantIndex(int[] nums)
    {
        int max = Collections.max(Arrays.stream(nums).mapToObj(Integer::new).collect(Collectors.toList()));
        int index = -1;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != max && max >= (2 * nums[i]))
            {
                continue;
            }
            else if (nums[i] == max)
            {
                index = i;
            }
            else
            {
                index = -1;
                break;
            }
        }
        return index;
    }
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4};
        int result = dominantIndex(nums);
        System.out.println(result);
    }
}
