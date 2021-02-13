import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    private final static long BIG = 1_000_000_007;
    public int countPairs(int[] deliciousness) {
        // [1,1,1,3,3,3,7]
        // -> 1:3,3:3,7:1
        HashMap<Integer,Long> dToCountMap = new HashMap<>();
        for(int d:deliciousness){
          if(dToCountMap.containsKey(d)){
            long v=dToCountMap.get(d);
            dToCountMap.put(d, v+1);
          }else{
            dToCountMap.put(d, 1L);
          }
        }

        long ret=0;
        for(int d:dToCountMap.keySet()){
          long v0 = dToCountMap.get(d);
          int i2 = 1;
          while(true){
            if(i2<d){
              i2 <<= 1;
              continue;
            }
            int d2 = i2-d;
            if(d2>d)break;
            if(d2==d){
              ret += (v0*(v0-1)/2)%BIG;
              ret %= BIG;
              break;
            }
            if(dToCountMap.containsKey(d2)){
              long v1 = dToCountMap.get(d2);
              ret += (v0 * v1)%BIG;
              ret %= BIG;
            }
            i2 <<= 1;
          }
        }
        ret %= BIG;
        return (int)ret;
    }
}
