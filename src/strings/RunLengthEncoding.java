package strings;

/**
 * Created by sanjay on 10/2/17.
 */
public class RunLengthEncoding
{
    static String runLengthEncode(String input) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length();)
        {
            int count = 0;
            char c = input.charAt(i);
            int j = i;
            while (j < input.length() && input.charAt(j) == c)
            {
                count++;
                j++;
            }
            sb.append(count);
            sb.append(c);
            i += count;
        }
        return sb.toString();
    }
    public static void main (String[] args)
    {
        String str = "GGGGGrrrrrrrrrrrrrrt";
        String result = runLengthEncode(str);
        System.out.println(result);
    }
}
