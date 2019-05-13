import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int[] vAry;
        if(nums.length>6){
            vAry = new int[6];
            for(int i=0;i<3;++i){
                vAry[i] = nums[i];
            }
            for(int i=0;i<3;++i){
                vAry[i+3] = nums[nums.length-1-i];
            }
        }else{
            vAry=nums;
        }
        int ret = Integer.MIN_VALUE;
        for(int i=0;i<vAry.length;++i){
            for(int j=0;j<i;++j){
                for(int k=0;k<j;++k){
                    int v = vAry[i]* vAry[j]* vAry[k];
                    ret = Math.max(ret,v);
                }
            }
        }
        return ret;
    }
}
