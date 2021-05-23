import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean existInc = false;
        boolean existDec = false;
        for(int i=0;i<nums.length-1;++i){
            int a = nums[i];
            int b = nums[i+1];
            existInc = existInc || (a<b);
            existDec = existDec || (a>b);
        }
        return !(existInc&&existDec);
    }
}
