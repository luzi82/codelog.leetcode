import java.lang.AssertionError;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
      // fast fail
      if(x==0)return 0;
      int gcd = getGcd(a, b);
      if(x%gcd!=0)return -1;

      // cal upper limit
      // long vMaxL = 1;
      // vMaxL *= a;
      // vMaxL *= b;
      // vMaxL /= gcd;
      // int vMax = (int)vMaxL;
      // if(a>=b){
      //   vMax = x+a;
      // }else{
      //   vMax += x;
      // }
      int vMax = Math.max(x,max(forbidden))+a+b;

      // fill forbiddenSet
      HashSet<Integer> forbiddenSet = new HashSet<>();
      for(int f:forbidden){
        forbiddenSet.add(f);
      }

      // cal ans
      HashMap<Integer,Integer> cellIdToJumpMap = new HashMap<>();
      LinkedList<Integer> processQueue = new LinkedList<>();
      cellIdToJumpMap.put(0,0);
      processQueue.add(0);
      while(!processQueue.isEmpty()){
        int cellId = processQueue.removeFirst();
        int jump = cellIdToJumpMap.get(cellId);
        boolean lastBack = cellId < 0;
        if(lastBack)cellId=-cellId;
        ++jump;
        int cc = cellId+a;
        if(cc==x)return jump;
        processNext(cc,jump,false,vMax,forbiddenSet,cellIdToJumpMap,processQueue);
        if(!lastBack){
          cc = cellId-b;
          if(cc==x)return jump;
          processNext(cc,jump,true,vMax,forbiddenSet,cellIdToJumpMap,processQueue);
        }
      }
      return -1;
    }

    public static void processNext(int cc,int jump,boolean lastBack,int vMax,HashSet<Integer> forbiddenSet,HashMap<Integer,Integer> cellIdToJumpMap,LinkedList<Integer> processQueue){
      if(cc<=0)return;
      if(cc>vMax)return;
      if(forbiddenSet.contains(cc))return;
      if(lastBack)cc=-cc;
      if(cellIdToJumpMap.containsKey(cc))return;
      cellIdToJumpMap.put(cc,jump);
      processQueue.add(cc);
    }

    public static int getGcd(int a,int b){
      BigInteger aa = BigInteger.valueOf(a);
      BigInteger bb = BigInteger.valueOf(b);
      BigInteger ret = aa.gcd(bb);
      return ret.intValue();
    }

    public static int max(int[] vAry){
      int ret = vAry[0];
      for(int v:vAry){
        ret = Math.max(ret, v);
      }
      return ret;
    }
}
