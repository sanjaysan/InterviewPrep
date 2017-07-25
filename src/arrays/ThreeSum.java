package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sanjay on 4/25/17.
 */
public class ThreeSum
{
    private static List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = n - 1; i >= 2; i--)
        {
            List<Integer> triplets = new ArrayList<Integer>();
            int l = 0;
            int r = i - 1;
            while (l < r)
            {
                if ((nums[i] + nums[l] + nums[r]) == 0)
                {
                    triplets.add(nums[i]);
                    triplets.add(nums[l]);
                    triplets.add(nums[r]);
                    result.add(triplets);
                    //triplets.clear();
                } else if ((nums[i] + nums[l] + nums[r]) > 0)
                {
                    r--;
                } else
                {
                    l++;
                }
            }
        }
        return result;
    }
    public static void main(String [] args)
    {
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        for (List l : result)
        {
            System.out.println(l);
        }
    }
}