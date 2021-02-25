import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class TreeAncestor {

    int[] parent;
    int[][] memAryAry;

    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        this.memAryAry = new int[n][];
    }
    
    public int getKthAncestor(int node, int k) {
        fillMemAry(node);
        if(this.memAryAry[node].length<=k)return -1;
        return this.memAryAry[node][k];
    }

    public void fillMemAry(int node){
      LinkedList<Integer> nodeStack = new LinkedList<Integer>();
      while(true){
        if(this.memAryAry[node]!=null)break;
        int nodeParent = this.parent[node];
        if(nodeParent==-1)break;
        nodeStack.addLast(node);
        node = nodeParent;
      }
      while(true){
        if(this.memAryAry[node]==null){
          int nodeParent = this.parent[node];
          if(nodeParent==-1){
            this.memAryAry[node] = new int[]{node};
          }else{
            this.memAryAry[node] = new int[this.memAryAry[nodeParent].length+1];
            this.memAryAry[node][0] = node;
            for(int i=0;i<this.memAryAry[nodeParent].length;++i){
              this.memAryAry[node][i+1] = this.memAryAry[nodeParent][i];
            }
          }
        }
        if(nodeStack.isEmpty())break;
        node = nodeStack.removeLast();
      }
    }

}
