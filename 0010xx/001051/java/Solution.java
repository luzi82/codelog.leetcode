import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int heightChecker(int[] heights) {
        int[] sorted_heights = heights.clone();
        Arrays.sort(sorted_heights);
        int ret = 0;
        for(int i=0;i<heights.length;++i){
            if(sorted_heights[i]!=heights[i])++ret;
        }
        return ret;
    }
}
