package matrices;

/**
 * Created by sanjay on 10/7/17.
 */
public class MaxAreaOfIsland
{
    private static int dfs(int[][] grid, int i, int j, int m, int n, int count)
    {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int k = 0; k < 4; k++)
        {
            int newI = i + dx[k];
            int newJ = j + dy[k];

            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 1)
            {
                grid[newI][newJ] = -1;
                count += dfs(grid, newI, newJ, m, n, 1);
            }
        }
        return count;
    }
    public static int maxAreaOfIsland(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                    grid[i][j] = -1;
                    result = Math.max(result, dfs(grid, i, j, m, n, 1));
                }
            }
        }
        return result;
    }

    public static void main (String[] args)
    {
        int[][] grid = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        int result = maxAreaOfIsland(grid);
        System.out.println(result);
    }
}
