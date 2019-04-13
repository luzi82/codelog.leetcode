import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public double new21Game(int N, int K, int W) {
        if(N>=K-1+W)return 1;
        if(N<K)return 0;
        if(K==0)return 1;

        double[] probAry = new double[K];
        double[] probSumAry = new double[K]; // probSumAry[i] = probAry[0]+...+probAry[i]
        
        probAry[0] = 1;
        probSumAry[0] = 1;
        
        for(int i=1;i<K;++i){
            double probSum = probSumAry[i-1];
            if(i-W-1>=0){probSum-=probSumAry[i-W-1];}
            
            double prob = probSum/W;
            
            probAry[i] = prob;
            probSumAry[i] = probSumAry[i-1] + prob;
        }
        
        double ret=0;
        for(int i=K;i<=N;++i){
            double probSum = probSumAry[K-1];
            if(i-W-1>=0){probSum-=probSumAry[i-W-1];}
            
            double prob = probSum/W;
            
            ret += prob;
        }
        
        return ret;
    }
}
