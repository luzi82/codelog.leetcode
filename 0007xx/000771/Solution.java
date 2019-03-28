import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] jExist=new boolean[300];
        for(char jChar:J.toCharArray()){
            jExist[jChar] = true;
        }
        int ret=0;
        for(char sChar:S.toCharArray()){
            if(!jExist[sChar])continue;
            ++ret;
        }
        return ret;
    }
}
