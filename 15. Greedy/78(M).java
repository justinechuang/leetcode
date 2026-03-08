
/*78. Subsets (Medium)
This is a classic backtracking question:
Time complexity: O(n * 2^n)
Space complexity: O(n), extra space - O(2^n), output list

*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        dfs(nums, 0, list, sublist);
        return list; 
    }
    private void dfs(int[] nums, int i, List<List<Integer>> list, List<Integer> sublist){
        if(i>= nums.length){
            list.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(nums[i]);
        dfs(nums, i+1, list, sublist);
        sublist.remove(sublist.size()-1);
        dfs(nums, i+1, list, sublist);
    }   
}

/* Iterative solution
1. Initialize with an empty subset
2. For each number num in the input array:
    - For every subset already in res:
        - Create a new subset that includes num
    - Append all these newly created subsets to res
3. Return res after processing all numbers
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(num);
                res.add(subset);
            }
        }

        return res;
    }
}