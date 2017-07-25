package lists; /**
 * Created by sanjay on 1/18/17.
 */
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class MaximumDigitalTime
{
    public String findMaxDigitalTime(int A, int B, int C, int D) {
        // write your code in Java SE 8
        Integer time[] = new Integer[4];


        ArrayList<Integer> hour1 = new ArrayList<Integer>();
        ArrayList<Integer> hour2 = new ArrayList<Integer>();
        ArrayList<Integer> minute1 = new ArrayList<Integer>();
        ArrayList<Integer> minute2 = new ArrayList<Integer>();

        Integer maxHour1 = null;
        Integer maxHour2 = null;
        Integer maxMinute1 = null;
        Integer maxMinute2 = null;

        time[0] = A;
        time[1] = B;
        time[2] = C;
        time[3] = D;

        for (int i = 0; i < 4; i++)
        {
            if ((maxHour1 == null && time[i] <= 2) || (maxHour1 != null && time[i] <= 2))
            {
                if (maxHour1 == null)
                {
                    hour1.add(time[i]);
                    Collections.sort(hour1);
                    maxHour1 = hour1.get(hour1.size() - 1);
                }
                else if (time[i] > maxHour1)
                {
                    hour1.add(time[i]);
                    Collections.sort(hour1);
                    maxHour1 = hour1.get(hour1.size() - 1);
                }
                else
                {
                    hour2.add(time[i]);
                    Collections.sort(hour2);
                    maxHour2 = hour2.get(hour2.size() - 1);
                }
            }
            else if (time[i] < 4 && maxHour1 != null && maxHour1 == 2)
            {
                hour2.add(time[i]);
                Collections.sort(hour2);
                maxHour2 = hour2.get(hour2.size() - 1);
            }
            else if (maxHour1 != null && (maxHour1 == 1 || maxHour1 == 0))
            {
                if (time[i] <= 9)
                {
                    hour2.add(time[i]);
                    Collections.sort(hour2);
                    maxHour2 = hour2.get(hour2.size() - 1);
                }
            }
        }
        if (maxHour1 == 2)
        {
            if (maxHour2 == null)
            {
                maxHour2 = hour1.get(0);
            }

            else if (maxHour2 != null && maxHour2 >= 4)
            {
                maxHour2 = hour2.get(hour2.size() - 2);
            }

        }

        for (int i = 0; i < 4; i++)
        {
            if (maxHour1 != null && time[i] == maxHour1)
            {
                time[i] = null;
                break;
            }
        }
        for (int i = 0; i < 4; i++)
        {
            if (maxHour2 != null && time[i] == maxHour2)
            {
                time[i] = null;
                break;
            }
        }

        if (maxHour1 != null && maxHour2 != null)
        {
            for (int i = 0; i < 4; i++)
            {
                if (time[i] != null && time[i] <= 5)
                {
                    minute1.add(time[i]);
                    Collections.sort(minute1);
                    maxMinute1 = minute1.get(minute1.size() - 1);
                }
                else if (time[i] != null && time[i] <= 9)
                {
                    if (maxMinute1 != null && time[i] > maxMinute1 && time[i] >= 5)
                    {
                        minute2.add(time[i]);
                        Collections.sort(minute2);
                        maxMinute2 = minute2.get(minute2.size() - 1);
                    }
                    else
                    {
                        minute2.add(time[i]);
                        Collections.sort(minute2);
                        maxMinute2 = minute2.get(minute2.size() - 1);
                    }
                }
            }
            if (maxMinute2 == null)
            {
                maxMinute2 = minute1.get(0);
            }
        }
        String result = null;
        if (maxMinute1 == null || maxMinute2 == null)
        {
            result = "NOT POSSIBLE";
        }
        else
        {
            result = String.valueOf(maxHour1) + String.valueOf(maxHour2) + ":" +
                    String.valueOf(maxMinute1) + String.valueOf(maxMinute2);
        }
        return result;
    }
    public static void main (String [] args)
    {
        MaximumDigitalTime mdt = new MaximumDigitalTime();
//        String result = mdt.findMaxDigitalTime(1,8,3,2);
//        String result = mdt.findMaxDigitalTime(2,4,0,0);
//        String result = mdt.findMaxDigitalTime(3,0,7,0);
//        String result = mdt.findMaxDigitalTime(9,1,9,7);
//        String result = mdt.findMaxDigitalTime(9,1,1,7);
        String result = mdt.findMaxDigitalTime(2,2,3,4);
        System.out.println(result);
    }
}
