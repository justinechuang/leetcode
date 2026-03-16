//6. Zigzag Conversion (Medium)

class Solution {
    public String convert(String s, int numRows) {
        //base case
        if(numRows == 1 || s.length() <= numRows) return s; 
        //calculate cycle 
        int cycle = 2 * numRows -2;
        StringBuilder str = new StringBuilder(); 
        for(int i=0; i<numRows; i++){
            for(int j=i; j<s.length(); j+=cycle){
                str.append(s.charAt(j));
                //calculate diagonal
                int diag = j + cycle - 2 * i;
                //calculate for 0th row and last row
                if(i!=0 &&  i != numRows -1 && diag < s.length()){
                    str.append(s.charAt(diag)); 
                }
            }
        }
        return str.toString();
    }   
}