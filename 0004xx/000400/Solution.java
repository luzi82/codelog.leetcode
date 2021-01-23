import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int findNthDigit(int n) {
      // find tier
      // n=[1,9],            tier=1
      // n=[_,9+2*90],       tier=2
      // n=[_,9+2*90+3*900], tier=3
      int tier = 1;
      long tierStart = 0;
      long tierCnt = 9;
      long tierEnd = 9;
      while(true){
        if(n<=tierEnd)break;
        ++tier;
        tierStart = tierEnd;
        tierCnt *= 10;
        tierEnd += tierCnt * tier;
      }

      // shift n to n0
      // n=[1,9]            -> n0=[0,9)
      // n=[_,9+2*90]       -> n0=[0,2*90)
      // n=[_,9+2*90+3*900] -> n0=[0,3*900)
      int n0 = (int)(n - tierStart - 1);

      // tier=1,n0=[0,9)    -> nv=[1,9]
      // tier=2,n0=[0,2*90] -> nv=[10,10,11,11...99,99]
      int nv = 1;
      for(int i=1;i<tier;++i){
        nv*=10;
      }
      nv += n0/tier;

      // tier=1,n0=[0,9)    -> nd=0
      // tier=2,n0=[0,2*90] -> nd=[0,1,0,1...]
      int nd = n0 % tier;

      String nvStr = Integer.toString(nv);
      char retChar = nvStr.charAt(nd);
      return retChar-'0';
    }
}
