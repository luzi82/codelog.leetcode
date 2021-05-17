import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        HashSet<Integer> lastBalanceSet = new HashSet<>();
        lastBalanceSet.add(0);
        HashSet<Integer> nextBalanceSet = new HashSet<>();
        
        for(int stone:stones){
            nextBalanceSet.clear();
            for(int lastBalance:lastBalanceSet){
                nextBalanceSet.add(Math.abs(lastBalance+stone));
                nextBalanceSet.add(Math.abs(lastBalance-stone));
            }
            HashSet<Integer> tmpBalanceSet = lastBalanceSet;
            lastBalanceSet = nextBalanceSet;
            nextBalanceSet = tmpBalanceSet;
        }
        
        int ret = Integer.MAX_VALUE;
        for(int balance:lastBalanceSet){
            ret = Math.min(ret,balance);
        }
        
        return ret;
    }
}
