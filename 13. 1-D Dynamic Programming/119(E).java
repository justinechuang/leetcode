//119 Pascal's Triangle II
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<=rowIndex; i++){
            List<Integer> tri = new ArrayList<>();
            for(int j=0; j<=i; j++){    
                if(j==0 || j==i){
                    tri.add(1);
                }
                else {
                    tri.add(ans.get(j-1) + ans.get(j));
                }
            }
            ans = tri;
        }
        return ans; 
    }
}