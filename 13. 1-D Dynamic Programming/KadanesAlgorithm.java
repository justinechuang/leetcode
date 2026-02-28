//Kadanes Algorithm (Dynamic Programming approach)
//at each index, either extend the previous subarray or start fresh at the current element

class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];  // max subarray ending here
        int maxSum = nums[0];      // global max
        for (int i = 1; i < nums.length; i++) {
            // Either extend previous subarray or start new at nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update global maximum
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}