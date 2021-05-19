import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        char[][] cAryAry = new char[strs.length][];
        for(int i=0;i<strs.length;++i){
            cAryAry[i] = strs[i].toCharArray();
        }
        
        int len = 0;
        while(true){
            boolean good = true;
            for(int i=0;i<cAryAry.length;++i){
                if(cAryAry[i].length<=len){
                    good=false;break;
                }
                if(cAryAry[i][len]==cAryAry[0][len])continue;
                good = false;
                break;
            }
            if(!good)break;
            ++len;
        }
        
        return strs[0].substring(0,len);
    }
}
