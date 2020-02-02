import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Vector<Integer> ret = new Vector<>();
        dfs(ret, root, 0);
        return ret;
    }
    
    public void dfs(Vector<Integer> ret, TreeNode node, int level){
        if(node==null)return;
        //System.err.println(String.format("NSMBJRTK node=%d, level=%d",node.val,level));
        while(ret.size()<=level){
            ret.add(Integer.MIN_VALUE);
        }
        int v = ret.get(level);
        v = Math.max(v, node.val);
        ret.set(level, v);
        dfs(ret, node.left, level+1);
        dfs(ret, node.right, level+1);
    }
}
