package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanjay on 9/10/17.
 */
public class NextNearestTime
{
    private static int findNextMax(int val, Set<Integer> set)
    {
        for (Integer num : set)
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
        for (Integer num : set)
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

        int minVal = findMin(set);
        for (int i = time.length - 1; i >= 0; i--)
        {
            int val = Character.getNumericValue(time[i]);
            int nextMax = findNextMax(val, set);
            if (nextMax != -1)
            {
                if (i == 3 && nextMax >= 0 && nextMax <= 9)
                {
                    time[i] = Character.forDigit(nextMax, 10);
                    break;
                }
                else if (i == 2 && nextMax >= 0 && nextMax <= 5)
                {
                    time[i] = Character.forDigit(nextMax, 10);
                    break;
                }
                else if (i == 1)
                {
                    if (nextMax >= 0 && nextMax <= 9 && (time[i - 1] == '0' || time[i - 1] ==
                                                                               '1'))
                    {
                        time[i] = Character.forDigit(nextMax, 10);
                        break;
                    }
                    else if (nextMax >= 0 && nextMax <= 3)
                    {
                        time[i] = Character.forDigit(nextMax, 10);
                        break;
                    }
                }
                else if (i == 0 && nextMax >= 0 && nextMax <= 2)
                {
                    time[i] = Character.forDigit(nextMax, 10);
                    break;
                }
            }
            time[i] = Character.forDigit(minVal, 10);
        }

        String nextTime = new String(time);
        nextTime = nextTime.substring(0, 2) + ":" + nextTime.substring(2, nextTime.length());
        return nextTime;
    }

    public static void main(String[] args)
    {
        String S = "09:09";
        String result = solution(S);
        System.out.println(result);
    }
}

