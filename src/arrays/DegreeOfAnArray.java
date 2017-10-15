package arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanjay on 10/14/17.
 */
class Tuple
{
    int count;
    int index;

    Tuple(int count, int index)
    {
        this.count = count;
        this.index = index;
    }

}

public class DegreeOfAnArray
{
    private static int findShortestSubArray(int[] nums)
    {
        Map<Integer, Tuple> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                map.put(nums[i], new Tuple(map.get(nums[i]).count + 1, i));
            }
            else
            {
                map.put(nums[i], new Tuple(1, i));
            }
        }
        Integer arrayDegree = map.entrySet()
                                 .stream()
                                 .map(e -> e.getValue().count)
                                 .max(Comparator.naturalOrder())
                                 .map(Integer::new)
                                 .orElseThrow(() -> new RuntimeException("No value"));

        int minLength = Integer.MAX_VALUE, length = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (map.get(nums[i]).count == arrayDegree.intValue())
            {
                length = map.get(nums[i]).index - i + 1;
                if (length < minLength)
                {
                    minLength = length;
                    int count = map.get(nums[i]).count;
                    int index = map.get(nums[i]).index;
                    count--;
                    map.put(nums[i], new Tuple(count, index));
                }
                else
                {
                    int count = map.get(nums[i]).count;
                    int index = map.get(nums[i]).index;
                    count--;
                    map.put(nums[i], new Tuple(count, index));
                }

            }
        }
        return minLength;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2};
        int result = findShortestSubArray(arr);
        System.out.println(result);
    }
}
