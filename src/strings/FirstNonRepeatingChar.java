package strings;

/**
 * Created by sanjay on 12/29/16.
 */
public class FirstNonRepeatingChar
{
    private static int mNoOfChars = 256;
    static class CharacterCount
    {
        int count;
        int index;
    }

    private static CharacterCount[] findCharCount(String str)
    {
        CharacterCount charCount [] = new CharacterCount[256];
        for (int i = 0; i < charCount.length; i++)
        {
            charCount[i] = new CharacterCount();
        }
        char c [] = str.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            charCount[c[i]].count++;
            if (charCount[c[i]].count == 1)
            {
                charCount[c[i]].index = i;
            }
        }
        return charCount;
    }
    private static int firstNonRepeating(String str)
    {
        int result = Integer.MAX_VALUE;
        if (str != null)
        {
            CharacterCount[] charCount = findCharCount(str);
            for (int i = 0; i < mNoOfChars; i++)
            {
                if (charCount[i].count == 1 && result > charCount[i].index)
                {
                    result = charCount[i].index;
                }
            }
            if (result == Integer.MAX_VALUE)
            {
                result = -1;
            }
        }
        else
        {
            result = -1;
        }
        return result;
    }

    public static void main(String [] args)
    {
        FirstNonRepeatingChar fnrc = new FirstNonRepeatingChar();
        String str = "leetcode";
        int index = firstNonRepeating(str);
        if (index != -1)
        {
            System.out.println(str.charAt(index));
        }
        else
        {
            System.out.println(-1);
        }
    }
}
