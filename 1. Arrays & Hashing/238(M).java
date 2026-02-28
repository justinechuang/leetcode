//238. Product of Array Except Self (Medium)
class Solution {
	public int[] productExceptSelf(int[] nums) {
		int[] prefix = new int[nums.length];
		int[] suffix = new int[nums.length];
		int[] ans = new int[nums.length];
		int total = 1;
		Arrays.fill(prefix, 1);
		Arrays.fill(suffix, 1);
		for(int i=0; i<nums.length; i++){ //calculate the prefix array
			if(i!= 0){
				total *= nums[i-1];
				prefix[i] = total;
			}
		}
		total = 1;
		for(int i=nums.length-1; i>=0; i--){ //calculate the suffix array
			if(i!=nums.length-1){
				total *=nums[i+1];
				suffix[i] = total;
			}
		}		  	
		for(int i=0; i<nums.length; i++){ //calculate the final array
			ans[i] = suffix[i]*prefix[i];	
		}
		return ans;
	}
}
//Time Complexity: O(N)
//Space Complexity: O(N)