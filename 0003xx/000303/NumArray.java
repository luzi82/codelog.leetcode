import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class NumArray {

    long[] sums;

    public NumArray(int[] nums) {
        this.sums = new long[nums.length+1];
        for(int i=0;i<nums.length;++i){
            this.sums[i+1] = this.sums[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return (int)( this.sums[j+1] - this.sums[i]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
 