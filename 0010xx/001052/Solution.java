import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ret = 0;
        for(int i=0;i<customers.length;++i){
            if(grumpy[i]==0){
                ret += customers[i];
                customers[i] = 0;
            }
        }
        
        int windowMax = 0;
        int window = 0;
        for(int i=0;i<X;++i){
            window += customers[i];
        }
        windowMax = Math.max(windowMax,window);
        
        for(int i=X;i<customers.length;++i){
            window += customers[i];
            window -= customers[i-X];
            windowMax = Math.max(windowMax,window);
        }
        
        ret += windowMax;
        return ret;
    }
}
