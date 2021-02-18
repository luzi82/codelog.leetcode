import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public int minDays(int n) {
      if(n==0)return 0;
      // A* search
      HashSet<Integer> doneV = new HashSet<>();
      TreeSet<Unit> searchPq = new TreeSet<>();
      Unit u0 = new Unit(n,0);
      searchPq.add(u0);
      while(true){
        Unit u = searchPq.pollFirst();
        if(doneV.contains(u.v))continue;
        if(u.v==0)return u.g;
        Unit u1;
        u1 = new Unit(u.v-1,u.g+1);
        searchPq.add(u1);
        if(u.v%2==0){
          u1 = new Unit(u.v/2,u.g+1);
          searchPq.add(u1);
        }
        if(u.v%3==0){
          u1 = new Unit(u.v/3,u.g+1);
          searchPq.add(u1);
        }
        doneV.add(u.v);
      }
    }

    long[] h3Ary = new long[21];
    {
      this.h3Ary[0] = 0;
      this.h3Ary[1] = 1;
      for(int i=2;i<this.h3Ary.length;++i){
        this.h3Ary[i] = this.h3Ary[i-1] * 3;
      }
    }

    public int h(long v){
      int ret = Arrays.binarySearch(this.h3Ary,v);
      if(ret>=0)return ret;
      return -ret;
    }

    class Unit implements Comparable<Unit> {
      int g;
      int h;
      int gh;
      int v;
      Unit(int v,int g){
        this.g=g;
        this.v=v;
        this.h=h(v);
        this.gh=this.g+this.h;
      }
      public int compareTo(Unit u){
        int ret;
        ret = this.gh-u.gh;
        if(ret!=0)return ret;
        ret = this.h-u.h;
        if(ret!=0)return ret;
        ret = this.g-u.g;
        if(ret!=0)return ret;
        ret = this.v-u.v;
        if(ret!=0)return ret;
        return 0;
      }
    }

}
