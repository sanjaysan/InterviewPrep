package arrays; /**
 * Created by sanjay on 2/10/17.
 */
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    static void reverse(char [] str, int start, int end)
    {
        while (start <= end)
        {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
    static String reverseButPreserveWhitespace(String initialMessage)
    {
        char [] reversedMessage = initialMessage.toCharArray();
        int start = 0, end = 0;
        for (; end < reversedMessage.length;)
        {
            if (reversedMessage[end] == ' ')
            {
                reverse(reversedMessage, start, end - 1);
                while (reversedMessage[end] == ' ' || end == reversedMessage.length - 1)
                {
                    end++;
                }
                start = end;
            }
            else
            {
                end++;
            }
        }
        reverse(reversedMessage, start, end - 1);
        return new String(reversedMessage);
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        String str = "Secret Message      test";
        String result = reverseButPreserveWhitespace(str);
        System.out.println(result);
    }
}
