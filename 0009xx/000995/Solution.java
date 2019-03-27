import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int mergeStones(int[] stones, int K) {
        if(K!=2)if(stones.length%(K-1)!=1)return -1;
    
        Unit u=new Unit();
        u.K = K;
        u.sumAry = new int[stones.length+1];
        u.sumAry[0] = 0;
        for(int i=0;i<stones.length;++i){
            u.sumAry[i+1] = u.sumAry[i]+stones[i];
        }
        u.cacheAryAryAry = new int[stones.length+1][stones.length+1][K+1];
        
        return u.get(0,stones.length,1);
    }
    
    static class Unit{
        int K;
        int[] sumAry;
        int[][][] cacheAryAryAry;
        int get(int start,int end,int div){
            if(cacheAryAryAry[start][end][div]==0){
                cacheAryAryAry[start][end][div]=cal(start,end,div);
            }
            return cacheAryAryAry[start][end][div];
        }
        int cal(int start,int end,int div){
            if(end-start==1)return 0;
            if(div==1)return cal(start,end,K)+sumAry[end]-sumAry[start];
            int min=Integer.MAX_VALUE;
            for(int m=start+1;m<=end-(div-1);m+=K-1){
                int lhs=get(start,m,1);
                int rhs=get(m,end,div-1);
                int sum = lhs+rhs;
                if(sum<min)min=sum;
            }
            return min;
        }
    }
}
