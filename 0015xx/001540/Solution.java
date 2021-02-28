import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean canConvertString(String s, String t, int k) {
        // assumption
        if(s.length()!=t.length())return false;

        // cal shiftToCountAry
        // "input","ouput" -> 6:1,7:1
        // "abc","bcd" -> 1:3
        // "aab","bbb" -> 1:2
        int[] shiftToCountAry = new int[26];
        char[] sCharAry = s.toCharArray();
        char[] tCharAry = t.toCharArray();
        for(int i=0;i<sCharAry.length;++i){
          int sChar = (int)sCharAry[i];
          int tChar = (int)tCharAry[i];
          int shift = ((26+tChar)-sChar)%26;
          ++shiftToCountAry[shift];
        }

        // ignore i=0
        for(int i=1;i<26;++i){
          int max = k/26;
          if(i<=k%26)++max;
          if(shiftToCountAry[i]>max)return false;
        }

        return true;
    }
}
