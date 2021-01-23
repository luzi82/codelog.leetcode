import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
      // convert 1010010001 to 0-1010010001-01
      // 0-1010010001-01 convert to 1,1,2,3,1
      Vector<Integer> zeroLenList = new Vector<>();
      int tmp0 = 0;
      for(int i=-1;i<flowerbed.length+2;++i){
        int v=(i==-1)?0:
              (i<flowerbed.length)?flowerbed[i]:
              (i==flowerbed.length)?0:
              1;
        if(v==0){
          ++tmp0;
        }else{
          zeroLenList.add(tmp0);
          tmp0=0;
        }
      }

      // get max n
      int maxN = 0;
      for(int zeroLen:zeroLenList){
        int addN = (zeroLen-1)/2;
        addN = Math.max(0,addN);
        maxN += addN;
      }

      // test n
      return n <= maxN;
    }
}
