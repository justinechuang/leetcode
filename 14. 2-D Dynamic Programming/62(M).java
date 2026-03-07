/*62. Unique Paths (Medium), 2D Dynamic Programming
Each cell becomes the sum of the cell below and the cell to the right, 
which is why the table forms Pascal’s triangle patterns.
*/

class Solution {
    public int uniquePaths(int m, int n) {    // function that returns number of unique paths in an m x n grid
        int[][] dp = new int[m][n];           // dp[i][j] will store number of ways to reach the destination from cell (i,j)
        dp[m-1][n-1] = 1;                     // base case: at the destination there is exactly 1 way to finish (stay there)
        
        for(int i = m-1; i >= 0; i--){        // iterate rows from bottom to top
            for(int j = n-1; j >= 0; j--){    // iterate columns from right to left
                if(i + 1 < m){                // check if moving down stays inside the grid
                    dp[i][j] += dp[i+1][j];   // add number of paths from the cell below
                }
                if(j + 1 < n){                // check if moving right stays inside the grid
                    dp[i][j] += dp[i][j+1];   // add number of paths from the cell to the right
                }
            }                                 // after this iteration, dp[i][j] holds total paths from this cell
        }
        return dp[0][0];                      // answer: number of unique paths from the start (top-left)
    }
}

/*
for 5x5 grid:
initialize: dp[m-1][n-1] = 1;
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 1 ]

row i=4, (4,4), already 1
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 1 ]

(4,3) dp[4][3] += dp[4][4] --> = 1
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 1 1 ]

(4,2) dp[4][2] = 1
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 1 1 1 ]

(4,1) dp[4][1] = 1
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 1 1 1 1 ]

(4,0) dp[4][0] = 1
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 1 1 1 1 1 ]

row i=3 (3,4) dp[3][4] = dp[4][4] --> = 1
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 1 ]
[ 1 1 1 1 1 ]

(3,3) dp[3][3] = dp[4][3] + dp[3][4]
         = 1 + 1
         = 2
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 2 1 ]
[ 1 1 1 1 1 ]

(3,2) dp[3][2] = 1 + 2 = 3
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 3 2 1 ]
[ 1 1 1 1 1 ]

(3,1) dp[3][1] = 1 + 3 = 4
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 4 3 2 1 ]
[ 1 1 1 1 1 ]

(3,0) dp[3][0] = 1 + 4 = 5
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 0 0 0 0 0 ]
[ 5 4 3 2 1 ]
[ 1 1 1 1 1 ]

............

row i = 0
[ 70 35 15 5 1 ]
[ 35 20 10 4 1 ]
[ 15 10  6 3 1 ]
[  5  4  3 2 1 ]
[  1  1  1 1 1 ]

dp[0][0] = 70
*/