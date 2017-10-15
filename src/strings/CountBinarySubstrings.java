package strings;

/**
 * Created by sanjay on 10/14/17.
 */
public class CountBinarySubstrings
{
    private static int countBinarySubstrings(String s)
    {
        int prevLength = 0, currLength = 1, count = 0;
        for (int i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == s.charAt(i - 1))
            {
                currLength++;
            }
            else
            {
                prevLength = currLength;
                currLength = 1;
            }

            if (currLength <= prevLength)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        String s = "00110011";
        int result = countBinarySubstrings(s);
        System.out.println(result);
    }
}
