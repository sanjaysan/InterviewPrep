package arrays;

import com.sun.xml.internal.bind.v2.util.StackRecorder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by sanjay on 10/10/17.
 */
public class DotProduct
{
    private static int dotProduct(int[] x, int[] y)
    {
        if (x == null || y == null || x.length != y.length)
        {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < x.length; i++)
        {
            sum += x[i] * y[i];
        }
        return sum;
    }

    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        int xLength = input.nextInt();
        int[] x = new int[xLength];
        for (int i = 0; i < xLength; i++)
        {
            x[i] = input.nextInt();
        }

        int yLength = input.nextInt();
        int[] y = new int[yLength];
        for (int i = 0; i < yLength; i++)
        {
            y[i] = input.nextInt();
        }

        int result = dotProduct(x, y);
        System.out.println(result);
    }
}
