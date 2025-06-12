/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isMirror(root.left,root.right);
    }
;
    public boolean isMirror(TreeNode leftnode,TreeNode rightnode){
        if(leftnode==null&&rightnode==null){
            return true;
        }
        if(leftnode==null || rightnode==null){
            return false;
        }
        if (leftnode.val != rightnode.val) {
            return false;
        }
        return isMirror(leftnode.left,rightnode.right)&&isMirror(leftnode.right,rightnode.left);
    }
}