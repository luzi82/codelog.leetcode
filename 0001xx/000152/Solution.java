import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxProduct(int[] nums) {
        int ret = Integer.MIN_VALUE;
    
        int start=0;
        for(int i=0;i<=nums.length;++i){
            if((i==nums.length)||(nums[i]==0)){
                ret = Math.max(ret,getMax(nums,start,i));
                start = i+1;
            }
            if(i==nums.length)break;
            if(nums[i]==0)ret=Math.max(ret,0);
        }
        
        return ret;
    }
    
    public static int getMax(int[] nums,int start,int end){
        if(start>=end)return Integer.MIN_VALUE;
        int ret = Integer.MIN_VALUE;
        int v = 1;
        for(int i=start;i<end;++i){
            v*=nums[i];
            ret = Math.max(ret,v);
        }
        v = 1;
        for(int i=end-1;i>=start;--i){
            v*=nums[i];
            ret = Math.max(ret,v);
        }
        return ret;
    }
}
