//235. Lowest Common Ancestor of a Binary Search Tree (Medium)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//the biggest insight into this problem is that for a BST, values smaller are to the left, values bigger are to the right, and at the split is the LCA
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while(curr != null){
            if(p.val>curr.val && q.val>curr.val){
                curr = curr.right; 
            }
            else if(p.val<curr.val && q.val<curr.val){
                curr = curr.left;
            }
            else{
                return curr;
            }
        }
        return null;
    }
}