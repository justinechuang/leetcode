//49. Group Anagrams (Medium)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(); 
        int increment = 0; 
        for(int i=0; i<strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String temp2 = new String(temp);
            if(!map.containsKey(temp2)){
                List<String> sublist = new ArrayList<>();
                sublist.add(strs[i]);
                ans.add(sublist);
                map.put(temp2, increment);
                increment++; 
            } else{
                int index = map.get(temp2);
                ans.get(index).add(strs[i]);
            }
        }
        return ans; 
    }
}