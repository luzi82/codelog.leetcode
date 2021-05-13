import java.util.*;

class Solution {
  public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    WqQ[] wqQAry = new WqQ[quality.length];
    for(int i=0;i<wqQAry.length;++i){
      int q = quality[i];
      double wq = ((double)wage[i])/q;
      wqQAry[i] = new WqQ(wq,q);
    }
    
    Arrays.sort(wqQAry);

    TreeMap<Integer,Integer> qToCntMap = new TreeMap<Integer,Integer>();

    double ret = Double.POSITIVE_INFINITY;
    int qSum = 0;
    int qCnt = 0;
    
    for(WqQ wqQ:wqQAry){
      if(qCnt==k-1){
        double cost = wqQ.wq * (wqQ.q+qSum);
        if(cost<ret){ret=cost;}
      }
      
      qSum += wqQ.q;
      add(qToCntMap,wqQ.q);
      ++qCnt;

      while(qCnt>k-1){
        int bigQ = qToCntMap.lastKey();
        rm(qToCntMap,bigQ);
        qSum-=bigQ;
        --qCnt;
      }
    }
  
    return ret;
  }
  
  void add(TreeMap<Integer,Integer> qToCntMap, int q){
    if(!qToCntMap.containsKey(q)){
      qToCntMap.put(q,1);
    }else{
      qToCntMap.put(q,qToCntMap.get(q)+1);
    }
  }
  
  void rm(TreeMap<Integer,Integer> qToCntMap, int q){
    int cnt = qToCntMap.get(q);
    --cnt;
    if(cnt==0){
      qToCntMap.remove(q);
    }else{
      qToCntMap.put(q,cnt);
    }
  }
  
  class WqQ implements Comparable<WqQ>{
    double wq;int q;
    WqQ(double wq,int q){this.wq=wq;this.q=q;}
    public int hashCode(){
      return Objects.hash(wq,q);
    }
    public boolean equals(WqQ other){
      return compareTo(other)==0;
    }
    public int compareTo(WqQ other){
      if(other==null)return 1;
      double diff;
      diff = this.wq-other.wq;
      if(diff<0)return -1;
      if(diff>0)return 1;
      diff = this.q-other.q;
      if(diff<0)return -1;
      if(diff>0)return 1;
      return 0;
    }
  }
}
