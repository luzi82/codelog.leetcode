import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }
    
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root==null)return true;
        if((min!=null)&&(root.val<=min))return false;
        if((max!=null)&&(root.val>=max))return false;
        if(!isValidBST(root.left,min,root.val))return false;
        if(!isValidBST(root.right,root.val,max))return false;
        return true;
    }
}
