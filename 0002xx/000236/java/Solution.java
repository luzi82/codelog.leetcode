import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    
    TreeNode p;
    TreeNode q;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p=p;
        this.q=q;
        return dfs(root,true,true).ret;
    }
    
    public DfsRet dfs(TreeNode node,boolean findP,boolean findQ){
        DfsRet ret=new DfsRet();
        if(node==null){
            return ret;
        }
        if(findP&&(node==p)){
            ret.pExist=true;
            findP=false;
        }
        if(findQ&&(node==q)){
            ret.qExist=true;
            findQ=false;
        }
        if(findP||findQ){
            DfsRet lRet = dfs(node.left,findP,findQ);
            if(lRet.pExist){
                findP=false;
                ret.pExist=true;
            }
            if(lRet.qExist){
                findQ=false;
                ret.qExist=true;
            }
            if(lRet.ret!=null){
                ret.ret=lRet.ret;
            }
        }
        if(findP||findQ){
            DfsRet rRet = dfs(node.right,findP,findQ);
            if(rRet.pExist){
                findP=false;
                ret.pExist=true;
            }
            if(rRet.qExist){
                findQ=false;
                ret.qExist=true;
            }
            if(rRet.ret!=null){
                ret.ret=rRet.ret;
            }
        }
        if(ret.pExist&&ret.qExist&&(ret.ret==null)){
            ret.ret=node;
        }
        return ret;
    }
    
    public class DfsRet{
        TreeNode ret;
        boolean pExist;
        boolean qExist;
    }
}
