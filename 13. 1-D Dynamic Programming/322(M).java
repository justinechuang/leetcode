/*322. Coin Change (Medium)
Bottom Up Approach Notes:
- Large problems can be solved by combining solutions to smaller subproblems.
- To make an amount i, we can try using each coin and see:
	- "If I use this coin last, what was the best way to make the remaining amount?"
- Subproblem:
	- Define a table where each entry represents the minimum number of coins needed to make a specific amount
	- The solution to the target amount depends on previously computed smaller amounts
- Base Case:
	- Amount 0 requires 0 coins:
	- This is the foundation for building all other results.
- Initialization Strategy:
	- All amounts initially marked as impossible 
	- Use a value larger than realistic answer to represent this "unreachable" state.
	- This allows us to safely minimize values later.
- Botton-Up Construction:
	- Start solving from the smallest amount (1) and move upward to the target.
	- For each amount:
		- Try every coin denomination
		- If the coin can be used (does not overshoot the amount):
			- Consider the solution to the remaining amount.
			- Add one coin to that solution
			- Keep the minimum result across all choices.
- Transition Logic (Core Formula):
	- The optimal solution for an amount is:
		- The minimum of:
			- (solution for remaining amount + 1 coin)
		- Across all valid coins
	- Guarantees the fewest coins possible.
- Guarantees Optimality:
	- Every amount is computed using already optimal smaller results.
	- No subproblem is solved more than once
	- All combinations are explored systematically
- Handling Impossible Cases:
	- If the final amount remains marked as "unreachable":
		- No combination of coins can form the target
	- Return -1
- Time & Space Complexity:
	- Time complexity grows with target amount x number of coin denominations
	- Space complexity depends only on the target amount
*/

class Solution { //Bottom Up 
	public int coinChange(int[] coins, int amount) {
		if(amount ==0){
			return 0;		
		}
		int[] dp = new int[amount+1];		
		Arrays.fill(dp, amount+1);		
		dp[0] = 0;		
		for(int i=1; i<= amount; i++){
			for(int coin: coins){
				if(i-coin>=0){
					dp[i] = Math.min(dp[i], dp[i-coin]+1);
				}		
			}
		}		
		int ans = -1;
		if(dp[amount] <=amount){
			ans = dp[amount];
		}
		return ans;
	}
}

/*
Top Down Approach Notes:
- Idea: 
	- Instead of building answers from 0-> amount, 
	- We start from the target amount and recursively ask:
		- "What is the minimum number of coins needed to make this amount?"
	- Cache results so each subproblem is solved only once.
- Subproblem:
	- Define a function:
		- "Minimum coins needed to make amount x"
	- The function will be called repeatedly for smaller values of "x"
- Base Cases:
	- If the amount if 0:
		- No coins are needed -> return 0
	- If the amount becomes negative:
		- This path is invalid -> return "impossible"
- Recursive Choice:
	- For the current amount:
		- Try subtracting each coin denomination
		- Recursively compute the minimum coins for the remaining amount
		- Add 1 coin for the current choice
- Memoization for Optimization:
	- without memoization, the same subproblems are recomputed many times 
	- with memoization,  store the result for each amount the first time its computed and future calls return instantly
- Transition Logic:
	- For a given amount:
		- Minimum coins = 
			- Minimum of (recursive result for remainder + 1)
			- Across all coin choices that do not go negative
- Handling Impossible States:
	- If all recursive paths are impossible, mark the current amount as impossible
	- Value is cached to prevent re-evaluation
- Termination Guarantee:
	- Each recursive call reduces the amount
	- Memoization ensures:
		- each amount is solved once
		- recursion eventually bottoms out at 0 or negative values
- Final Answer:
	- Start recursion from the target amount
	- If the result is impossible -> return -1
	- Otherwise -> return the computed minimum
- Time & Space Complexity:
	- Time: O(amount x number_of_coins)
	- Space: 
		- Memo table: O(amount)
		- Recursion stack: up to O(amount)
*/

class Solution { //Top Down
    public int coinChange(int[] coins, int amount) {
        // memo[i] = minimum coins needed to make amount i
        // -2 means "not computed yet"
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int amount, int[] memo) {
        // Base cases
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        // Return cached result if available
        if (memo[amount] != -2) {
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;

        // Try every coin
        for (int coin : coins) {
            int res = dfs(coins, amount - coin, memo);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        // Store result in memo
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }
}
