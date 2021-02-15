import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minCharacters(String a, String b) {
        int[] aCharCnt = new int[26];
        for(char c:a.toCharArray()){
          int cc = c-'a';
          ++aCharCnt[cc];
        }

        int[] bCharCnt = new int[26];
        for(char c:b.toCharArray()){
          int cc = c-'a';
          ++bCharCnt[cc];
        }

        int[] aCharSum = new int[27];
        for(int i=0;i<26;++i){
          aCharSum[i+1]=aCharCnt[i]+aCharSum[i];
        }

        int[] bCharSum = new int[27];
        for(int i=0;i<26;++i){
          bCharSum[i+1]=bCharCnt[i]+bCharSum[i];
        }

        int ret = Integer.MAX_VALUE;

        // case 1
        for(int i=1;i<26;++i){
          int bigA = aCharSum[26]-aCharSum[i];
          int smallB = bCharSum[i]-bCharSum[0];
          ret = Math.min(ret,bigA+smallB);
        }

        // case 2
        for(int i=1;i<26;++i){
          int smallA = aCharSum[i]-aCharSum[0];
          int bigB = bCharSum[26]-bCharSum[i];
          ret = Math.min(ret,smallA+bigB);
        }

        // case 3
        for(int i=0;i<26;++i){
          int diffA = aCharSum[26]-aCharCnt[i];
          int diffB = bCharSum[26]-bCharCnt[i];
          ret = Math.min(ret,diffA+diffB);
        }

        return ret;
      }
}
