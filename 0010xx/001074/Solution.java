import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] m2 = new int[R+1][C+1];
        
        for(int r=0;r<R;++r){
            for(int c=0;c<C;++c){
                m2[r+1][c+1] = m2[r][c+1] + m2[r+1][c] - m2[r][c] + matrix[r][c];
            }
        }
        
        int ret = 0;
        for(int r1=0;r1<=R;++r1){
            for(int r0=0;r0<r1;++r0){
                //System.err.println(String.format("r0=%d,r1=%d",r0,r1));
                int[] a2=new int[C+1];
                for(int c=0;c<=C;++c){
                    a2[c] = m2[r1][c]-m2[r0][c];
                }
                //System.err.println(String.format("a2=%s",Test.join(a2)));
                
                ret += find(a2,0,C,target);
            }
        }
        
        return ret;
    }
    
    public int find(int[] a2, int i, int j, int target){
        if(j-i==1){
            if(a2[j]-a2[i]==target)return 1;
            return 0;
        }
        
        int ret = 0;

        int mid = (i+j)/2;
        ret += find(a2,i,mid,target);
        ret += find(a2,mid,j,target);
        
        int[] lhsAry = new int[mid-i];
        int[] rhsAry = new int[j-mid];
        
        for(int t=0;t<lhsAry.length;++t){
            lhsAry[t] = a2[mid]-a2[t+i];
        }
        for(int t=0;t<rhsAry.length;++t){
            rhsAry[t] = a2[t+1+mid]-a2[mid];
        }
        
        Arrays.sort(lhsAry);
        Arrays.sort(rhsAry);
        //System.err.println(String.format("i=%d, j=%d, lhsAry=%s, rhsAry=%s",i,j,Test.join(lhsAry),Test.join(rhsAry)));
        
        int lc = 0;
        int rc = rhsAry.length-1;
        
        int rett = 0;
        
        while(lc<lhsAry.length){
            int nextLc = lc;
            while((nextLc<lhsAry.length) && (lhsAry[nextLc]==lhsAry[lc])){
                ++nextLc;
            }
            
            int rCount = 0;
            while(true){
                if(rc<0)break;
                if(rhsAry[rc]+lhsAry[lc]==target)++rCount;
                if(rhsAry[rc]+lhsAry[lc]<target)break;
                --rc;
            }
            
            rett += rCount * (nextLc - lc);
            
            lc = nextLc;
        }
        //System.err.println(String.format("rett=%d",rett));
        
        ret += rett;
        
        return ret;
    }
}
