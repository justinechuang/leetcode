//118. Pascal's Triangle (Easy)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pasc = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> tri = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    tri.add(1);
                }
                else {
                    tri.add(pasc.get(i-1).get(j-1) + pasc.get(i-1).get(j));
                }
            }
            pasc.add(tri);
        }
        return pasc; 
    }
}