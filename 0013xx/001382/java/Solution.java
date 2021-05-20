import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

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
    public TreeNode balanceBST(TreeNode root) {
        Vector<Integer> valueVec = new Vector<Integer>();
        dfs(valueVec,root);
        return dfs(valueVec,0,valueVec.size());
    }
    
    public void dfs(Vector<Integer> valueVec,TreeNode root){
        if(root==null)return;
        dfs(valueVec,root.left);
        valueVec.add(root.val);
        dfs(valueVec,root.right);
    }
    
    public TreeNode dfs(Vector<Integer> valueVec,int start,int end){
        if(start==end)return null;
        int mid = (start+end)/2;
        TreeNode left = dfs(valueVec,start,mid);
        TreeNode right = dfs(valueVec,mid+1,end);
        TreeNode ret = new TreeNode(valueVec.get(mid),left,right);
        return ret;
    }
    
}
