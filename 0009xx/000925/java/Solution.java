import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char[] nCAry = name.toCharArray();
        char[] tCAry = typed.toCharArray();
        int nIdx = 0;
        int tIdx = 0;
        while(true){
            if(nIdx>=nCAry.length)break;
            if(tIdx>=tCAry.length)break;
            if(nCAry[nIdx]!=tCAry[tIdx])return false;
            char c = nCAry[nIdx];
            int nCnt = 0;
            int tCnt = 0;
            while(true){
                if(nIdx>=nCAry.length)break;
                if(nCAry[nIdx]!=c)break;
                ++nCnt;
                ++nIdx;
            }
            while(true){
                if(tIdx>=tCAry.length)break;
                if(tCAry[tIdx]!=c)break;
                ++tCnt;
                ++tIdx;
            }
            if(tCnt<nCnt)return false;
        }
        if(nIdx<nCAry.length)return false;
        if(tIdx<tCAry.length)return false;
        return true;
    }
}
