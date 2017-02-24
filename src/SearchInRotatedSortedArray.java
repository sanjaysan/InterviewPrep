/**
 * Created by sanjay on 1/29/17.
 */
public class SearchInRotatedSortedArray
{
    private static int search (int [] nums, int left, int right, int target)
    {
        if (left > right)
        {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target)
        {
            return mid;
        }

        // If left half is sorted
        if (nums[left] <= nums[mid])
        {
            if (target >= nums[left] && target <= nums[mid])
            {
                return search(nums, left, mid - 1, target);
            }
            return search(nums, mid + 1, right, target);
        }
        else //right half is sorted
        {
            if (target >= nums[mid] && target <= nums[right])
            {
                return search(nums, mid + 1, right, target);
            }
            return search(nums, left, mid - 1, target);
        }
    }
    public static void main(String [] args)
    {
        int nums[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int length = nums.length;
        int target = 6;
        int result = search(nums, 0 , length - 1, target);
        System.out.println(result);
    }
}
