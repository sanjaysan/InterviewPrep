package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sanjay on 10/10/17.
 */
public class BestAverageScore
{
    static int bestAverageGrade(String[][] scores)
    {
        if (scores == null || scores.length == 0)
        {
            return 0;
        }

        Map<String, List<Integer>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++)
        {
            String studentName = scores[i][0];
            String studentScore = scores[i][1];
            if (map.containsKey(studentName))
            {
                List<Integer> temp = map.get(studentName);
                temp.add(Integer.parseInt(studentScore));
                map.put(studentName, temp);
            }
            else
            {
                List<Integer> l = new ArrayList<>();
                l.add(Integer.parseInt(studentScore));
                map.put(studentName, l);
            }
        }

        for (Map.Entry<String, List<Integer>> entry: map.entrySet())
        {
            List<Integer> scoreList = entry.getValue();
            double sum = 0;
            for (int i = 0; i < scoreList.size(); i++)
            {
                sum += scoreList.get(i);
            }
            double averageScore = Math.floor(sum / scoreList.size());
            max = Math.max(max, (int) averageScore);
        }
        return max;
    }

    public static void main (String[] args)
    {
        String[][] scores = {{"Sarah", "99"},
                {"Elaine", "99"},
                {"Jordan", "99"}};
        int result = bestAverageGrade(scores);
        System.out.println(result);
    }
}
