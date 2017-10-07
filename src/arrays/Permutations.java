package arrays;

import java.util.Arrays;

/**
 * Created by sanjay on 10/6/17.
 */
public class Permutations
{
    void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void heapPermutation(int[] arr, int size, int n)
    {
        if (size == 1)
        {
            Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
            System.out.println();
        }

        for (int i = 0; i < size; i++)
        {
            heapPermutation(arr, size - 1, n);

            if (size % 2 == 1)
            {
                swap(arr, 0, size - 1);
            }
            else
            {
                swap(arr, i, size - 1);
            }
        }
    }

    public static void main(String args[])
    {
        Permutations obj = new Permutations();
        int a[] = {1,2,3};
        obj.heapPermutation(a, a.length, a.length);
    }
}
