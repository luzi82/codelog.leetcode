import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2)return nums.length;
        
        int r=1;
        int w=1;
        
        while(r<nums.length){
            if(nums[r]!=nums[w-1]){
                nums[w] = nums[r];
                ++w;
                ++r;
            }else{
                ++r;
            }
        }
        
        return w;
    }
}
