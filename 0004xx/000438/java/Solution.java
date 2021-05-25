import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> startList = new LinkedList<>();
        
        int[] dToRemainCntAry = new int[26];
        for(char c:p.toCharArray()){
            int d = c-'a';
            ++dToRemainCntAry[d];
        }
        
        int totalPositiveRemain = p.length();
        
        for(int end=0;end<s.length();++end){
            char c = s.charAt(end);
            int d = c-'a';
            int oldRemainCnt = dToRemainCntAry[d];
            int newRemainCnt = oldRemainCnt-1;
            dToRemainCntAry[d] = newRemainCnt;
            totalPositiveRemain -= Math.max(0,oldRemainCnt);
            totalPositiveRemain += Math.max(0,newRemainCnt);
            int start = end-p.length();
            if(start>=0){
                c = s.charAt(start);
                d = c-'a';
                oldRemainCnt = dToRemainCntAry[d];
                newRemainCnt = oldRemainCnt+1;
                dToRemainCntAry[d] = newRemainCnt;
                totalPositiveRemain -= Math.max(0,oldRemainCnt);
                totalPositiveRemain += Math.max(0,newRemainCnt);
            }
            if(totalPositiveRemain==0){
                startList.add(start+1);
            }
        }
        
        return startList;
    }
}
