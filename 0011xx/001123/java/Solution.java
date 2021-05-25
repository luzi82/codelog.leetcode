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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Object[] ret = dfs(root);
        TreeNode rett = (TreeNode)ret[0];
        return rett;
    }
    
    // node, int
    public Object[] dfs(TreeNode root) {
        Object[] ret = new Object[2];
        if(root==null){
            ret[0]=null;
            ret[1]=0;
            return ret;
        }
        
        if((root.left==null)&&(root.right==null)){
            ret[0]=root;
            ret[1]=1;
            return ret;
        }

        if((root.left==null)&&(root.right!=null)){
            ret = dfs(root.right);
            Integer d = (Integer)ret[1];
            ret[1] = d+1;
            return ret;
        }

        if((root.left!=null)&&(root.right==null)){
            ret = dfs(root.left);
            Integer d = (Integer)ret[1];
            ret[1] = d+1;
            return ret;
        }
        
        Object[] leftRet = dfs(root.left);
        Object[] rightRet = dfs(root.right);
        
        int leftDepth = (Integer) leftRet[1];
        int rightDepth = (Integer) rightRet[1];
        
        if(leftDepth>rightDepth){
            ret = leftRet;
            Integer d = (Integer)ret[1];
            ret[1] = d+1;
            return ret;
        }

        if(rightDepth>leftDepth){
            ret = rightRet;
            Integer d = (Integer)ret[1];
            ret[1] = d+1;
            return ret;
        }
        
        ret[0]=root;
        ret[1]=leftDepth+1;
        return ret;
    }
}
