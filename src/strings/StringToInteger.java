package strings;

/**
 * Created by sanjay on 7/5/17.
 */
public class StringToInteger
{
    private static int myAtoi(String str)
    {
        if (str == null || str.length() < 1)
        {
            return 0;
        }

        str = str.trim();

        char flag = '+';
        int i = 0;

        if (str.charAt(0) == '-')
        {
            flag = '-';
            i++;
        }
        else if (str.charAt(0) == '+')
        {
            i++;
        }

        double result = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9')
        {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
        {
            result = -result;
        }

        if (result > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        else if (result < Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    public static void main(String [] args)
    {
        String str = "+1";
        int num = myAtoi(str);
        System.out.println(num);
    }
}
