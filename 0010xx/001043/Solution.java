import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// https://leetcode.com/problems/partition-array-for-maximum-sum/

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] sumA = new int[A.length+1];
        sumA[0] = 0;
        
        for(int i=1;i<sumA.length;++i){
            int max = 0;
            for(int k=1;k<=K;++k){
                int start = i-k;
                if(start<0)break;
                int maxx = 0;
                for(int m=start;m<i;++m){
                    maxx = Math.max(maxx,A[m]);
                }
                int v = maxx*k;
                v += sumA[start];
                max=Math.max(v,max);
            }
            sumA[i]=max;
        }
        return sumA[A.length];
    }
}
