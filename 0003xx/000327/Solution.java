import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length<=0)return 0;
    
        // numSumList: sum of left int
        // [-2,5,-1,3] -> [0,-2,3,2,5]
        long[] numSumList = new long[nums.length+1];
        numSumList[0]=0;
        long tmpInt=0;
        for(int i=0;i<nums.length;++i){
            tmpInt+=nums[i];
            numSumList[i+1]=tmpInt;
        }
        
        // do divide and conquer
        DcResult dcResult = dc(numSumList, 0, numSumList.length, lower, upper);
        
        return dcResult.count;
    }
    
    public static class DcResult{
        int count;
        long[] sorted_sum_list;
    }

    //public DcResult dc(int[] numSumList, int left, int right, int lower, int upper){
    //    DcResult ret = dc2(numSumList,left,right,lower,upper);
    //    //System.out.println(String.format("left=%d, right=%d",left,right));
    //    //System.out.println(String.format("count=%d",ret.count));
    //    //System.out.println(String.format("sorted_sum_list=%s",Arrays.toString(ret.sorted_sum_list)));
    //    return ret;
    //}
    
    public DcResult dc(long[] numSumList, int left, int right, long lower, long upper){
        //System.out.println(String.format("left=%d, right=%d",left,right));
        DcResult ret=new DcResult();
        if(left==right){
            ret.count = 0;ret.sorted_sum_list=new long[0];
            return ret;
        }
        if(left+1==right){
            ret.count = 0;
            ret.sorted_sum_list=new long[]{numSumList[left]};
            return ret;
        }
        int mid = (left+right)/2;
        DcResult left_result = dc(numSumList,left,mid,lower,upper);
        DcResult right_result = dc(numSumList,mid,right,lower,upper);
        
        // shortcut
        long[] left_list = left_result.sorted_sum_list;
        long[] right_list = right_result.sorted_sum_list;
        
        // create count
        ret.count=0;
        ret.count+=left_result.count;
        ret.count+=right_result.count;
        
        int ri=0; // right_list ptr, move +1
        int li=0; // left_list ptr, rv-lv<=upper
        int lj=0; // left_list ptr, rv-lv<lower

        for(ri=0;ri<right_list.length;++ri){
            long rv = right_list[ri];

            // update li
            while(true){
                if(li>=left_list.length)break;
                if(rv-left_list[li]<=upper)break;
                li++;
            }
            
            // update lj
            while(true){
                if(lj>=left_list.length)break;
                if(rv-left_list[lj]<lower)break;
                lj++;
            }
            
            // add all lower <= rv-lv <= upper
            ret.count += lj-li;
        }
        
        // create sorted_sum_list
        ri=0; // right ptr
        li=0; // left ptr
        int oi=0; // output ptr
        
        ret.sorted_sum_list = new long[left_list.length+right_list.length];
        long[] out_list = ret.sorted_sum_list;
        for(oi=0;oi<out_list.length;++oi){
            if(ri>=right_list.length){
                out_list[oi]=left_list[li];
                ++li;
                continue;
            }
            if(li>=left_list.length){
                out_list[oi]=right_list[ri];
                ++ri;
                continue;
            }
            if(left_list[li]<right_list[ri]){
                out_list[oi]=left_list[li];
                ++li;
            }else{
                out_list[oi]=right_list[ri];
                ++ri;
            }
        }

        //System.out.println("oi done");
        
        return ret;
    }
    
    public boolean inRange(int lower,int v,int upper){
        if(v<lower)return false;
        if(v>upper)return false;
        return true;
    }
    
    public static void main(String[] argv){
        test(new int[]{-2,5,-1},-2,2,3);
        test(new int[]{-2,5,-1,3},-2,2,4);
        test(new int[]{},-2,2,0);
        test(new int[]{0},-2,2,1);
        test(new int[]{-2147483647,0,-2147483647,2147483647},-564,3864,3); // fuck leetcode
    }
    
    public static void test(int[] nums, int lower, int upper,int expected){
        System.out.println(String.format("nums=%s, lower=%d, upper=%d, expected=%d", Arrays.toString(nums), lower, upper,expected));
        Solution solution = new Solution();
        int result = solution.countRangeSum(nums,lower,upper);
        System.out.println(String.format("result=%d", result));
        aassert(result == expected);
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
