//125 Valid Palindrome

class Solution {
	public boolean isPalindrome(String s) {
		if(s.isEmpty()){ 
			return true;
		}
		int left = 0;
		int right = s.length() -1;
		s = s.toLowerCase();
		char[] charArray = s.toCharArray();
		while(left <= right){
			if(!Character.isLetterOrDigit(charArray[left])){
				left++;
				continue;
			}
		
			if(!Character.isLetterOrDigit(charArray[right])){
				right--;
				continue;
			}
		
			if(charArray[left] == charArray[right]){
				left++;
				right--;
			}
			else{
				return false;
			}
		}
		return true;
	}
}