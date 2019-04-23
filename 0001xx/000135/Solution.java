import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len<=0)return 0;
        if(len==1)return 1;

        int[] ltrAry = new int[len];
        ltrAry[0] = 1;
        for(int i=1;i<len;++i){
            if(ratings[i]>ratings[i-1]){
                ltrAry[i] = ltrAry[i-1]+1;
            }else{
                ltrAry[i] = 1;
            }
        }
        
        int[] rtlAry = new int[len];
        rtlAry[len-1] = 1;
        for(int i=len-2;i>=0;--i){
            if(ratings[i]>ratings[i+1]){
                rtlAry[i] = rtlAry[i+1]+1;
            }else{
                rtlAry[i] = 1;
            }
        }
        
        int ret = 0;
        for(int i=0;i<len;++i){
            ret+=Math.max(ltrAry[i],rtlAry[i]);
        }
        
        return ret;
    }
}
