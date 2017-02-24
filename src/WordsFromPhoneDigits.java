/**
 * Created by sanjay on 2/1/17.
 */
public class WordsFromPhoneDigits
{
    private static String hashTable [] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static void printWordsUtil(int [] number, int cur_digit, char [] output, int n)
    {
        if (cur_digit == n)
        {
            System.out.print(output);
            System.out.print(" ");
            return;
        }

        char array [] = hashTable[number[cur_digit]].toCharArray();
        for (int i = 0; i < array.length; i++)
        {
            output[cur_digit] = array[i];
            printWordsUtil(number, cur_digit + 1, output, n);
            if (array[i] == 0 || array[i] == 1)
            {
                return;
            }
        }
    }
    private static void printWords(int [] number, int  n)
    {
        char result[] = new char[n];
        printWordsUtil(number, 0, result, n);
    }
    public static void main (String [] args)
    {
        int [] number = {2, 3, 4};
        printWords(number, number.length);
    }
}
