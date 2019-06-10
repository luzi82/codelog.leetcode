import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String smallestSubsequence(String text) {
        char[] charAry = text.toCharArray();

        HashSet<Character> charSet = new HashSet<>();
        for(char c:charAry){
            charSet.add(c);
        }
        
        StringBuffer sb = new StringBuffer();
        int start = 0;
        while(!charSet.isEmpty()){
            HashSet<Character> charSet0 = new HashSet<>(charSet);
            char nextChar = Character.MAX_VALUE;
            int nextStart = -1;
            for(int i=charAry.length-1;i>=start;--i){
                char c = charAry[i];
                if(!charSet.contains(c)){continue;}
                if(charSet0.contains(c)){
                    charSet0.remove(c);
                }
                if(charSet0.isEmpty()){
                    if(c<=nextChar){
                        nextChar=c;
                        nextStart=i+1;
                    }
                }
            }
            sb.append(nextChar);
            charSet.remove(nextChar);
            start = nextStart;
        }
        
        return sb.toString();
    }
}
