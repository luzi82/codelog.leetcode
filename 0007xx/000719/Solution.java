import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        --k;
        
        Arrays.sort(nums);
        
        // do bin search
        int min = 0;
        int max = nums[nums.length-1] - nums[0];
        ++max;
        
        while(true){
            int mid = (min+max-1)/2;
            //System.err.println(String.format("%d %d %d",min,mid,max));
            int[] rankRange = getRankRange(mid,nums);
            //System.err.println(String.format("rankRange=[%d,%d)",rankRange[0],rankRange[1]));
            if(k<rankRange[0]){max=mid;}
            else if(k<rankRange[1]){return mid;}
            else{min=mid+1;}
        }
    }
    
    public static int[] getRankRange(int len,int[] nums){
        int ltIdx = 0;
        int lteIdx = 0;
        int ltCount = 0;
        int lteCount = 0;
        for(int i=0;i<nums.length;++i){
            int n = nums[i];
            while((ltIdx<i)&&(nums[ltIdx]<=n-len))++ltIdx;
            while((lteIdx<i)&&(nums[lteIdx]<n-len))++lteIdx;
            ltCount += i-ltIdx;
            lteCount += i-lteIdx;
        }
        return new int[]{ltCount,lteCount};
   }
}
