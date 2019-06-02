import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int digitCount = Math.max(arr1.length,arr2.length);
        digitCount+=5;
        
        int[] arr3Rev = new int[digitCount];
        for(int i=0;i<arr1.length;++i){
            arr3Rev[i] += arr1[arr1.length-1-i];
        }
        for(int i=0;i<arr2.length;++i){
            arr3Rev[i] += arr2[arr2.length-1-i];
        }
        
        for(int i=0;i<arr3Rev.length-1;++i){
            if(arr3Rev[i]==-1){
                arr3Rev[i]=1;
                arr3Rev[i+1]+=1;
            }
            if(arr3Rev[i]==2){
                arr3Rev[i]=0;
                arr3Rev[i+1]-=1;
            }
            if(arr3Rev[i]==3){
                arr3Rev[i]=1;
                arr3Rev[i+1]-=1;
            }
        }
        
        digitCount = 0;
        for(int i=0;i<arr3Rev.length;++i){
            if(arr3Rev[i]!=0){
                digitCount = i;
            }
        }
        
        ++digitCount;
        
        int[] arr3 = new int[digitCount];
        for(int i=0;i<arr3.length;++i){
            arr3[i] = arr3Rev[arr3.length-1-i];
        }
        
        return arr3;
    }
}
