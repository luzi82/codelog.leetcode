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
    public int maxPathSum(TreeNode root) {
        int[] dfsRet = dfs(root);
        return dfsRet[0];
    }
    
    // 0: max sum, 1: max sum to leaf
    // root != null
    public int[] dfs(TreeNode root){
        int[] ret = new int[]{root.val,root.val};
        
        int[] leftDfs = null;
        if(root.left!=null){
            leftDfs = dfs(root.left);
            ret[0] = Math.max(ret[0], leftDfs[0]);
            ret[0] = Math.max(ret[0], root.val+leftDfs[1]);
            ret[1] = Math.max(ret[1], root.val+leftDfs[1]);
        }

        int[] rightDfs = null;
        if(root.right!=null){
            rightDfs = dfs(root.right);
            ret[0] = Math.max(ret[0], rightDfs[0]);
            ret[0] = Math.max(ret[0], root.val+rightDfs[1]);
            ret[1] = Math.max(ret[1], root.val+rightDfs[1]);
        }
        
        if((leftDfs!=null)&&(rightDfs!=null)){
            ret[0] = Math.max(ret[0], root.val+leftDfs[1]+rightDfs[1]);
        }
        
        return ret;
    }
}
