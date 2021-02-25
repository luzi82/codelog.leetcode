import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class TreeAncestor {

    int[] parent;
    Integer[][] memAryAry; // memAry[node][j] = getKthAncestor(node,2^j)

    public TreeAncestor(int n, int[] parent) {
      this.parent = parent;
      this.memAryAry = new Integer[n][];

      HashSet<Integer>[] nodeIdToChildSetAry = new HashSet[n];
      for(int i=0;i<n;++i){
        nodeIdToChildSetAry[i] = new HashSet<>();
      }
      for(int i=0;i<n;++i){
        int p=this.parent[i];
        if(p==-1)continue;
        nodeIdToChildSetAry[p].add(i);
      }

      int[] rootToLeafAry = new int[n];
      Iterator<Integer>[] itrAry = new Iterator[n];
      rootToLeafAry[0] = 0;
      itrAry[0] = nodeIdToChildSetAry[0].iterator();
      int tail = 0;
      while(tail>=0){
        // System.err.println(String.format("rootToLeafAry=%s",Test.join(Arrays.copyOf(rootToLeafAry, tail+1))));
        Iterator<Integer> itr = itrAry[tail];
        if(!itr.hasNext()){
          --tail;
          continue;
        }
        int node = itr.next();
        ++tail;
        rootToLeafAry[tail] = node;
        itrAry[tail] = nodeIdToChildSetAry[node].iterator();
        
        int tailReduce = 1;
        Vector<Integer> memVec = new Vector<Integer>();
        while(true){
          int up = 1 << (tailReduce-1);
          int level = tail-up;
          if(level<0) break;
          memVec.add(rootToLeafAry[level]);
          ++tailReduce;
        }
        this.memAryAry[node] = memVec.toArray(new Integer[0]);
      }
    }
    
    public int getKthAncestor(int node, int k) {
      if(k==0)return node;
      if(this.parent[node]==-1)return -1;
      Integer[] memAry = memAryAry[node];
      for(int i=memAry.length-1;i>=0;--i){
        int kReduce = 1 << i;
        if(kReduce>k)continue;
        return getKthAncestor(memAry[i],k-kReduce);
      }
      throw new IllegalStateException();
    }

}
