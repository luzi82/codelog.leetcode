import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean buddyStrings(String A, String B) {
        // check len same
        if(A.length()!=B.length())return false;
        
        int sLen = A.length();
        
        // find diff count
        // mark diff idx
        int diffCount = 0;
        int diffIdx0=-1,diffIdx1=-1;
        for(int i=0;i<sLen;++i){
            char a = A.charAt(i);
            char b = B.charAt(i);
            if(a!=b){
                if(diffCount>=2)return false;
                if(diffCount==0)diffIdx0=i;
                if(diffCount==1)diffIdx1=i;
                ++diffCount;
            }
        }
        
        if(diffCount>2)return false; // defensive coding
        if(diffCount==1)return false; // one diff cannot swap
        if(diffCount==2){ // try swap
            if(A.charAt(diffIdx0)!=B.charAt(diffIdx1))return false;
            if(A.charAt(diffIdx1)!=B.charAt(diffIdx0))return false;
            return true;
        }

        // diffCount == 0, A==B, find dup char
        HashSet<Character> charSet = new HashSet<>();
        for(int i=0;i<sLen;++i){
            char a = A.charAt(i);
            if(charSet.contains(a))return true;
            charSet.add(a);
        }
        
        return false;
    }
}
