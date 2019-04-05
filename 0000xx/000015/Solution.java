import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] numAry0 = nums;
        
        // sort input
        Arrays.sort(numAry0);

        // make all member in input do not appear more than 3 times
        int[] numAry1 = new int[numAry0.length];
        int done=0;
        for(int i=0;i<numAry0.length;++i){
            if((i>=3)&&(numAry0[i]==numAry0[i-3]))continue;
            numAry1[done++]=numAry0[i];
        }
        numAry0 = new int[done];
        for(int i=0;i<done;++i){
            numAry0[i] = numAry1[i];
        }
    
        // prepare output
        LinkedList<List<Integer>> ret = new LinkedList<>();
        int[] lastABC=null;
        
        for(int i=0;i<numAry0.length;++i){
            if((i>=1)&&(numAry0[i]==numAry0[i-1]))continue;
            int a = numAry0[i];
            int j=i+1;
            int k=done-1;
            while(j<k){
                int b = numAry0[j];
                int c = numAry0[k];
                int abcSum = a+b+c;
                if(abcSum<0){++j;continue;}
                if(abcSum>0){--k;continue;}
                int[] abc = new int[]{a,b,c};
                if((lastABC!=null)&&(Arrays.equals(abc,lastABC))){++j;continue;}
                lastABC = abc;
                ret.addLast(asList(abc));
            }
        }
        
        return ret;
    }
    
    static List<Integer> asList(int[] iA){
        LinkedList<Integer> ret = new LinkedList();
        for(int i:iA){
            ret.addLast(i);
        }
        return ret;
    }
}
