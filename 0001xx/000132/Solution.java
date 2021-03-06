import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// accepted, runtime O(n^2), mem O(n)

class Solution {
    public int minCut(String s) {
        if(s.length()==0)return -1;
        if(s.length()==1)return 0;
        
        int[] pivotHeightAry = getPivotHeightAry(s);
        int[] minJumpCountAry = getMinJumpCountAry(pivotHeightAry);
        
        return minJumpCountAry[minJumpCountAry.length-1]-1;
    }
    
    public static int[] getPivotHeightAry(String s){
        final int sLen = s.length();
        int[] ret = new int[sLen*2-1];
        int readEndPtr = 0;
        int writePivotHeightPtr = 0;
        while(true){
            //System.err.println(String.format("NKZCWOLWOC ret=%s, w=%d, r=%d",Test.join(ret),writePivotHeightPtr,readEndPtr));
            if(writePivotHeightPtr>=ret.length)return ret;
            char lhs = getChar(s,writePivotHeightPtr+writePivotHeightPtr-readEndPtr);
            char rhs = getChar(s,readEndPtr);
            if(lhs==rhs){++readEndPtr;continue;}
            int pivotHeight = readEndPtr-writePivotHeightPtr;
            ret[writePivotHeightPtr] = pivotHeight;
            if(pivotHeight==1){++writePivotHeightPtr;continue;}
            for(int i=1;i<pivotHeight;++i){
                int lhsPtr = writePivotHeightPtr-i;
                int rhsPtr = writePivotHeightPtr+i;
                int lhsHeight = ret[lhsPtr];
                if(lhsHeight+i<pivotHeight){
                    ret[rhsPtr] = lhsHeight;
                    continue;
                }
                writePivotHeightPtr=rhsPtr;
                break;
            }
        }
    }
    
    public static char getChar(String s,int idx){
        if(idx<0)return (char)-1;
        if(idx>=s.length()*2-1)return (char)-2;
        if(idx%2==1)return (char)-3;
        return s.charAt(idx/2);
    }

    public static int[] getMinJumpCountAry(int[] pivotHeightAry){
        int len = ((pivotHeightAry.length+1)/2)+1;
        int[] retA = new int[len];
        retA[0] = 0;
        for(int rhs=1;rhs<len;++rhs){
            int ret = len;
            for(int lhs=0;lhs<rhs;++lhs){
                if(!canJump(lhs,rhs,pivotHeightAry))continue;
                ret = Math.min(ret,retA[lhs]+1);
            }
            retA[rhs] = ret;
        }
        return retA;
    }
    
    public static boolean canJump(int lhs,int rhs,int[] pivotHeightAry){
        if(rhs==lhs+1)return true;
        int pivot = lhs+rhs-1;
        int height = rhs-lhs;
        return pivotHeightAry[pivot] >= height;
    }
}
