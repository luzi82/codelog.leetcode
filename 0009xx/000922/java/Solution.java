import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i0=0;
        int i1=1;
        while(true){
            // walk i0
            while(true){
                if(i0>=nums.length)break;
                if(nums[i0]%2==1)break;
                i0+=2;
            }

            // walk i1
            while(true){
                if(i1>=nums.length)break;
                if(nums[i1]%2==0)break;
                i1+=2;
            }

            if(i0>=nums.length)break;
            if(i1>=nums.length)break;
            
            int t = nums[i0];
            nums[i0]=nums[i1];
            nums[i1]=t;
            
            i0+=2;i1+=2;
        }
        return nums;
    }
}
