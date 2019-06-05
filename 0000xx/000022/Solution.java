import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        LinkedList<String> retList = new LinkedList<>();
        
        dfs(retList,new char[n*2],0,0,n);
        
        return retList;
    }
    
    void dfs(LinkedList<String> retList,char[] buf,int done,int level,int nRemain){
        if(done==buf.length){
            retList.addLast(new String(buf));
            return;
        }
        
        if(nRemain>0){
            buf[done]='(';
            dfs(retList,buf,done+1,level+1,nRemain-1);
        }
        
        if(level>0){
            buf[done]=')';
            dfs(retList,buf,done+1,level-1,nRemain);
        }
    }
}
