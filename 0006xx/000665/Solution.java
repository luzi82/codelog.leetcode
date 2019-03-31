import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean good = true;
        int i=0;
        for(;i<nums.length-1;++i){
            int a=get(i,nums);
            int b=get(i+1,nums);
            if(a<=b)continue;
            good = false;
            break;
        }
        
        if(good)return true;
        
        if(get(i-1,nums)<=get(i+1,nums)){ // fix i
            nums[i] = get(i-1,nums);
        }else if(get(i,nums)<=get(i+2,nums)){ // fix i+1
            nums[i+1] = get(i,nums);
        }else{
            return false;
        }
        
        for(;i<nums.length-1;++i){
            int a=get(i,nums);
            int b=get(i+1,nums);
            if(a<=b)continue;
            return false;
        }
        return true;
    }
    
    public int get(int i,int[] nums){
        if(i<0)return Integer.MIN_VALUE;
        if(i>=nums.length)return Integer.MAX_VALUE;
        return nums[i];
    }
}
