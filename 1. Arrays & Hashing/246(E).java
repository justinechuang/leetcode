//246. Strobogrammatic Number


class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = Map.of('0','0','1','1','6','9','8','8','9','6');
        int l = 0;
        int r = num.length() - 1; 
        while(l<= r){
            char left = num.charAt(l);
            char right = num.charAt(r);
            
            if(!map.containsKey(left) || map.get(left) != right){
                return false;
            }
            l++;
            r--;
        }
        return true; 
    }