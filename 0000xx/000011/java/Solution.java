import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxArea(int[] height) {
        int ret = 0;
        int maxH = 0;
        int lIdx = 0;
        int rIdx = height.length - 1;
        
        while(lIdx<rIdx){
            int lH = height[lIdx];
            int rH = height[rIdx];
            int h = Math.min(lH,rH);
            int v = h*(rIdx-lIdx);
            if(v>ret){ret=v;}
            if(lH<rH){
                ++lIdx;
            }else{
                --rIdx;
            }
        }
        
        return ret;
    }
}
