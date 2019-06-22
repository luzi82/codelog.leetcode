import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ltr = new int[nums.length];
        int[] rtl = new int[nums.length];
        int t=1;
        for(int i=0;i<nums.length;++i){
            ltr[i]=t;
            t*=nums[i];
        }
        t=1;
        for(int i=nums.length-1;i>=0;--i){
            rtl[i]=t;
            t*=nums[i];
        }
        
        int[] ret = new int[nums.length];
        for(int i=0;i<nums.length;++i){
            ret[i] = ltr[i] * rtl[i];
        }
        return ret;
    }
}
