import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mountainArrLen = mountainArr.length();
        
        // find peak
        int min = 0;
        int max = mountainArrLen-2;
        
        while(min+1<max){
            int mid = (min+max)/2;
            int v0 = mountainArr.get(mid);
            int v1 = mountainArr.get(mid+1);
            if(v0<v1){min=mid;}
            else{max=mid;}
        }
        int peak = max;
        
        //return peak;
        
        /**/
        // check top
        if(mountainArr.get(peak)==target){return peak;}
        
        // check left, [min, max)
        
        min = 0;
        max = peak;
        
        while(min<max){
            int mid = (min+max)/2;
            int v = mountainArr.get(mid);
            if(v<target){min=mid+1;}
            else if(v==target){return mid;}
            else{max=mid;}
        }
        
        
        min = peak+1;
        max = mountainArrLen;

        while(min<max){
            int mid = (min+max)/2;
            int v = mountainArr.get(mid);
            if(v>target){min=mid+1;}
            else if(v==target){return mid;}
            else{max=mid;}
        }

        return -1;
        /**/
    }
}
