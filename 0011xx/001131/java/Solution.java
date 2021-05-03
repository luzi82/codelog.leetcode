import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ans = 0;
        for(int j=0;j<arr2.length;++j){
            for(int i=0;i<j;++i){
                int v = 0;
                v += Math.abs(arr1[i]-arr1[j]);
                v += Math.abs(arr2[i]-arr2[j]);
                v += Math.abs(i-j);
                if(v<ans)continue;
                ans=v;
            }
        }
        return ans;
    }
}
