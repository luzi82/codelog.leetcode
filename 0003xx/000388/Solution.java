import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int lengthLongestPath(String input) {
        if(input.length()==0)return 0;
        
        int ret = 0;

        int[] sizeStack = new int[65536];
        int sizeStackSize = 0;
        
        String[] lineAry = input.split(Pattern.quote("\n"));
        for(String line:lineAry){
            char[] cAry = line.toCharArray();
            int level = 0;
            while(cAry[level]=='\t'){++level;}
            boolean isFile = false;
            for(int i=level;i<cAry.length;++i){
                if(cAry[i]=='.'){isFile=true;break;}
            }
            int size = (level>0)?sizeStack[level-1]:0;
            size += cAry.length-level;
            if(isFile){
                ret = Math.max(ret,size);
            }else{
                sizeStack[level] = size+1;
            }
        }
        
        return ret;
    }
}
