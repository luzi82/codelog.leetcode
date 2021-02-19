import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    static final long BIG = 1_000_000_000L + 7;
    public int waysToSplit(int[] nums) {
        int[] sumAry = new int[nums.length+1];
        sumAry[0]=0;
        for(int i=0;i<nums.length;++i){
          sumAry[i+1] = sumAry[i] + nums[i];
        }
        int sumX = sumAry[sumAry.length-1];

        long ret = 0;
        int a=1;
        int b=1;
        int c=2;

        while(true){
          if(c>=nums.length)break;

          while(true){
            if(b>=c)break;
            if(sumAry[b]-sumAry[0]>sumAry[c]-sumAry[b])break;
            ++b;
          }

          while(true){
            if(a>=c)break;
            if(sumX-sumAry[c]>=sumAry[c]-sumAry[a])break;
            ++a;
          }

          System.err.println(String.format("a=%d, b=%d, c=%d",a,b,c));
          if(a<b){
            ret+=b-a;
            ret%=BIG;
          }

          ++c;
        }

        return (int)ret;
    }
}
