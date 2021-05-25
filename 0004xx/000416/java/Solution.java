import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int v:nums){
            sum+=v;
        }

        if(sum%2==1)return false;
        
        int half = sum/2;
        
        HashSet<Integer> remainSet = new HashSet<Integer>();
        remainSet.add(half);
        
        for(int v:nums){
            LinkedList<Integer> nxtRemainList = new LinkedList<Integer>();
            for(int remain:remainSet){
                int remain0 = remain - v;
                if(remain0<0)continue;
                if(remain0==0)return true;
                nxtRemainList.add(remain0);
            }
            remainSet.addAll(nxtRemainList);
        }
        
        return false;
    }
}
