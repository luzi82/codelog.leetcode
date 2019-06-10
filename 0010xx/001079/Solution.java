import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int numTilePossibilities(String tiles) {
        int[] tileCount = new int[26];
        HashSet<Character> charSet = new HashSet<>();
        for(char c:tiles.toCharArray()){
            charSet.add(c);
            tileCount[c-'A']++;
        }
        
        int ret= dfs(tileCount,charSet,0,tiles.length());
        
        return ret-1;
    }
    
    public int dfs(int[] tileCount,HashSet<Character> charSet,int done,int length){
        if(done==length){return 1;};
        int ret = 1;
        for(char c:charSet){
            if(tileCount[c-'A']==0)continue;
            tileCount[c-'A']--;
            ret+=dfs(tileCount,charSet,done+1,length);
            tileCount[c-'A']++;
        }
        return ret;
    }
}
