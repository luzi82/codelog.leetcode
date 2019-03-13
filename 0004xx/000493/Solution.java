import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public int reversePairs(int[] nums) {
        if(nums.length==0)return 0;
        return dnq(nums,0,nums.length).count;
    }
    
    static class DnqResult{
        public int count = 0;
        public long[] ary;
    }
    static DnqResult dnq(int[] nums,int start,int end){
        if(end-start==1){
            DnqResult ret = new DnqResult();
            ret.ary = new long[]{nums[start]};
            return ret;
        }

        int mid=(start+end)/2;
        DnqResult lhs = dnq(nums,start,mid);
        DnqResult rhs = dnq(nums,mid,end);

        DnqResult ret = new DnqResult();
        ret.count += lhs.count;
        ret.count += rhs.count;

        {
            int rhsItr = 0;
            long rhsV=rhs.ary[rhsItr];
            for(long lhsV:lhs.ary){
                while((lhsV>2*rhsV)&&(rhsItr<rhs.ary.length)){
                    ++rhsItr;
                    if(rhsItr==rhs.ary.length){
                        rhsV = (long)Integer.MAX_VALUE+100;
                    }else{
                        rhsV = rhs.ary[rhsItr];
                    }
                }
                ret.count += rhsItr;
            }
        }
        
        {
            ret.ary = new long[lhs.ary.length+rhs.ary.length];
            int lhsItr = 0;
            int rhsItr = 0;
            int retItr = 0;
            while((lhsItr<lhs.ary.length)&&(rhsItr<rhs.ary.length)){
                if(lhs.ary[lhsItr]<rhs.ary[rhsItr]){
                    ret.ary[retItr++] = lhs.ary[lhsItr++];
                }else{
                    ret.ary[retItr++] = rhs.ary[rhsItr++];
                }
            }
            while(lhsItr<lhs.ary.length){
                ret.ary[retItr++] = lhs.ary[lhsItr++];
            }
            while(rhsItr<rhs.ary.length){
                ret.ary[retItr++] = rhs.ary[rhsItr++];
            }
        }
        
        return ret;
    }

}
