import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minCut(String s) {
        if(s.length()==0)return -1;
        if(s.length()==1)return 0;
        
        int[] pivotHeightAry = getPivotHeightAry(s);
        boolean[][] jumpAryAry = getJumpAryAry(pivotHeightAry); // [from][to]
        //System.err.println(Test.join(jumpAryAry));
        int[] minJumpCountAry = getMinJumpCountAry(jumpAryAry);
        
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

    public static boolean[][] getJumpAryAry(int[] pivotHeightAry){
        int sLen = (pivotHeightAry.length+1)/2;
        boolean[][] retAA = new boolean[sLen+1][sLen+1];
        for(int pivotIdx=0;pivotIdx<pivotHeightAry.length;++pivotIdx){
            int pivotHeight = pivotHeightAry[pivotIdx];
            for(int w=0;w<pivotHeight;++w){
                int lhs = pivotIdx-w;
                int rhs = pivotIdx+w;
                ++lhs;lhs/=2;
                rhs/=2;++rhs;
                if(lhs==rhs)continue;
                retAA[lhs][rhs] = true;
            }
        }
        return retAA;
    }
    
    public static int[] getMinJumpCountAry(boolean[][] jumpAryAry){
        int len = jumpAryAry.length;
        int[] retA = new int[len];
        retA[0] = 0;
        for(int rhs=1;rhs<len;++rhs){
            int ret = len;
            for(int lhs=0;lhs<rhs;++lhs){
                if(!jumpAryAry[lhs][rhs])continue;
                ret = Math.min(ret,retA[lhs]+1);
            }
            retA[rhs] = ret;
        }
        return retA;
    }
}
