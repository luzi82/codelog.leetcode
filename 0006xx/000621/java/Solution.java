import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// faster solution with cooldown queue

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // int[] dToLastDoneAry = new int[26];
        // for(int d=0;d<26;++d){
        //     dToLastDoneAry[d] = Integer.MIN_VALUE;
        // }
        int[] dToCntAry = new int[26];
        for(char c:tasks){
            int d = c-'A';
            ++dToCntAry[d];
        }
        
        PriorityQueue<CntD> cntDPq = new PriorityQueue<>();
        for(int d=0;d<26;++d){
            if(dToCntAry[d]<=0)continue;
            CntD cntD = new CntD();
            cntD.cnt = dToCntAry[d];
            cntD.d = d;
            cntDPq.add(cntD);
        }
        
        LinkedList<CntD> coolDownCntDList = new LinkedList<>();
        int coolDownNonNull=0;
        int t = 0;
        while(true){
            if(cntDPq.size()+coolDownNonNull<=0)break;
            if(cntDPq.size()>0){
              CntD cntD = cntDPq.poll();
              int cnt = cntD.cnt;
              int d = cntD.d;
              --cntD.cnt;
              if(cntD.cnt>0){
                coolDownCntDList.addLast(cntD);
                ++coolDownNonNull;
              }else{
                coolDownCntDList.addLast(null);
              }
            }else{
              coolDownCntDList.addLast(null);
            }
            while(coolDownCntDList.size()>n){
              CntD cntD = coolDownCntDList.removeFirst();
              if(cntD!=null){
                --coolDownNonNull;
                cntDPq.add(cntD);
              }
            }
            ++t;
        }
        
        return t;
    }
    
    class CntD implements Comparable<CntD>{
        int cnt;
        int d;
        public int compareTo(CntD other){
            int diff;
            diff = this.cnt-other.cnt;
            if(diff!=0)return -diff;
            diff = this.d-other.d;
            if(diff!=0)return diff;
            return 0;
        }
    }
}
