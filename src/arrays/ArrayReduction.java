package arrays;

import java.util.PriorityQueue;

/**
 * Created by sanjay on 2/7/18.
 */
public class ArrayReduction
{
    private static int reductionCost(int[] num)
    {
        if (num == null || num.length == 0)
        {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < num.length; i++)
        {
            queue.add(num[i]);
        }

        int sum = 0;
        while (queue.size() > 1)
        {
            int e1 = queue.poll();
            int e2 = queue.poll();
            sum += e1 + e2;
            queue.add(e1 + e2);
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int[] arr = {5, 5, 5, 5};
        int result = reductionCost(arr);
        System.out.println(result);
    }
}
