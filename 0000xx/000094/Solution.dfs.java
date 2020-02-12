import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> retList = new LinkedList<>();
        
        dfs(retList, root);
        
        return retList;
    }
    
    public void dfs(LinkedList<Integer> retList,TreeNode node){
        if(node==null)return;
        dfs(retList,node.left);
        retList.addLast(node.val);
        dfs(retList,node.right);
    }
}
