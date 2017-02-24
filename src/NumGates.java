import java.util.Arrays;

/**
 * Created by sanjay on 1/12/17.
 */
public class NumGates
{
    static int findMinGates(int[] arrivals, int[] departures, int flights)
    {
        int i = 0, j = 0, result = 1, gates = 1;
        Arrays.sort(arrivals);
        Arrays.sort(departures);
        while (i < arrivals.length && j < arrivals.length)
        {
            if (arrivals[i] < departures[j])
            {
                gates++;
                i++;
                if (gates > result)
                {
                    result = gates;
                }
            }
            else
            {
                gates--;
                j++;
            }
        }
        return result;
    }
    public static void main(String [] args)
    {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int flights = 6;
        int result = findMinGates(arr, dep,flights);
        System.out.println(result);
    }
}
