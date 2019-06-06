import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length==0){
            return new int[0][];
        }
        if(matrix[0].length==0){
            return new int[matrix.length][0];
        }
        int iMax = matrix.length;
        int jMax = matrix[0].length;
        int[][] ret = new int[iMax][jMax];
        
        LinkedList<Vector<Integer>> ijQueue = new LinkedList<>();
        HashSet<Vector<Integer>> ijDoneSet = new HashSet<>();
        
        for(int i=0;i<iMax;++i){
            for(int j=0;j<jMax;++j){
                if(matrix[i][j]==0){
                    Vector ij = intAryToVector(new int[]{i,j});
                    ijDoneSet.add(ij);
                    ijQueue.addLast(ij);
                }
            }
        }
        
        while(!ijQueue.isEmpty()){
            Vector<Integer> ijVec = ijQueue.removeFirst();
            int i=ijVec.get(0);
            int j=ijVec.get(1);
            int v=ret[i][j];
            
            test(ret,i-1,j  ,v+1,iMax,jMax,matrix,ijQueue,ijDoneSet);
            test(ret,i+1,j  ,v+1,iMax,jMax,matrix,ijQueue,ijDoneSet);
            test(ret,i  ,j-1,v+1,iMax,jMax,matrix,ijQueue,ijDoneSet);
            test(ret,i  ,j+1,v+1,iMax,jMax,matrix,ijQueue,ijDoneSet);
        }
        
        return ret;
        
    }
    
    public void test(int[][] ret,int i,int j,int v,int iMax,int jMax,int[][] matrix,LinkedList<Vector<Integer>> ijQueue,HashSet<Vector<Integer>> ijDoneSet){
        if(i<0)return;if(i>=iMax)return;
        if(j<0)return;if(j>=jMax)return;
        Vector ijVec = intAryToVector(new int[]{i,j});
        if(ijDoneSet.contains(ijVec))return;
        ret[i][j]=v;
        ijQueue.addLast(ijVec);
        ijDoneSet.add(ijVec);
    }

    public static Vector<Integer> intAryToVector(int[] ary){
        Vector<Integer> ret = new Vector<>(ary.length);
        for(int i=0;i<ary.length;++i){
            ret.add(ary[i]);
        }
        return ret;
    }
}
