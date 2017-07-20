public class ValidPalindrome
{
    private static boolean isPalindrome(String s)
    {
        if (s == null || s == "")
        {
            return false;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while ((i < s.length() / 2) && (i <= j))
        {
            if (s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main (String[] args)
    {
        String s = "Red rum, sir, is murder";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }
}
