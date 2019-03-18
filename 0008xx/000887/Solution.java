import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    HashMap<Long,Integer> knToAns=new HashMap<>();

    public int superEggDrop(int K, int N) {
        if(K==1){return N;}
        if(N==0){return 0;}

        long key=K*100000L+N;
        if(knToAns.containsKey(key))return knToAns.get(key);
        
        int ret = Integer.MAX_VALUE;
        int min=0; // must safe
        int max=N+1; // must break
        while(max-min>1){
            int mid=(max+min)/2;
            int lhs=superEggDrop(K-1,mid-1);
            int rhs=superEggDrop(K,N-mid);
            ret=Math.min(ret,Math.max(lhs,rhs)+1);
            if(lhs>rhs){
                max=mid;
            }else if(lhs<rhs){
                min=mid;
            }else{
                break;
            }
        }
        
        knToAns.put(key,ret);
        return ret;
    }
    
}
