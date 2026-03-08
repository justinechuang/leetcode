/* 226. Invert Binary Tree (Easy)
*/

class Solution {
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null; //base case
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}