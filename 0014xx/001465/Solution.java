import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    static long BIG = 1_000_000_000L + 7;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
      long maxH = findMax(h,horizontalCuts);
      long maxV = findMax(w,verticalCuts);
      long maxArea = maxH * maxV;
      maxArea %= BIG;
      return (int)maxArea;
    }

    public int findMax(int max,int[] cut){
      int ret = 0;

      // sort cut
      int[] cutSort = Arrays.copyOf(cut, cut.length);
      Arrays.sort(cutSort);

      // head/tail case
      ret = Math.max(ret, cutSort[0]);
      ret = Math.max(ret, max-cutSort[cutSort.length-1]);

      // mid cases
      for(int i=0;i<cutSort.length-1;++i){
        int a=cutSort[i];
        int b=cutSort[i+1];
        ret = Math.max(ret, b-a);
      }

      return ret;
    }
}
