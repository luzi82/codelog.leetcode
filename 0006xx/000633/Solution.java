import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean judgeSquareSum(int c) {
      int i=(int)Math.ceil(Math.sqrt(c));
      while(true){
        int ii = i*i;
        if(2L*ii<c)return false; // L to avoid big int
        int remain = c-ii;
        if(isSquareNum(remain))return true;
        --i;
      }
    }

    public static boolean isSquareNum(int v){
      double sqrtDouble = Math.sqrt(v);
      int sqrtFloor = (int) Math.floor(sqrtDouble);
      int sqrtCeil = (int) Math.ceil(sqrtDouble);
      if(sqrtCeil!=sqrtFloor)return false;
      if(sqrtFloor*sqrtFloor!=v)return false;
      return true;
    }

}
