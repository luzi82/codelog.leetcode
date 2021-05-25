import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// Slower but easier to implement

class Solution {
    final long BIG = 1000000000+7;
    int f;
    int target;
    
    public int numRollsToTarget(int d, int f, int target) {
        if(target<d)return 0;
        if(target>d*f)return 0;
        this.f = f;
        this.target = target;
        long[] sumToWayAry = getSumToWayAry(d);
        return (int)(sumToWayAry[target]);
    }
    
    HashMap<Integer,long[]> dToSumToWayAryCnt = new HashMap<>();
    long[] getSumToWayAry(int d){
        if(dToSumToWayAryCnt.containsKey(d)){
            return dToSumToWayAryCnt.get(d);
        }
        long[] ret = _getSumToWayAry(d);
        dToSumToWayAryCnt.put(d,ret);
        return ret;
    }
    
    long[] _getSumToWayAry(int d){
        if(d==0){
            long[] retAry = new long[1];
            retAry[0]=1;
            return retAry;
        }
        if(d==1){
            long[] retAry = new long[f+1];
            for(int i=1;i<=f;++i){
                retAry[i]=1;
            }
            return retAry;
        }
        int d0 = d/2;
        int d1 = d-d0;
        long[] sumToWayAry0 = getSumToWayAry(d0);
        long[] sumToWayAry1 = getSumToWayAry(d1);
        int len = sumToWayAry0.length+sumToWayAry1.length-1;
        len = Math.max(len,this.target+1);
        long[] retAry = new long[len];
        for(int sum0=0;sum0<sumToWayAry0.length;++sum0){
            long way0 = sumToWayAry0[sum0];
            for(int sum1=0;sum1<sumToWayAry1.length;++sum1){
                int sum2 = sum0+sum1;
                if(sum2>target)break;
                long way1 = sumToWayAry1[sum1];
                long way2 = way0*way1;
                way2 %= BIG;
                retAry[sum2] += way2;
                retAry[sum2] %= BIG;
            }
        }
        
        return retAry;
    }
}
