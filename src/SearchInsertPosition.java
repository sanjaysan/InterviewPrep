/**
 * Created by sanjay on 7/17/17.
 */
public class SearchInsertPosition
{
    private static int searchInsert(int[] nums, int target)
    {
        if (nums == null || nums.length == 0)
        {
            return -1;
        }
        if (target > nums[nums.length - 1])
        {
            return nums.length;
        }

        int i = 0, j = nums.length - 1;
        while (i < j)
        {
            int mid = (i + j) / 2;
            if (target > nums[mid])
            {
                i = mid + 1;
            }
            else
            {
                j = mid;
            }
        }
        return j;
    }
    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int result = searchInsert(nums, target);
        System.out.println(result);
    }
}
