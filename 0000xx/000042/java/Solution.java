import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int trap(int[] height) {
        int cnt = height.length;
        int[] idxToMaxLeftAry = new int[cnt];
        int[] idxToMaxRightAry = new int[cnt];
        
        int maxLeft = 0;
        for(int idx=0;idx<cnt;++idx){
            maxLeft = Math.max(maxLeft,height[idx]);
            idxToMaxLeftAry[idx]=maxLeft;
        }
        
        int maxRight=0;
        for(int idx=cnt-1;idx>=0;--idx){
            maxRight = Math.max(maxRight,height[idx]);
            idxToMaxRightAry[idx]=maxRight;
        }
        
        int ret = 0;
        for(int idx=0;idx<cnt;++idx){
            ret+=Math.min(idxToMaxLeftAry[idx],idxToMaxRightAry[idx])-height[idx];
        }
        
        return ret;
    }
}
