import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class NumMatrix {

    int len0;
    int len1;
    int[][] intAryAry; // [len0][len1]
    int[][] sumAryAry; // [len0][len1+1], sumAryAry[i][j] = sum(intAryAry[i][0..j-1])

    public NumMatrix(int[][] matrix) {
        // edge case
        if(matrix.length==0)return;
        if(matrix[0].length==0)return;

        len0=matrix.length;
        len1=matrix[0].length;
        intAryAry = matrix;
        sumAryAry = new int[len0][len1+1];
        
        for(int i=0;i<len0;++i){
            int sum=0;
            sumAryAry[i][0]=sum;
            for(int j=0;j<len1;++j){
                sum+=intAryAry[i][j];
                sumAryAry[i][j+1] = sum;
            }
        }
    }
    
    // O(len1)
    public void update(int row, int col, int val) {
        if(intAryAry==null)return;
        intAryAry[row][col] = val;
        int i=row;
        int sum=0;
        sumAryAry[i][0]=sum;
        for(int j=0;j<len1;++j){
            sum+=intAryAry[i][j];
            sumAryAry[i][j+1] = sum;
        }
    }
    
    // O(len0)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(intAryAry==null)return 0;
        int result=0;
        int i0=row1;int i1=row2+1;
        int j0=col1;int j1=col2+1;
        for(int i=i0;i<i1;++i){
            result+=sumAryAry[i][j1];
            result-=sumAryAry[i][j0];
        }
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
 