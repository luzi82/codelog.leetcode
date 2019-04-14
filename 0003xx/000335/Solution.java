import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isSelfCrossing(int[] x) {
        boolean inside = false;
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        
        for(int v:x){
            if(!inside){
                if(v>b){
                    // nothing
                }else if(v>=b-d){
                    inside=true;
                    a=a-c;
                }else{
                    inside=true;
                }
            }else{
                if(v>=b)return true;
            }
            d=c;c=b;b=a;a=v;
        }
        
        return false;
    }
}
