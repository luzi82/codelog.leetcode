import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] prevPermOpt1(int[] A) {
        int bigI = -1;
        for(int i=A.length-2;i>=0;--i){
            if(A[i]>A[i+1]){
                bigI = i;
                break;
            }
        }
        if(bigI==-1){return A;}

        int big = A[bigI];
        int smallI = bigI+1;
        int small = A[smallI];
        int j = smallI+1;
        while(true){
            if(j>=A.length)break;
            if(A[j]>=big)break;
            if(A[j]>small){
                small = A[j];
                smallI = j;
            }
            ++j;
        }
        int t = A[bigI];
        A[bigI] = A[smallI];
        A[smallI] = t;
        
        return A;
    }
}
