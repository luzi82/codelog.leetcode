import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int len = A.length;

        // filter bad number
        boolean[] badNumber = new boolean[7];
        badNumber[0]=true;
        for(int j=1;j<badNumber.length;++j){
            for(int i=0;i<len;++i){
                if(A[i]==j)continue;
                if(B[i]==j)continue;
                badNumber[j] = true;
                break;
            }
        }
        
        // no good number, return -1
        boolean existGood = false;
        for(int j=0;j<badNumber.length;++j){
            if(!badNumber[j]){
                existGood = true;
                break;
            }
        }
        if(!existGood)return -1;
        
        // cal
        int ret = Integer.MAX_VALUE;
        for(int j=0;j<badNumber.length;++j){
            if(badNumber[j])continue;
            int ret0 = 0;
            for(int i=0;i<len;++i){
                if(A[i]!=j)++ret0;
            }
            ret = Math.min(ret,ret0);
            ret0 = 0;
            for(int i=0;i<len;++i){
                if(B[i]!=j)++ret0;
            }
            ret = Math.min(ret,ret0);
        }
        
        return ret;
    }
}
