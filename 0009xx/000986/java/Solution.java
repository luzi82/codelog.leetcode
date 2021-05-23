import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        Vector<int[]> retSeVec = new Vector<int[]>();
        
        int firstIdx = 0;
        int secondIdx = 0;
        while(true){
            if(firstIdx>=firstList.length)break;
            if(secondIdx>=secondList.length)break;
            int firstStart = firstList[firstIdx][0];
            int firstEnd = firstList[firstIdx][1];
            int secondStart = secondList[secondIdx][0];
            int secondEnd = secondList[secondIdx][1];
            int[] se = new int[]{Math.max(firstStart,secondStart),Math.min(firstEnd,secondEnd)};
            if(se[0]<=se[1]){
                retSeVec.add(se);
            }
            if(firstEnd<secondEnd){
                ++firstIdx;
            }else{
                ++secondIdx;
            }
        }
        
        return retSeVec.toArray(new int[0][]);
    }
}
