package strings;

/**
 * Created by sanjay on 9/7/17.
 */
import java.util.*;
public class DecodeCipher
{
    public static void main (String[] args)
    {
        String encrypted_message = "Bjj rwkcs";
        char[] encodedMessage = encrypted_message.toCharArray();
        char[] decryptedMessage = new char[encodedMessage.length];

        char[] key = "8251220".toCharArray();
        //char[] key = {18, 24, 21, 25, 24, 24, 0};

        int j = 0;
        for (int i = 0; i < encodedMessage.length; i++)
        {
            if(Character.isLetter(encodedMessage[i]))
            {
                int decrementer = (int) encodedMessage[i] - (int) (key[j] - '0');
                if (Character.isUpperCase(encodedMessage[i]))
                {
                    if (decrementer < 65)
                    {
                        decryptedMessage[i] = (char) (decrementer + 26);
                    }
                    else
                    {
                        decryptedMessage[i] = (char) (decrementer);
                    }
                }
                else if (Character.isLowerCase(encodedMessage[i]))
                {
                    if (decrementer < 97)
                    {
                        decryptedMessage[i] = (char) (decrementer + 26);
                    }
                    else
                    {
                        decryptedMessage[i] = (char) (decrementer);
                    }
                }
                j = (j + 1) % key.length;
            }
            else
            {
                decryptedMessage[i] = encodedMessage[i];
            }
        }

        System.out.println(Arrays.toString(decryptedMessage));
    }
}
