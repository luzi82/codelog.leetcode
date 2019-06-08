import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rnCharCount = toCharCount(ransomNote);
        int[] mCharCount = toCharCount(magazine);
        for(int i=0;i<26;++i){
            if(rnCharCount[i]>mCharCount[i])return false;
        }
        return true;
    }
    
    int[] toCharCount(String v){
        int[] ret = new int[26];
        for(char c:v.toCharArray()){
            ret[c-'a']++;
        }
        return ret;
    }
}
