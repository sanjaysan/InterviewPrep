package strings;

/**
 * Created by sanjay on 2/7/18.
 */
public class RollingString
{
    private static String rollingString(String s, String[] operations)
    {
        char[] array = s.toCharArray();
        for (int x = 0; x < operations.length; x+= 3)
        {
            int i = Integer.parseInt(operations[x]);
            int j = Integer.parseInt(operations[x + 1]);

            if (i < 0 || j > s.length() || i > j)
            {
                return "";
            }
            char ch = operations[x + 2].charAt(0);

            if (ch == 'L')
            {
                for (int k = i; k <= j; k++)
                {
                    if ((array[k] - 1) < 97)
                    {
                        array[k] = (char) ((array[k] - 1) + 26);
                    }
                    else
                    {
                        array[k] = (char) (array[k] - 1);
                    }
                }
            }
            else
            {
                for (int k = i; k <= j; k++)
                {
                    if ((array[k] + 1) > 122)
                    {
                        array[k] = (char) ((array[k] + 1) - 26);
                    }
                    else
                    {
                        array[k] = (char) (array[k] + 1);
                    }
                }
            }
        }
        return new String(array);
    }

    public static void main (String[] args)
    {
        String s = "abc";
        String[] operations = {"0", "0", "L", "2", "2", "L", "0", "2", "R"};
        String result = rollingString(s, operations);
        System.out.println(result);
    }
}
