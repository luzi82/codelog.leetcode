import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] candyBorder = new long[candiesCount.length+1];
        candyBorder[0] = 0;
        for(int i=0;i<candiesCount.length;++i){
          candyBorder[i+1] = candyBorder[i] + candiesCount[i];
        }
        // System.err.println(String.format("candyBorder=%s",Test.join(candyBorder)));

        boolean[] retAry = new boolean[queries.length];
        for(int qIdx=0;qIdx<queries.length;++qIdx){
          int[] qAry = queries[qIdx];
          int fType = qAry[0];
          int fDay = qAry[1];
          long dCap = qAry[2];

          long cMin = candyBorder[fType];
          long cMax = candyBorder[fType+1];

          long eatMin = 1*fDay;
          long eatMax = dCap*(fDay+1);

          // System.err.println(String.format("cMin=%d, cMax=%d, eatMin=%d, eatMax=%d",cMin,cMax,eatMin,eatMax));

          retAry[qIdx] = overlap(cMin,cMax,eatMin,eatMax);
        }
        return retAry;
    }

    boolean overlap(long s0,long e0,long s1,long e1){
      if(e0<=s1)return false;
      if(e1<=s0)return false;
      return true;
    }
}
