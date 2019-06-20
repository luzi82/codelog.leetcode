import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null){
            return null;
        }if(root.val<L){
            return trimBST(root.right,L,R);
        }else if(root.val<=R){
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
            return root;
        }else{
            return trimBST(root.left,L,R);
        }        
    }
}
