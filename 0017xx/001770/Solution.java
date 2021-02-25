import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] totalLeftDpAryAry = new int[multipliers.length+1][multipliers.length+1];
        totalLeftDpAryAry[0][0] = 0;

        for(int totalDone=1;totalDone<=multipliers.length;++totalDone){
          for(int leftDone=0;leftDone<=totalDone;++leftDone){
            int v = Integer.MIN_VALUE;
            int leftIdx = leftDone-1;
            if(leftIdx>=0){
              v = Math.max(v,totalLeftDpAryAry[totalDone-1][leftDone-1] + nums[leftIdx]*multipliers[totalDone-1]);
            }
            int rightIdx = nums.length - totalDone + leftDone;
            if(rightIdx<nums.length){
              v = Math.max(v,totalLeftDpAryAry[totalDone-1][leftDone] + nums[rightIdx]*multipliers[totalDone-1]);
            }
            //System.err.println(String.format("t=%d l=%d v=%d",total));
            totalLeftDpAryAry[totalDone][leftDone] = v;
          }
        }

        int ret = Integer.MIN_VALUE;
        for(int leftDone=0;leftDone<=multipliers.length;++leftDone){
          ret = Math.max(ret,totalLeftDpAryAry[multipliers.length][leftDone]);
        }
        return ret;
    }
}
