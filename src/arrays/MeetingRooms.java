package arrays;

import java.util.Arrays;

/**
 * Created by sanjay on 8/13/17.
 */
public class MeetingRooms
{
    static class Interval
    {
        int start;
        int end;
        Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    private static boolean canAttendMeetings(Interval[] intervals)
    {
        Arrays.sort(intervals, (Interval i1, Interval i2) -> (i1.start - i2.start));

        for (int i = 0; i < intervals.length - 1; i++)
        {
            if (intervals[i + 1].start < intervals[i].end)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Interval[] intervals = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        boolean result = canAttendMeetings(intervals);
        System.out.println(result);
    }
}
