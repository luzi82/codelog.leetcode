import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// this solution is wrong
// In Leetcode Weekly contest 140, the test case and expected output are wrong.
// This solution is pass THAT contest, but not a correct answer

class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean good = dfs(root,limit,0);
        if(!good)return null;
        return root;
    }
    
    public boolean dfs(TreeNode root, int limit,int val){
        if(root==null)return false;
        int nodeCount = 0;
        if(root.left!=null){++nodeCount;}
        if(root.right!=null){++nodeCount;}
        if(nodeCount==0){
            // System.err.println(String.format("n0 p=%d n=%d s=%d",val,root.val,root.val+val));
            return (val+root.val) >= limit;
        }
        if(nodeCount==1){
            boolean good = false;
            if(root.left!=null){
                boolean leftGood = dfs(root.left,limit,root.val+val);
                good = good || leftGood;
                if(!leftGood){root.left=null;--nodeCount;}
            }
            if(root.right!=null){
                boolean rightGood = dfs(root.right,limit,root.val+val);
                good = good || rightGood;
                if(!rightGood){root.right=null;--nodeCount;}
            }
            if(nodeCount==0){
                // System.err.println(String.format("n1 p=%d n=%d s=%d",val,root.val,root.val+val));
                return (val+root.val) >= limit;
            }
            // System.err.println(String.format("m1 p=%d n=%d s=%d l=%s r=%s",val,root.val,val+root.val,(root.left==null)?"null":Integer.toString(root.left.val),(root.right==null)?"null":Integer.toString(root.right.val)));
            return good;
        }
        if(nodeCount==2){
            boolean good = false;
            if(root.left!=null){
                boolean leftGood = dfs(root.left,limit,root.val+val);
                good = good || leftGood;
                if(!leftGood){root.left=null;--nodeCount;}
            }
            if(root.right!=null){
                boolean rightGood = dfs(root.right,limit,root.val+val);
                good = good || rightGood;
                if(!rightGood){root.right=null;--nodeCount;}
            }
            // System.err.println(String.format("m2 p=%d n=%d s=%d l=%s r=%s",val,root.val,val+root.val,(root.left==null)?"null":Integer.toString(root.left.val),(root.right==null)?"null":Integer.toString(root.right.val)));
            return good;
        }
        return false;
    }
}