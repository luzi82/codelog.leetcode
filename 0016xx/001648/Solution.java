import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    static final long BIG = 1_000_000_000L + 7L;

    public int maxProfit(int[] inventory, int orders) {
        long[] invAry = new long[inventory.length];
        for(int i=0;i<inventory.length;++i){
          invAry[i] = inventory[i];
        }

        Arrays.sort(invAry);
        // System.err.println(String.format("invAry=%s",Test.join(invAry)));

        long invArySum = 0;
        for(int i=0;i<invAry.length;++i){
          invArySum+=invAry[i];
        }
        // 30,28,24,16,10

        int pickSlotSize = invAry.length; // 5,4,3,2,1
        while(true){
          // System.err.println(String.format("pickSlotSize=%d",pickSlotSize));
          int testIdx = invAry.length - pickSlotSize; // 0,1,2,3,4
          long remainPerSlotMin = invAry[testIdx]; // 2,4,6,8,10
          long remain = invArySum - orders; // 10,8,4...
          long remainPerSlot = remain / pickSlotSize; // 2,4,1...
          // System.err.println(String.format("remain=%d, remainPerSlotMin=%d, remainPerSlot=%d",remain, remainPerSlotMin,remainPerSlot));
          if(remainPerSlotMin<=remainPerSlot){
            --pickSlotSize;
            invArySum -= invAry[testIdx];
            continue;
          }
          long ret = 0;
          for(int i=0;i<invAry.length;++i){
            ret += score(invAry[i],remainPerSlot);
          }
          long rremain = remain % pickSlotSize;
          ret += BIG*rremain;
          ret -= rremain * (remainPerSlot+1);
          ret %= BIG;
          return (int)ret;
        }
    }

    long score(long big,long small){
      if(big<=small)return 0;
      long v = big+small+1;
      v *= big-small;
      v /= 2;
      v %= BIG;
      return v;
    }
}
