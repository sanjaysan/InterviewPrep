package strings;

/**
 * Created by sanjay on 7/5/17.
 */
public class StringToInteger
{
    private static int myAtoi(String str)
    {
        if (str == null || str.equals(""))
        {
            return 0;
        }

        int a [] = new int[5];
        int num = 0;
        int len = str.length();
        int j = 0;
        for (int i = len - 1; i >= 0; i--)
        {
            char c;
            if (Character.isDigit(c = str.charAt(i)))
            {
                num += (c - '0') * Math.pow(10, j);
                j++;
            }
            else
            {
                if (i > 0 && Character.isDigit(str.charAt(i - 1)))
                {
                    num = 0;
                    j = 0;
                }
                else
                {
                    j = 0;
                }
            }
        }
        return num;
    }

    public static void main(String [] args)
    {
        String str = "+1";
        int num = myAtoi(str);
        System.out.println(num);
    }
}
