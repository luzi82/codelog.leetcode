import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] locUpAry = new int[1010];
        
        for(int[] trip:trips){
            locUpAry[trip[1]] += trip[0];
            locUpAry[trip[2]] -= trip[0];
        }
        
        int p = 0;
        for(int locUp:locUpAry){
            p+=locUp;
            if(p>capacity)return false;
        }
        
        return true;
    }
}
