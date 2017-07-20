import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence
{
    private static int longestConsecutive(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int max = 1;

        for (int val: nums)
        {
            set.add(val);
        }

        for (int val: nums)
        {
            int prev = val - 1;
            int next = val + 1;
            int count = 1;

            while (set.contains(prev))
            {
                count++;
                set.remove(prev);
                prev--;
            }

            while (set.contains(next))
            {
                count++;
                set.remove(next);
                next++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main (String[] args)
    {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(nums);
        System.out.println(result);
    }
}
