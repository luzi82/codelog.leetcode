import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public static long BIG = 1_000_000_000L + 7L;
    public int numWays(String s) {
        int sLen = s.length();
        if(sLen<3)return 0;

        char[] sCharAry = s.toCharArray();
        Vector<Integer> onePosVec = new Vector<>();
        for(int i=0;i<sLen;++i){
          if(sCharAry[i]=='1'){
            onePosVec.add(i);
          }
        }
        int onePosVecLen = onePosVec.size();
        if(onePosVecLen%3!=0)return 0;
        if(onePosVecLen==0){
          long ret = sLen-2;
          ret = ret * (ret+1);
          ret /= 2;
          ret %= BIG;
          return (int)ret;
        }else{
          long ret0 = onePosVec.get(onePosVecLen/3) - onePosVec.get(onePosVecLen/3-1);
          long ret1 = onePosVec.get(onePosVecLen*2/3) - onePosVec.get(onePosVecLen*2/3-1);
          long ret = ret0*ret1;
          ret %= BIG;
          return (int)ret;
        }
    }
}
