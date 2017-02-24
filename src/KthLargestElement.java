import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by sanjay on 12/24/16.
 */
public class KthLargestElement
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        int nums[] = {3,2,1,5,6,4};
        int k = input.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i : nums)
        {
            q.offer(i);
            if (q.size() > k)
            {
                q.poll();
            }
        }
        System.out.println(q.peek());
    }
}
