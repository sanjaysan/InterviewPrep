package strings;

class LexoSmallest
{
    private static int numRotations = 0;

    // Function to compare lexicographically two sequence with different starting
    // indexes. It returns true if sequence beginning with y is lexicographically
    // greater.
    static boolean compareSeq(char[] S, int x, int y, int n)
    {
        numRotations++;
        for (int i = 0; i < n; i++)
        {
            if (S[x] < S[y])
            {
                return false;
            }
            else if (S[x] > S[y])
            {
                return true;
            }
            x = (x + 1) % n;
            y = (y + 1) % n;
        }
        return true;
    }

    // Function to find starting index of lexicographically smallest sequence
    static int smallestSequence(char[] S, int n)
    {
        int res = 0;
        int index = 0;
        for (int i = 1; i < n; i++)
        {
            // If new sequence is smaller
            if (compareSeq(S, index, i, n))
            {
                // Change index of current min
                index = i;
                res = numRotations;
            }
        }
        return res;
    }

    // Function to get minimum rotations
    static int getMinRotations(String str, int n)
    {
        char[] S = str.toCharArray();
        int res = smallestSequence(S, n);
        return res;
    }

    public static void main(String[] args)
    {
        String S = "baabccd";
        int result = getMinRotations(S, S.length());
        System.out.println(result);
    }
}