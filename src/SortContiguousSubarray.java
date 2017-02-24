import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by sanjay on 1/13/17.
 */
public class SortContiguousSubarray
{
    // you can also use imports, for example:


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

        private static int arrangeSubarray(int[] A) {
            // write your code in Java SE 8
            int start = 0, n = A.length;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int maxTemp = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; i++)
            {
                if (A[i + 1] < A[i] || A[i] < maxTemp)
                {
                    if (start == 0)
                    {
                        start = i;
                    }
                    temp.add(A[i]);
                    temp.sort (new Comparator<Integer>()
                    {
                        @Override
                        public int compare(Integer a, Integer b)
                        {
                            return a - b;
                        }
                    });
                    maxTemp = temp.get(temp.size() - 1);
                }
            }
            return temp.size();
        }
    public static void main(String [] args)
    {
        int a[] = {6,2,2};
        int result = arrangeSubarray(a);
        System.out.println(result);
    }
}
