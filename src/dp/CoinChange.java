package dp;

import java.util.Arrays;

/**
 * Created by sanjay on 10/22/17.
 */
public class CoinChange
{
    private static int coinChange(int[] coins, int amount)
    {
        if (amount == 0)
        {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        Arrays.fill(dp, 1, amount + 1, Integer.MAX_VALUE);

        for (int i = 0; i <= amount; i++)
        {
            for (int coin: coins)
            {
                if (coin != Integer.MAX_VALUE && i + coin <= amount)
                {
                    if (dp[i] == Integer.MAX_VALUE)
                    {
                        dp[i + coin] = dp[i + coin];
                    }
                    else
                    {
                        dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                    }
                }
            }
        }

        if (dp[amount] >= Integer.MAX_VALUE)
        {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args)
    {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println(result);
    }
}
