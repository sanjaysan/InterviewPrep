package strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sanjay on 12/24/17.
 */
class MutationSequence
{
    String sequence;
    int length;
    MutationSequence(String sequence, int length)
    {
        this.sequence = sequence;
        this.length = length;
    }
}
public class MutationDistance
{
    private static int findMutationDistance(String start, String end, String[] bank)
    {
        List<Character> nucleotide = Arrays.asList('A', 'T', 'C', 'G');
        List<String> validMutation = new ArrayList<>();
        validMutation.add(end);
        List<String> banks = Arrays.stream(bank).collect(Collectors.toList());


        Queue<MutationSequence> queue = new LinkedList<>();
        queue.add(new MutationSequence(start, 1));
        while (!queue.isEmpty())
        {
            MutationSequence mutationSequence = queue.poll();
            String sequence = mutationSequence.sequence;
            if (sequence.equals(end))
            {
                return mutationSequence.length - 1;
            }

            char[] str = sequence.toCharArray();
            for (int i = 0; i < str.length; i++)
            {
                for (char n: nucleotide)
                {
                    char temp = str[i];
                    if (str[i] != n)
                    {
                        str[i] = n;
                    }

                    String newSequence = new String(str);
                    if (banks.contains(newSequence))
                    {
                        queue.add(new MutationSequence(newSequence, mutationSequence.length + 1));
                        banks.remove(newSequence);
                    }
                    str[i] = temp;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        String start = "AAAAAAAA";
        String end = "GGAAAAAA";
        String[] bank = {"GAAAAAAA", "AAGAAAAA", "AAAAGAAA", "GGAAAAAA"};
        int result = findMutationDistance(start, end, bank);
        System.out.println(result);
    }

}
