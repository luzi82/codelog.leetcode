import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String customSortString(String S, String T) {
        char[] sCharAry = S.toCharArray();
        char[] tCharAry = T.toCharArray();
        
        HashMap<Character,Integer> cToIMap = new HashMap<>();
        HashMap<Integer,Character> iToCMap = new HashMap<>();
        
        for(int i=0;i<sCharAry.length;++i){
            char c = sCharAry[i];
            int v = i*1000+1000000;
            cToIMap.put(c,v);
            iToCMap.put(v,c);
        }
        
        int[] tIntAry = new int[tCharAry.length];
        for(int i=0;i<tCharAry.length;++i){
            char c = tCharAry[i];
            int v = c;
            if(cToIMap.containsKey(c)){
                v = cToIMap.get(c);
            }
            tIntAry[i] = v;
        }
        
        Arrays.sort(tIntAry);
        
        char[] retAry = new char[tCharAry.length];
        for(int i=0;i<tCharAry.length;++i){
            int v = tIntAry[i];
            char c = 0;
            if(iToCMap.containsKey(v)){
                c = iToCMap.get(v);
            }else{
                c = (char)v;
            }
            retAry[i] = c;
        }
        
        return new String(retAry);
    }
}
