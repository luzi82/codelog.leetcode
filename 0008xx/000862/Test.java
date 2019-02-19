import java.io.*;
import java.util.*;
import java.math.*;

class Test{

    public static void main(String[] argv){
        Solution.DcOut dc;
    
        //int[] v=new int[]{-23,51,-14,-6,36,33,76,-26,-6,58,-16,1,98,2,-20,48,-19,-41,-34,62};
        //dc = Solution.dc(0,v.length,v,221);
        //System.out.print("sumStartList");
        //for(long[] si:dc.sumStartList){
        //    System.out.print(String.format(" %d-%d",si[0],si[1]));
        //}
        //System.out.println();
        //System.out.print("sumEndList");
        //for(long[] si:dc.sumEndList){
        //    System.out.print(String.format(" %d-%d",si[0],si[1]));
        //}
        //System.out.println();
    
        Solution solution = new Solution();
        
        assert(solution.shortestSubarray(
            new int[]{1},
            1
        )==1);
        assert(solution.shortestSubarray(
            new int[]{1,2},
            4
        )==-1);
        assert(solution.shortestSubarray(
            new int[]{2,-1,2},
            3
        )==3);
        
        assert(solution.shortestSubarray(
            new int[]{1,1,1},
            3
        )==3);
        assert(solution.shortestSubarray(
            new int[]{2,1,3},
            3
        )==1);
        
        System.err.println("=========");
        assert(solution.shortestSubarray(
            new int[]{-23,51,-14,-6,36,33,76,-26,-6,58,-16,1,98,2,-20,48,-19,-41,-34,62},
            221
        )==9);
    }

}