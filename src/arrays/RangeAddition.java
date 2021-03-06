package arrays;

import java.util.Arrays;

/**
 * Created by sanjay on 8/13/17.
 */
public class RangeAddition
{
    private static int[] getModifiedArray(int length, int[][] updates)
    {
        int[] result = new int[length];
        if (updates == null || updates.length == 0)
        {
            return result;
        }

        for (int i = 0; i < updates.length; i++)
        {
            result[updates[i][0]] += updates[i][2];
            if (updates[i][1] < length - 1)
            {
                result[updates[i][1] + 1] -= updates[i][2];
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++)
        {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[][] updates = {
                {3, 6, 1},
                {7, 9, 2}
        };
        int[] result = getModifiedArray(10, updates);
        System.out.println(Arrays.toString(result));
    }
}
