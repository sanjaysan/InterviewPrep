package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjay on 10/4/17.
 */
public class PermutationsOfString
{
    public static List<String> getPerms(String s)
    {
        List<String> permutations = new ArrayList<>();

        if (s == null)
        {
            return null;
        }

        else if (s.length() == 0)
        {
            permutations.add("");
            return permutations;
        }

        char first = s.charAt(0);
        String remainder = s.substring(1);
        List<String> words = getPerms(remainder);
        for (String word: words)
        {
            for (int i = 0; i <= word.length(); i++)
            {
                permutations.add(inserCharAt(word, first, i));
            }
        }
        return permutations;
    }
    private static String inserCharAt(String word, char c, int i)
    {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main (String[] args)
    {
        String s = "abc";
        List<String> result = getPerms(s);
        System.out.println(result.toString());
    }
}
