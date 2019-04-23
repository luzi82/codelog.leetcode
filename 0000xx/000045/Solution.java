import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int jump(int[] nums) {
        int nLen = nums.length;
        if(nLen==1)return 0;
        
        int step = 0;
        int start = 0; // inclusive
        int end = 0;   // inclusive
        while(true){
            ++step;
            int nextEnd = Integer.MIN_VALUE;
            for(int i=start;i<=end;++i){
                nextEnd = Math.max(nextEnd,i+nums[i]);
                if(nextEnd>=nLen-1)return step;
            }
            start = end+1;
            end = nextEnd;
        }
    }
}
