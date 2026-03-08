/*55. Jump Game (Medium)
*/
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;          // Farthest index we can reach
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;// Can't even reach this index
            maxReach = Math.max(maxReach, i + nums[i]); // Extend reach
        }
    return true; 
}

/*
- Moving backward from the array we keep track of "goal"
	- goal: the leftmost index that we must be able to reach
	- initially the goal is the last index itself
	- if from index `i` we can jump to the current `goal` or beyond, then index `i` becomes the new goal.
	- if goal is the index `0`, that means we've reached the end. 
*/

class Solution {
	public boolean canJump(int[] nums) {
		int goal = nums.length-1;
		for(int i=nums.length-2; i>=0; i--){
			if(i + nums[i] >= goal){
				goal = i;
			}
		}
		return goal == 0;
	}
}