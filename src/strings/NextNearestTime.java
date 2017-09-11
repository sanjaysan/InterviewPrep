package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanjay on 9/10/17.
 */
public class NextNearestTime
{
    private static int findNextMax(int val, Set<Integer> set)
    {
        for (Integer num: set)
        {
            if (num > val)
            {
                return num;
            }
        }
        return -1;
    }
    private static int findMin(Set<Integer> set)
    {
        int min = Integer.MAX_VALUE;
        for (Integer num: set)
        {
            if (num < min)
            {
                min = num;
            }
        }
        return min;
    }
    private static String solution(String S)
    {
        S = S.replaceAll(":", "");
        char[] time = S.toCharArray();

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < time.length; i++)
        {
            set.add(Character.getNumericValue(time[i]));
        }

        for (int i = time.length - 1; i >= 0; i--)
        {
            int val = Character.getNumericValue(time[i]);
            int nextMax = findNextMax(val, set);
            if (nextMax != -1)
            {
                time[i] = Character.forDigit(nextMax, 10);
                if (i != time.length - 1)
                {
                    int minVal = findMin(set);
                    for (int j = i + 1; j < time.length; j++)
                    {
                        time[j] = Character.forDigit(minVal, 10);
                    }
                    if (minVal == Integer.MAX_VALUE)
                    {
                        i = time.length;
                        continue;
                    }
                }
                else
                {
                    break;
                }
            }
            else if (i == 0)
            {
                int minVal = findMin(set);
                Arrays.fill(time, Character.forDigit(minVal, 10));
            }
        }

        String nextTime = new String(time);
        nextTime = nextTime.substring(0, 2) + ":"+ nextTime.substring(2, nextTime.length());
        return nextTime;
    }

    public static void main (String[] args)
    {
        String S = "23:59";
        String result = solution(S);
        System.out.println(result);
    }
}

