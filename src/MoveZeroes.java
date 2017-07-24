import java.util.Arrays;

/**
 * Created by sanjay on 7/23/17.
 */
public class MoveZeroes
{
    private static void moveZeroes(int[] nums)
    {
        int zeroIndex = 0, nonZeroIndex = 0;
        int n = nums.length;

        while (zeroIndex < n || nonZeroIndex < n)
        {
            if (nums[zeroIndex] != 0)
            {
                zeroIndex++;
            }

            if (nums[nonZeroIndex] == 0)
            {
                nonZeroIndex++;
            }

            if (nonZeroIndex <= zeroIndex)
            {
                while (nonZeroIndex <= zeroIndex && nonZeroIndex < n)
                {
                    nonZeroIndex++;
                }
            }

            if (zeroIndex >= n || nonZeroIndex >= n)
            {
                break;
            }

            if (nums[zeroIndex] == 0 && nums[nonZeroIndex] != 0)
            {
                int temp = nums[zeroIndex];
                nums[zeroIndex] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;
            }
        }
    }

    public static void main (String[] args)
    {
        int[] nums = {1, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}


/**/