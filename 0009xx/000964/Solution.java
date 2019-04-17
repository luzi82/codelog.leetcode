import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        int[] targetBasedAry = getBasedAry(target,x);
        int[][] weightAryAry = getWeightAryAry(targetBasedAry,x);
        int[][] scoreAryAry = getScoreAryAry(weightAryAry);
        int[][] dpAryAry = getDpAryAry(scoreAryAry);
        
        int dpAryAryLen = dpAryAry.length;
        int[] dpAry = dpAryAry[dpAryAryLen-1];
        return Math.min(dpAry[0],dpAry[1])-1;
    }
    
    // break target into x-based presentation, little-endian, add tail zero
    // (19,3)  -> [1,0,2,0]
    // (501,5) -> [1,0,0,4,0]
    public static int[] getBasedAry(int target,int x){
        long xx = 1;
        int len = 1;
        while(xx<=target){xx*=x;++len;}
        int[] retAry = new int[len];
        int idx = len-1;
        while(xx>0){
            retAry[idx] = (int)(target/xx);
            target%=xx;
            xx/=x;
            --idx;
        }
        return retAry;
    }
    
    // ([2,1,0],100)
    // [2,1,0] x [+1,+0,+1-100,-100] -> [ [3,2,-97,-98], [2,1,-98,-99], [1,0,-99,-100] ]
    //         x abs -> [ [3,2,97,98], [2,1,98,99], [1,0,99,100] ]
    public static int[][] getWeightAryAry(int[] targetBasedAry,int x){
        int[][] retAryAry = new int[targetBasedAry.length][4];
        for(int i=0;i<targetBasedAry.length;++i){
            int[] retAry = retAryAry[i];
            int targetBased = targetBasedAry[i];
            retAry[0] = Math.abs(targetBased+1  );
            retAry[1] = Math.abs(targetBased    );
            retAry[2] = Math.abs(targetBased+1-x);
            retAry[3] = Math.abs(targetBased  -x);
        }
        return retAryAry;
    }
    
    // [0,1,2,3...9] * [_2_,1,2,3...9]
    public static int[][] getScoreAryAry(int[][] weightAryAry){
        int[][] retAryAry = weightAryAry;
        for(int i=0;i<retAryAry.length;++i){
            int[] weightAry = retAryAry[i];
            int m=(i==0)?2:i;
            for(int j=0;j<weightAry.length;++j){
                weightAry[j] *= m;
            }
        }
        return retAryAry;
    }
    
    public static int[][] getDpAryAry(int[][] scoreAryAry){
        int[][] retAryAry = scoreAryAry;
        retAryAry[0][0] = Integer.MAX_VALUE;
        retAryAry[0][2] = Integer.MAX_VALUE;
        for(int i=1;i<retAryAry.length;++i){
            int minus0 = Math.min(retAryAry[i-1][0],retAryAry[i-1][1]);
            int minusX = Math.min(retAryAry[i-1][2],retAryAry[i-1][3]);
            retAryAry[i][0] += minusX;
            retAryAry[i][1] += minus0;
            retAryAry[i][2] += minusX;
            retAryAry[i][3] += minus0;
        }
        return retAryAry;
    }
}
