/**
 * Created by sanjay on 1/18/17.
 */
class ReverseWordsInPlace
{
    private static void reverse(char [] str, int i, int j)
    {
        while (i < j)
        {
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
    }
    private static void reverseWords(char[] s)
    {
        int i = 0;
        for (int j = 0; j < s.length; j++)
        {
            if (s[j] == ' ')
            {
                reverse(s,i ,j - 1);
                i = j + 1;
            }
        }
        reverse(s, i, s.length - 1);
        reverse(s, 0, s.length - 1);
    }

    public static void main (String [] args)
    {
        String str = "the sky   is blue";
        str = str.replaceAll("\\s{2,}", " ");
        char [] s = str.toCharArray();
        reverseWords(s);
        System.out.println(s);
    }
}
