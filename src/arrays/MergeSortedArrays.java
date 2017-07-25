package arrays;

/**
 * Created by sanjay on 7/4/17.
 */
public class MergeSortedArrays
{
    private static void merge(int A[], int m, int B[], int n)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        int [] C = new int[m + n];

        while (i < m && j < n)
        {
            if (A[i] > B[j])
            {
                C[k++] = A[i++];
            }
            else
            {
                C[k++] = B[j++];
            }
        }
        while (i < m)
        {
            C[k++] = A[i++];
        }
        while(j < n)
        {
            C[k++] = B[j++];
        }
    }
    public static void main(String [] args)
    {
        int [] A = {1, 3, 4, 5};
        int [] B = {2, 4, 6, 8};
        merge(A, A.length, B, B.length);
    }
}
