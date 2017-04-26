import java.io.*;
import java.util.*;

class ArrayContainer implements Comparable<ArrayContainer>
{
    int arr[];
    int index;

    public ArrayContainer(int arr[], int index)
    {
        this.arr = arr;
        this.index = index;
    }

    @Override
    public int compareTo(ArrayContainer ac)
    {
        return this.arr[this.index] - ac.arr[ac.index];
    }
}

public class MergeKSortedArrays
{
    static int[] merge(int[] sortedA, int[] sortedB, int[] sortedC)
    {
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();

        int[] result = new int[sortedA.length + sortedB.length + sortedC.length];
        queue.offer(new ArrayContainer(sortedA, 0));
        queue.offer(new ArrayContainer(sortedB, 0));
        queue.offer(new ArrayContainer(sortedC, 0));
        int i = 0;
        while (!queue.isEmpty())
        {
            ArrayContainer temp = queue.poll();
            result[i++] = temp.arr[temp.index++];
            if (temp.index < temp.arr.length)
            {
                queue.offer(new ArrayContainer(temp.arr, temp.index));
            }
        }
        return result;
    }

    public static void main(String args[]) throws Exception
    {
        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        Scanner scanner = null;
        try
        {
            int inputCount = 1;
            scanner = new Scanner(System.in);

            while (scanner.hasNextLine() && inputCount <= 3)
            {
                String str = scanner.nextLine();
                String[] tokens = str.split(" ");
                List<Integer> array = new ArrayList<Integer>(tokens.length);
                for (int i = 0; i < tokens.length; i++)
                {
                    array.add(Integer.parseInt(tokens[i]));
                }
                arrays.add(array);
                inputCount++;
            }

            for (int i = 0; i < arrays.size(); i++)
            {
                for (int j = 0; j < arrays.get(i).size(); j++)
                {
                    System.out.print(arrays.get(i).get(j) + " ");
                }
                System.out.println();
            }
            /* Enter your code here. Read input from STDIN. Print output to STDOUT */

            int[] a = new int[arrays.get(0).size()];
            for (int i = 0; i < arrays.get(0).size(); i++)
            {
                a[i] = arrays.get(0).get(i);
            }
            int[] b = new int[arrays.get(1).size()];
            for (int i = 0; i < arrays.get(1).size(); i++)
            {
                b[i] = arrays.get(1).get(i);
            }
            int[] c = new int[arrays.get(2).size()];
            for (int i = 0; i < arrays.get(2).size(); i++)
            {
                c[i] = arrays.get(2).get(i);
            }

            int[] result = merge(a, b, c);
            int i = 0;
            for (; i < result.length - 1; i++)
            {
                System.out.print(result[i] + " ");
            }
            System.out.print(result[i]);
        } finally
        {
            if (scanner != null)
            {
                scanner.close();
            }
        }
    }
}