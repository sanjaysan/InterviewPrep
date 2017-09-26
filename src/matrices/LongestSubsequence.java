package matrices;

/**
 * Created by sanjay on 9/25/17.
 */
public class LongestSubsequence
{
    private static int dfs(int[][] grid, boolean[][] visited, int i, int j, int m, int n)
    {
        visited[i][j] = true;

        int[] xcoord = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] ycoord = {-1, 0, 1, -1, 1, -1, 0, 1};

        int max = 0;
        for (int k = 0; k < 8; k++)
        {
            int x = i + xcoord[k];
            int y = j + ycoord[k];

            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y])
            {
                if (Math.abs(grid[i][j] - grid[x][y]) > 3)
                {
                    max = Math.max(max, dfs(grid, visited, x, y, m, n));
                }
            }
        }
        visited[i][j] = false;

        return 1 + max;
    }

    private static int longestSequence(int[][] grid)
    {
        if (grid == null || grid.length == 0)
        {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        int maxLen = Integer.MIN_VALUE;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                maxLen = Math.max(maxLen, dfs(grid, visited, i, j, m, n));
            }
        }
        return maxLen;
    }

    public static void main(String[] args)
    {
        int[][] a = {{8, 2, 4}, {0, 6, 1}, {3, 7, 9}};
        int result = longestSequence(a);
        System.out.println(result);
    }
}
