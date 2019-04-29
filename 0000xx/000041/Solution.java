import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        // nums = {3,4,-1,1}
    
        // 1-index to 0-index
        for(int i=0;i<nums.length;++i){
            nums[i]--; // nums = {2,3,-2,0}
        }
        
        for(int i=0;i<nums.length;++i){
            int j=i; // j = [0,nums.length)
            int carry = -1;
            while(true){ // first case
                int oldNum = nums[j]; // oldNum = 2
                nums[j] = carry; // nums = {-1,3,-2,0}

                if(oldNum==j){nums[j]=oldNum;break;}
                if(oldNum<0)break;
                if(oldNum>=nums.length)break;

                carry = oldNum;
                j = oldNum;
            }
        }
        
        for(int i=0;i<nums.length;++i){
            if(nums[i]!=i)return i+1;
        }
        
        return nums.length+1;
    }
}
