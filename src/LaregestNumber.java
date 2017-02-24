import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sanjay on 1/29/17.
 */
public class LaregestNumber
{
    private static String largestNumber(int [] nums)
    {
        String [] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (String a, String b) -> (b + a).compareTo(a + b));

//        Arrays.sort(arr, new Comparator<String>()
//        {
//            public int compare(String a, String b)
//            {
//                return (b + a).compareTo(a + b);
//            }
//        };

        StringBuilder sb = new StringBuilder();
        for (String s : arr)
        {
            sb.append(s);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1)
        {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    public static void main(String [] args)
    {
        int [] nums = {35, 30, 34, 5, 9};
        String result = largestNumber(nums);
        System.out.println(result);
    }
}
