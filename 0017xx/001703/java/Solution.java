import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
  public int minMoves(int[] nums, int k) {
    Vector<Integer> oneIdxToLeftZeroCntVec = new Vector<>();
    int leftZeroCnt=0;
    for(int n:nums){
      if(n==0){++leftZeroCnt;}
      if(n==1){oneIdxToLeftZeroCntVec.add(leftZeroCnt);}
    }
    
    int ret = 0;
    int move = 0;
    for(int i=0;i<k/2;++i){
      move-=oneIdxToLeftZeroCntVec.get(i);
    }
    for(int i=(k+1)/2;i<k;++i){
      move+=oneIdxToLeftZeroCntVec.get(i);
    }
    
    ret = move;
    
    int ptr = 0;
    
    while(true){
      if(ptr+k>=oneIdxToLeftZeroCntVec.size())break;
      move+=oneIdxToLeftZeroCntVec.get(ptr);
      move-=oneIdxToLeftZeroCntVec.get(ptr+k/2);
      move-=oneIdxToLeftZeroCntVec.get(ptr+(k+1)/2);
      move+=oneIdxToLeftZeroCntVec.get(ptr+k);
      ret = Math.min(ret,move);
      ++ptr;
    }
    
    return ret;
  }
}
