/**
 * Created by sanjay on 2/21/17.
 */
public class AddBinaryStrings
{
    private static String addBinary(String a, String b)
    {
        if (a == null || a.isEmpty())
        {
            return b;
        }
        if (b == null || b.isEmpty())
        {
            return a;
        }

        int lenA = a.length();
        int lenB = b.length();

        String result = "";
        int sum = 0;

        for (int i = lenA - 1, j = lenB - 1; (i >=0 || j >= 0 || sum == 1); i--, j--)
        {
            sum += (i >= 0) ? (a.charAt(i) - '0') : 0;
            sum += (j >= 0) ? (b.charAt(j) - '0') : 0;

            result = (char)(sum % 2 + '0') + result;
            sum /= 2;
        }
        return result;
    }
    public static void main (String [] args)
    {
        String a ="11", b ="1";
        String result = addBinary(a, b);
        System.out.println(result);
    }
}
