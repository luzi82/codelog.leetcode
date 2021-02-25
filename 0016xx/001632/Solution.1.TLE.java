import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        // for {{1,2},{3,4}}

        int ii = matrix.length; // 2
        int jj = matrix[0].length; // 2

        Unit[][] unitAryAry = new Unit[ii][jj];
        for(int i=0;i<ii;++i)for(int j=0;j<jj;++j){
          unitAryAry[i][j] = new Unit(matrix[i][j],i,j);
        }

        TreeSet<Unit> vSet = new TreeSet<>();
        HashMap<Unit,HashSet<Unit>> bigToSmallSetMap = new HashMap<>();
        for(Unit[] vAry:unitAryAry){
          for(Unit v:vAry){
            vSet.add(v);
          }
        }
        // vSet = 1,2,3,4
        HashMap<Unit, Unit> unitUnionMap = new HashMap<>();

        for(Unit v:vSet){
          bigToSmallSetMap.put(v,new HashSet<>());
          unitUnionMap.put(v,v);
        }
        // joinUnion
        for(int i=0;i<ii;++i){
          Unit[] vAry = Arrays.copyOf(unitAryAry[i], jj);
          Arrays.sort(vAry);
          for(int j=0;j<jj-1;++j){
            Unit small = vAry[j];
            Unit big = vAry[j+1];
            if(small.v==big.v){
              joinUnion(small,big,unitUnionMap);
            }
          }
        }
        for(int j=0;j<jj;++j){
          Unit[] vAry = new Unit[ii];
          for(int i=0;i<ii;++i){
            vAry[i]=unitAryAry[i][j];
          }
          Arrays.sort(vAry);
          for(int i=0;i<ii-1;++i){
            Unit small = vAry[i];
            Unit big = vAry[i+1];
            if(small.v==big.v){
              joinUnion(small,big,unitUnionMap);
            }
          }
        }

        // big small relation
        for(int i=0;i<ii;++i){
          Unit[] vAry = Arrays.copyOf(unitAryAry[i], jj);
          // 1,2  3,4
          Arrays.sort(vAry);
          // 1,2  3,4
          for(int j=0;j<jj-1;++j){
            Unit small = vAry[j];
            Unit big = vAry[j+1];
            small = findUnion(small, unitUnionMap);
            big = findUnion(big, unitUnionMap);
            if(small.v<big.v){
              bigToSmallSetMap.get(big).add(small);
            }
            // 2:1, 4:3
          }
        }
        for(int j=0;j<jj;++j){
          Unit[] vAry = new Unit[ii];
          for(int i=0;i<ii;++i){
            vAry[i]=unitAryAry[i][j];
          }
          Arrays.sort(vAry);
          // 3,1 4,2
          for(int i=0;i<ii-1;++i){
            Unit small = vAry[i];
            Unit big = vAry[i+1];
            small = findUnion(small, unitUnionMap);
            big = findUnion(big, unitUnionMap);
            if(small.v<big.v){
              bigToSmallSetMap.get(big).add(small);
            }
            // 3:1 4:2
          }
        }

        // bigToSmallSetMap:
        // 1: []
        // 2: [1]
        // 3: [1]
        // 4: [3]

        HashMap<Unit,Integer> vToRankMap = new HashMap<>();
        for(Unit big0:vSet){
          Unit big = findUnion(big0, unitUnionMap);
          int rank = 1;
          for(Unit small0:bigToSmallSetMap.get(big)){
            Unit small = findUnion(small0,unitUnionMap);
            int rank0 = vToRankMap.get(small);
            rank = Math.max(rank,rank0+1);
          }
          vToRankMap.put(big,rank);
        }
        // 1:1 2:2 3:2 4:3

        int[][] ret = new int[ii][jj];
        for(int i=0;i<ii;++i)for(int j=0;j<jj;++j){
          Unit u = unitAryAry[i][j];
          u = findUnion(u, unitUnionMap);
          int v = vToRankMap.get(u);
          ret[i][j] = v;
        }
        // ret: {{1,2},{2,3}}

        return ret;
    }

    class Unit implements Comparable<Unit>{
      int v,i,j;
      Unit(int v,int i,int j){
        this.v=v;this.i=i;this.j=j;
      }
      public int compareTo(Unit other){
        int diff;
        diff=this.v-other.v;
        if(diff!=0)return diff;
        diff=this.i-other.i;
        if(diff!=0)return diff;
        diff=this.j-other.j;
        if(diff!=0)return diff;
        return 0;
      }
      public int hashCode(){
        return Objects.hash(v,i,j);
      }
      public String toString(){
        return String.format("(v%d,i%d,j%d)",v,i,j);
      }
    }

    void joinUnion(Unit a,Unit b,HashMap<Unit,Unit> unitUnionMap){
      Unit aU = findUnion(a,unitUnionMap);
      Unit bU = findUnion(b,unitUnionMap);
      Unit minU = (aU.compareTo(bU)<0)?aU:bU;
      unitUnionMap.put(a,minU);
      unitUnionMap.put(aU,minU);
      unitUnionMap.put(b,minU);
      unitUnionMap.put(bU,minU);
    }

    Unit findUnion(Unit a,HashMap<Unit,Unit> unitUnionMap){
      Unit n = unitUnionMap.get(a);
      if(n.compareTo(a)==0)return a;
      Unit ret = findUnion(n,unitUnionMap);
      if(ret.compareTo(n)!=0){
        unitUnionMap.put(a,ret);
      }
      return ret;
    }

}
