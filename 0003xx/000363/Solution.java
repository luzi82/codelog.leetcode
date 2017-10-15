import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;

        int len0 = matrix.length;
        int len1 = matrix[0].length;
        
        // one cell shortcut
        for(int i=0;i<len0;++i)for(int j=0;j<len1;++j){
            if(matrix[i][j]==k)return k;
        }
    
        // transpose matrix, intAryAry[short][long]
        int[][] intAryAry;
        int shortLen,longLen;
        if(len0<=len1){
            shortLen = len0;
            longLen = len1;
            intAryAry = matrix;
        }else{
            shortLen = len1;
            longLen = len0;
            intAryAry = new int[shortLen][longLen];
            for(int i=0;i<shortLen;++i)for(int j=0;j<longLen;++j){
                intAryAry[i][j] = matrix[j][i];
            }
        }
        
        // create sum matrix
        int[][] sum0AryAry = new int[shortLen][longLen+1];
        for(int i=0;i<shortLen;++i){
            int sum = 0;
            sum0AryAry[i][0] = sum;
            for(int j=0;j<longLen;++j){
                sum+=intAryAry[i][j];
                if(sum==k)return k; // short cut
                sum0AryAry[i][j+1] = sum;
            }
        }
        ++longLen;
        int[][] sumAryAry = new int[shortLen+1][longLen];
        for(int j=0;j<longLen;++j){
            int sum=0;
            sumAryAry[0][j] = sum;
            for(int i=0;i<shortLen;++i){
                sum+=sum0AryAry[i][j];
                if((j!=0)&&(sum==k))return k; // short cut
                sumAryAry[i+1][j] = sum;
            }
        }
        ++shortLen;
        
        // for all short range
        //   zip to 1D array
        //   calc the 1D array result by func
        for(int i0=0;i0<shortLen;++i0)for(int i1=i0+1;i1<shortLen;++i1){
            int[] sumAry = new int[longLen]; // sumAry[j] = sum( intAryAry[i0,i1)[j] )
            for(int j=0;j<longLen;++j){
                sumAry[j] = sumAryAry[i1][j]-sumAryAry[i0][j];
            }
            int tmpResult = maxSumAry(sumAry,k);
            result = Math.max(result, tmpResult);
            if(result==k)return result; // short cut
        }
        
        // output
        return result;
    }
    
    public int maxSumAry(int[] sumAry, int k) {
        //System.out.println(String.format("FOEVVXMG sumAry=%s, k=%d",Arrays.toString(sumAry),k));
        MaxSumAryDfsResult dfsResult = maxSumAryDfs(sumAry,0,sumAry.length,k);
        return dfsResult.maxVal;
    }
    
    public static class MaxSumAryDfsResult{
        int maxVal = Integer.MIN_VALUE;
        int[] sortedSumAry;
    }
    public MaxSumAryDfsResult maxSumAryDfs(int[] sumAry, int start, int end, int k) {
        MaxSumAryDfsResult ret=new MaxSumAryDfsResult();
        if(end-start==1){
            ret.maxVal = Integer.MIN_VALUE;
            ret.sortedSumAry = new int[]{sumAry[start]};
            return ret;
        }
        int mid = (start+end)/2;
        MaxSumAryDfsResult leftRet = maxSumAryDfs(sumAry,start,mid,k);
        if(leftRet.maxVal==k){ret.maxVal=k;return ret;} // short cut
        MaxSumAryDfsResult rightRet = maxSumAryDfs(sumAry,mid,end,k);
        if(rightRet.maxVal==k){ret.maxVal=k;return ret;} // short cut
        
        ret.maxVal = Math.max(ret.maxVal,leftRet.maxVal);
        ret.maxVal = Math.max(ret.maxVal,rightRet.maxVal);
        
        // find max sum
        int leftPtr = 0;
        for(int rightPtr=0;rightPtr<rightRet.sortedSumAry.length;++rightPtr){
            while(true){
                if(leftPtr>=leftRet.sortedSumAry.length)break;
                if(rightRet.sortedSumAry[rightPtr] - leftRet.sortedSumAry[leftPtr] <= k)break;
                ++leftPtr;
            }
            if(leftPtr>=leftRet.sortedSumAry.length)break;
            int sum = rightRet.sortedSumAry[rightPtr] - leftRet.sortedSumAry[leftPtr];
            if(sum==k){ret.maxVal=k;return ret;} // short cut
            ret.maxVal = Math.max(ret.maxVal,sum);
        }
        
        // create sorted array
        ret.sortedSumAry=new int[end-start];
        leftPtr = 0;
        int rightPtr = 0;
        for(int i=0;i<ret.sortedSumAry.length;++i){
            if(leftPtr>=leftRet.sortedSumAry.length){
                ret.sortedSumAry[i]=rightRet.sortedSumAry[rightPtr];
                ++rightPtr;
            }else if(rightPtr>=rightRet.sortedSumAry.length){
                ret.sortedSumAry[i]=leftRet.sortedSumAry[leftPtr];
                ++leftPtr;
            }else if(leftRet.sortedSumAry[leftPtr]<=rightRet.sortedSumAry[rightPtr]){
                ret.sortedSumAry[i]=leftRet.sortedSumAry[leftPtr];
                ++leftPtr;
            }else{
                ret.sortedSumAry[i]=rightRet.sortedSumAry[rightPtr];
                ++rightPtr;
            }
        }
        
        return ret;
    }
}
