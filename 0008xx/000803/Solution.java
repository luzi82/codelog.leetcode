import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// reverse search, discussion suggest

class Solution {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int iMax = grid.length;
        int jMax = grid[0].length;

        // death time
        final int EMPTY = -1;
        final int LIVE = Integer.MAX_VALUE;
        int[][] deathAA = new int[iMax][jMax];
        for(int i=0;i<iMax;++i)for(int j=0;j<jMax;++j){
            deathAA[i][j] = (grid[i][j]==1)?LIVE:EMPTY;
        }
        for(int h=0;h<hits.length;++h){
            int i=hits[h][0], j=hits[h][1];
            deathAA[i][j] = Math.min(deathAA[i][j],h);
        }
        
        //System.err.println(Test.join(deathAA));
        
        int[] retAry = new int[hits.length];
        
        boolean[][] doneAA = new boolean[iMax][jMax];
        TreeSet<Dij> dijPq = new TreeSet<>();
        for(int j=0;j<jMax;++j){
            dijPq.add(new Dij(LIVE,0,j));
        }
        while(!dijPq.isEmpty()){
            Dij dij = dijPq.pollLast();
            //System.err.println("xxx");
            //for(Dij xxx:dijPq){
            //    System.err.println(String.format("xxx %d, %d, %d",xxx.d,xxx.i,xxx.j));
            //}
            int d=dij.d, i=dij.i, j=dij.j;
            if(i<0)continue;if(i>=iMax)continue;
            if(j<0)continue;if(j>=jMax)continue;
            if(doneAA[i][j])continue;
            //System.err.println(String.format("%d, %d, %d",d,i,j));
            if(deathAA[i][j]>d){
                // drop at d
                deathAA[i][j]=d;
                if(d>=0)++retAry[d];
                dijPq.add(new Dij(d,i,j-1));
                dijPq.add(new Dij(d,i,j+1));
                dijPq.add(new Dij(d,i-1,j));
                dijPq.add(new Dij(d,i+1,j));
                doneAA[i][j]=true;
            }
            else if(deathAA[i][j]==d){
                dijPq.add(new Dij(d,i,j-1));
                dijPq.add(new Dij(d,i,j+1));
                dijPq.add(new Dij(d,i-1,j));
                dijPq.add(new Dij(d,i+1,j));
                doneAA[i][j]=true;
            }
            else{
                //System.err.println(String.format("X %d, %d, %d",deathAA[i][j],i,j));
                dijPq.add(new Dij(deathAA[i][j],i,j));
            }
        }
        
        return retAry;
    }
    
    static class Dij implements Comparable<Dij>{
        int d,i,j;
        public Dij(int d,int i,int j){
            //System.err.println(String.format("dij %d, %d, %d",d,i,j));
            this.d=d;this.i=i;this.j=j;
        }
        public int compareTo(Dij other){
            // use <> instead of - to avoid overflow, int.max - (-1) < 0
            if(this.d<other.d)return -1;
            if(this.d>other.d)return 1;
            if(this.i<other.i)return -1;
            if(this.i>other.i)return 1;
            if(this.j<other.j)return -1;
            if(this.j>other.j)return 1;
            return 0;
        }
        public boolean equals(Object other){
            return this.compareTo((Dij)other)==0;
        }
        public int hashCode(){
            return Objects.hash(this.d,this.i,this.j);
        }
    }

}
