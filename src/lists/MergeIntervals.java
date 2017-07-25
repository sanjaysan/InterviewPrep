package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals
{
    static class Interval
    {
        int start, end;
        Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    private static List<Interval> merge(List<Interval> intervals)
    {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0)
        {
            return result;
        }

        Collections.sort(intervals, new Comparator<Interval>()
        {
            public int compare(Interval i1, Interval i2)
            {
                if (i1.start != i2.start)
                {
                    return i1.start - i2.start;
                }
                else
                {
                    return i1.end - i2.end;
                }
            }
        });

        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++)
        {
            Interval curr = intervals.get(i);
            if (curr.start > pre.end)
            {
                result.add(curr);
                pre = curr;
            }
            else
            {
                Interval mergedInterval = new Interval(pre.start, Math.max(pre.end, curr.end));
                result.add(mergedInterval);
            }
        }
        return result;
    }
    public static void main(String [] args)
    {
        List<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);

        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);

        List <Interval> result = merge(intervals);

        for (int i = 0; i < result.size(); i++)
        {
            System.out.print("[" + result.get(i).start + ", " + result.get(i).end + "]");
            if (i < result.size() - 1)
            {
                System.out.print(",");
            }
        }
    }
}
