import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        // 1-index to 0-index
        for(int i=0;i<nums.length;++i){
            nums[i]--;
        }
        
        for(int i=0;i<nums.length;++i){
            int j=i;
            int carry = -1;
            while(true){
                int oldNum = nums[j];
                nums[j] = carry;

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
