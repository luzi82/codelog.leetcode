import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Ary = version1.split(Pattern.quote("."));
        String[] v2Ary = version2.split(Pattern.quote("."));
        
        int lenMax = Math.max(v1Ary.length,v2Ary.length);
        for(int i=0;i<lenMax;++i){
            int v1 = getInt(v1Ary,i);
            int v2 = getInt(v2Ary,i);
            if(v1<v2)return -1;
            if(v1>v2)return 1;
        }
        
        return 0;
    }
    
    int getInt(String[] vAry,int idx){
        if(idx>=vAry.length)return 0;
        return Integer.parseInt(vAry[idx]);
    }
}
