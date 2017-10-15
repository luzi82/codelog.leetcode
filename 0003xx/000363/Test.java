import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        int[][] matrix;
        matrix = new int[][]{
            {1,  0, 1},
            {0, -2, 3}
        };
        test(matrix, 2, 2);

        matrix = new int[][]{
            {2,2,-1},
        };
        test(matrix, 0, -1);
    }
    
    public static void test(int[][] matrix,int k,int expected){
        System.out.println(String.format("matrix=%s, k=%d expected=%d",toString(matrix),k,expected));
        Solution solution = new Solution();
        int result = solution.maxSumSubmatrix(matrix,k);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
    
    public static String toString(int[][] intAryAry){
        String[] txtAry = new String[intAryAry.length];
        for(int i=0;i<intAryAry.length;++i){
            txtAry[i] = Arrays.toString(intAryAry[i]);
        }
        return Arrays.toString(txtAry);
    }
}
