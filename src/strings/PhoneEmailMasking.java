package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sanjay on 12/4/17.
 */
public class PhoneEmailMasking
{
    private static void maskEmail(String input)
    {
        String maskedEmail = input.replaceAll("(?<=.{1}).(?=[^@]*?.@)", "*");

        int index = maskedEmail.indexOf("@");

        if (index != -1)
        {
            String croppedEmail = maskedEmail.substring(0, index);

            String modifiedEmail = croppedEmail.charAt(0) + "*****"
                                   + croppedEmail.charAt(croppedEmail.length() - 1)
                                   + maskedEmail.substring(index, maskedEmail.length());
            System.out.println("E:" + modifiedEmail);
        }
    }
    private static void maskPhone(String input)
    {
        Pattern phonePattern = Pattern.compile("(\\+)?\\s*(\\d+)*\\s*[(]?(\\d+)[)]?\\s*(\\d+)[\\s-]?" +
                                               "(\\d{4})");
        Matcher phoneMatcher = phonePattern.matcher(input);

        while (phoneMatcher.find())
        {
            String plusSign = phoneMatcher.group(1);
            String countryCode = phoneMatcher.group(2);
            String phoneNumber = phoneMatcher.group(3).replaceAll("\\d", "*") + "-"
                                 + phoneMatcher.group(4).replaceAll("\\d", "*")
                                 + "-" + phoneMatcher.group(5);

            String result = "";
            if (plusSign != null)
            {
                result += plusSign;
            }
            if (countryCode != null)
            {
                countryCode = countryCode.trim();
                int countryCodeLen = countryCode.length();
                for (int i = 0; i < countryCodeLen; i++)
                {
                    result += '*';
                }
                result += "-";
            }
            result += phoneNumber;

            System.out.println("P:" + result);
        }
    }

    public static void main(String[] args)
    {
        String input = "";
//        input = "+1 (333) 444-5678";
//        input = "+91 (333) 444-5678";
//        input = "333 444 5678";
//        input = "(333) 444 5678";

        Scanner sc = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(sc.hasNextLine())
        {
            input = sc.nextLine().trim();
            if (input.isEmpty())
            {
                continue;
            }
            inputs.add(input);
            sc.reset();
        }

        for (String s: inputs)
        {
            if (s.contains("E:"))
            {
                maskEmail(s.replace("E:", ""));
            }
            else
            {
                maskPhone(s.replace("P:", ""));
            }
        }
    }
}