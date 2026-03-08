/* 20. Valid Parentheses (Easy)
Notes:
- Stack stores the expected closing brackets 
- When an opening bracket '(' is seen, push the matching closing bracket ')' onto the stack. 
- When a closing bracket is encountered, check if it matches the top of the stack
- At the end, the stack must be empty -> all opened brackets were closed properly in order

Example:
Input: "({[]})"
| Step | Char | Action              | Stack   |
| ---- | ---- | ------------------- | ------- |
| 1    | (    | push )              | )       |
| 2    | {    | push }              | ), }    |
| 3    | [    | push ]              | ), }, ] |
| 4    | ]    | matches stack.pop() | ), }    |
| 5    | }    | matches stack.pop() | )       |
| 6    | )    | matches stack.pop() | empty   |

*/
class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '('){
				stack.push(')');
			}
			else if(s.charAt(i) == '{'){
				stack.push('}');
			}
			else if(s.charAt(i) == '['){
				stack.push(']');
			}
			else if(stack.isEmpty() || stack.pop() != s.charAt(i)){
				return false;
			}
		}	
		return stack.isEmpty();
	}
}