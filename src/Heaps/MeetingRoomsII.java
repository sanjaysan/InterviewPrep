package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by sanjay on 8/13/17.
 */
public class MeetingRoomsII
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

    private static int minMeetingRooms(Interval[] intervals)
    {
        if (intervals == null || intervals.length == 0)
        {
            return 0;
        }

        Arrays.sort(intervals, (Interval i1, Interval i2) -> (i1.start - i2.start));

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(intervals[0].end);

        int count = 1;
        for (int i = 1; i < intervals.length; i++)
        {
            if (!queue.isEmpty())
            {
                if (intervals[i].start < queue.peek())
                {
                    count++;
                }
                else
                {
                    queue.poll();
                }
            }
            queue.add(intervals[i].end);
        }
        return count;
    }

    public static void main(String[] args)
    {
        Interval[] intervals = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        int result = minMeetingRooms(intervals);
        System.out.println(result);
    }
}
