import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    
    final long BIG = 1000000000L+7;
    int d;
    int f;
    int target;
    
    public int numRollsToTarget(int d, int f, int target) {
        this.d=d;
        this.f=f;
        this.target=target;
        
        if(target>d*f)return 0;
        if(target<d)return 0;
        
        long[] valueToWayCnt = new long[f+1];
        for(int i=1;i<=f;++i){
            valueToWayCnt[i]=1;
        }
        
        valueToWayCnt = recursive(1,valueToWayCnt);
        
        return (int)valueToWayCnt[target];
    }
    
    public long[] recursive(int dd,long[] valueToWayCnt){
        if(dd>d){
            long[] retAry = new long[1];
            retAry[0]=1;
            return retAry;
        }
        long[] valueToWayCnt3 = null;
        if(d>=dd*2){
            long[] valueToWayCnt2 = mergeAry(valueToWayCnt,valueToWayCnt);
            valueToWayCnt3 = recursive(dd*2,valueToWayCnt2);
        }else{
            valueToWayCnt3 = new long[1];
            valueToWayCnt3[0]=1;
        }
        if(dd>d){
            return valueToWayCnt3;
        }else{
            d-=dd;
            return mergeAry(valueToWayCnt3,valueToWayCnt);
        }
    }
    
    long[] mergeAry(long[] aAry,long[] bAry){
      int size = Math.min((aAry.length-1)+(bAry.length-1)+1,target+1);
      long[] retAry = new long[size];
      for(int i=0;i<aAry.length;++i){
          for(int j=0;j<bAry.length;++j){
              int k = i+j;
              if(k>target)break;
              retAry[k] += aAry[i]*bAry[j];
              retAry[k] %= BIG;
          }
      }
      return retAry;
    }
}
