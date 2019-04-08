import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int sumSubarrayMins(int[] A) {
    
        LinkedList<Integer> idxStack = new LinkedList<>();

        // left to right
        int[] rightLen = new int[A.length];
        for(int i=0;i<A.length;++i){
            int a = A[i];
            // remove all value > a
            while(true){
                if(idxStack.isEmpty())break;
                int lastIdx = idxStack.getLast();
                if(A[lastIdx]<=a)break;
                rightLen[lastIdx] = i-lastIdx;
                idxStack.removeLast();
            }
            // put i
            idxStack.addLast(i);
        }
        while(!idxStack.isEmpty()){
            int lastIdx = idxStack.removeLast();
            rightLen[lastIdx] = A.length-lastIdx;
        }

        //System.err.println(Test.join(rightLen));
        
        // right to left
        int[] leftLen = new int[A.length];
        for(int i=A.length-1;i>=0;--i){
            int a = A[i];
            // remove all value >= a
            while(true){
                if(idxStack.isEmpty())break;
                int lastIdx = idxStack.getLast();
                if(A[lastIdx]<a)break;
                leftLen[lastIdx] = lastIdx-i;
                idxStack.removeLast();
            }
            // put i
            idxStack.addLast(i);
        }
        while(!idxStack.isEmpty()){
            int lastIdx = idxStack.removeLast();
            leftLen[lastIdx] = lastIdx+1;
        }
        
        //System.err.println(Test.join(leftLen));

        // ans
        long BIG = 1000000007;
        long ret = 0;
        for(int i=0;i<A.length;++i){
            long plus = A[i];
            plus %= BIG;
            plus *= rightLen[i];
            plus %= BIG;
            plus *= leftLen[i];
            plus %= BIG;
            ret += plus;
            ret %= BIG;
        }
        
        return (int)ret;
    }
}
