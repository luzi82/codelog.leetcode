import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public void flatten(TreeNode root) {
        if(root==null)return;
        dfs(root);
    }
    
    public TreeNode dfs(TreeNode root){
        if(root==null)return null;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = null;

        TreeNode ret = root;
        if(left!=null){
            ret.right = left;
            ret = dfs(left);
        }
        if(right!=null){
            ret.right = right;
            ret = dfs(right);
        }
        
        return ret;
    }
}
