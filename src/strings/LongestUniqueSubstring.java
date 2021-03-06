package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanjay on 4/23/17.
 */
public class LongestUniqueSubstring
{
    private static int longestUniqueSubsttr(String str)
    {
        int n = str.length();
        int curLen = 1;  // length of current substring
        int maxLen = 1;  // result
        Map<Character, Integer> visited = new HashMap<>();


    /* Mark first character as visited by storing the index
       of first   character in visited array. */
        visited.put(str.charAt(0), 0);

    /* Start from the second character. First character is
       already processed (cur_len and max_len are initialized
       as 1, and visited[str[0]] is set */
        for (int i = 1; i < n; i++)
        {
            int prevIndex = visited.getOrDefault(str.charAt(i), -1);

        /* If the current character is not present in the
           already processed substring or it is not part of
           the current NRCS, then do cur_len++ */
            if (prevIndex == -1 || i - curLen > prevIndex)
            {
                curLen++;
            }

        /* If the current character is present in currently
           considered NRCS, then update NRCS to start from
           the next character of previous instance. */
            else
            {
            /* Also, when we are changing the NRCS, we
               should also check whether length of the
               previous NRCS was greater than max_len or
               not.*/
                if (curLen > maxLen)
                {
                    maxLen = curLen;
                }
                curLen = i - prevIndex;
            }

            // update the index of current character
            visited.put(str.charAt(i), i);
        }

        // Compare the length of last NRCS with max_len and
        // update max_len if needed
        if (curLen > maxLen)
        {
            maxLen = curLen;
        }

        return maxLen;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        String str = "ABDEFGABEF";
        System.out.println("The input string is " + str);
        int len = longestUniqueSubsttr(str);
        System.out.println("The length of the longest non-repeating character substring is " + len);
    }
}
