import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int longestSubstring(String s, int k) {
        char[] cAry = s.toCharArray();
        return longestSubstring(cAry, 0, cAry.length, k);
    }
    
    public int longestSubstring(char[] cAry, int start, int end, int k) {
        //System.err.println(String.format("start=%d, end=%d",start,end));
        if(end<=start)return 0;

        HashMap<Character, Integer> cCount=new HashMap<>();
        for(int i=start;i<end;++i){
            char c=cAry[i];
            if(!cCount.containsKey(c)){
                cCount.put(c,0);
            }
            cCount.put(c,cCount.get(c)+1);
        }
        
        boolean good = true;
        for(char c:cCount.keySet()){
            int count = cCount.get(c);
            if(count>=k)continue;
            good=false;
            break;
        }
        
        if(good) return (end-start);
        
        int ret = 0;
        
        int ss=start;
        for(int i=start;i<=end;++i){
            if((i>=end)||(cCount.get(cAry[i]))<k){
                int v = longestSubstring(cAry,ss,i,k);
                ret = Math.max(ret,v);
                ss = i+1;
            }
        }
        
        return ret;
    }
}
