import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public void sortColors(int[] nums) {
        int[] cToCntAry = new int[3];
        for(int n:nums){
            ++cToCntAry[n];
        }
        int offset=0;
        for(int i=0;i<3;++i){
            for(int j=0;j<cToCntAry[i];++j){
                nums[offset++] = i;
            }
        }
    }
}
