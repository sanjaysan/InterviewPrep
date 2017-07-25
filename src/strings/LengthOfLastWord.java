package strings;

/**
 * Created by sanjay on 7/23/17.
 */
public class LengthOfLastWord
{
    private static int lengthOfLastWord(String s)
    {
        if (s == null || s.isEmpty())
        {
            return 0;
        }

        s = s.trim();

        int i = s.length() - 1, count = 0;
        while (i >= 0 && !Character.isSpaceChar(s.charAt(i)) &&  Character.isLetter(s.charAt(i)))
        {
            count++;
            i--;
        }
        return count;
    }
    public static void main (String[] args)
    {
        String s = "a ";
        int result = lengthOfLastWord(s);
        System.out.println(result);
    }
}
