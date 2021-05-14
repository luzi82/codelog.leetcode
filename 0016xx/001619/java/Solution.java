import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int p5 = arr.length/20;
        double sum = 0;
        for(int i=p5;i<arr.length-p5;++i){
            sum += arr[i];
        }
        double ret = sum / (arr.length-p5-p5);
        return ret;
    }
}
