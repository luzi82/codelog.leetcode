import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ret = 0;

        int l0 =  arr1[0]+arr2[0];
        int l1 =  arr1[0]-arr2[0];
        int l2 = -arr1[0]+arr2[0];
        int l3 = -arr1[0]-arr2[0];

        for(int i=1;i<arr1.length;++i){
          ret = Math.max(ret,l0-arr1[i]-arr2[i]+i);
          ret = Math.max(ret,l1-arr1[i]+arr2[i]+i);
          ret = Math.max(ret,l2+arr1[i]-arr2[i]+i);
          ret = Math.max(ret,l3+arr1[i]+arr2[i]+i);
          l0 = Math.max(l0, arr1[i]+arr2[i]-i);
          l1 = Math.max(l1, arr1[i]-arr2[i]-i);
          l2 = Math.max(l2,-arr1[i]+arr2[i]-i);
          l3 = Math.max(l3,-arr1[i]-arr2[i]-i);
        }

        return ret;
    }
}
