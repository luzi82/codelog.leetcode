import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] dToMaxCntAry = new int[26];
        for(char c:chars.toCharArray()){
            int d = c-'a';
            ++dToMaxCntAry[d];
        }
        
        int ret = 0;
        for(String str:words){
            boolean good = true;
            int[] dToCntAry = new int[26];
            for(char c:str.toCharArray()){
                int d = c-'a';
                ++dToCntAry[d];
                if(dToCntAry[d]>dToMaxCntAry[d]){
                    good=false;
                    break;
                }
            }
            if(good){
                ret += str.length();
            }
        }
        
        return ret;
    }
}
