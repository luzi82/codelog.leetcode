import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length<3)return false;
        if(A[0]>=A[1])return false;
        if(A[A.length-2]<=A[A.length-1])return false;
        int i=0;
        while(true){
            if(i>=A.length-1)return false;
            if(A[i]==A[i+1])return false;
            if(A[i]>A[i+1])break;
            ++i;
        }
        while(true){
            if(i>=A.length-1)return true;
            if(A[i]<=A[i+1])return false;
            ++i;
        }
        //return false;
    }
}
