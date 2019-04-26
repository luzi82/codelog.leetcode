import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// do search, Time Limit Exceeded

class Solution {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        // return ary
        int[] retAry = new int[hits.length];

        for(int h=0;h<hits.length;++h){
            int tarI=hits[h][0];
            int tarJ=hits[h][1];
            if(grid[tarI][tarJ]==0)continue;
            grid[tarI][tarJ]=0;

            // possible drop unit
            HashSet<Unit> dropUnitSet = new HashSet<>();
            dropUnitSet.add(new Unit(tarI,tarJ-1,tarI,tarJ));
            dropUnitSet.add(new Unit(tarI,tarJ+1,tarI,tarJ));
            dropUnitSet.add(new Unit(tarI-1,tarJ,tarI,tarJ));
            dropUnitSet.add(new Unit(tarI+1,tarJ,tarI,tarJ));
            
            // search from top
            HashSet<Unit> doneUnitSet = new HashSet<>();
            TreeSet<Unit> pQ = new TreeSet<>();
            for(int j=0;j<grid[0].length;++j){
                queue(0,j,tarI,tarJ,doneUnitSet,pQ);
            }
            
            // search
            while((!pQ.isEmpty())&&(!dropUnitSet.isEmpty())){
                Unit u=pQ.pollFirst();
                int i=u.i;int j=u.j;
                if(i<0)continue;
                if(i>=grid.length)continue;
                if(j<0)continue;
                if(j>=grid[0].length)continue;
                if(grid[i][j]==0)continue;
                if(dropUnitSet.contains(u))dropUnitSet.remove(u);
                queue(i,j-1,tarI,tarJ,doneUnitSet,pQ);
                queue(i,j+1,tarI,tarJ,doneUnitSet,pQ);
                queue(i-1,j,tarI,tarJ,doneUnitSet,pQ);
                queue(i+1,j,tarI,tarJ,doneUnitSet,pQ);
            }
            
            // do drop
            LinkedList<Unit> dropUnitList = new LinkedList<>(dropUnitSet);
            while(!dropUnitList.isEmpty()){
                Unit u = dropUnitList.removeFirst();
                int i=u.i;int j=u.j;
                if(i<0)continue;
                if(i>=grid.length)continue;
                if(j<0)continue;
                if(j>=grid[0].length)continue;
                if(grid[i][j]==0)continue;
                grid[i][j] = 0;
                ++retAry[h];
                dropUnitList.addLast(new Unit(i,j-1,tarI,tarJ));
                dropUnitList.addLast(new Unit(i,j+1,tarI,tarJ));
                dropUnitList.addLast(new Unit(i-1,j,tarI,tarJ));
                dropUnitList.addLast(new Unit(i+1,j,tarI,tarJ));
            }
        }
        
        return retAry;
    }
    
    static void queue(int i,int j,int tarI,int tarJ,HashSet<Unit> doneUnitSet,TreeSet<Unit> pQ){
        Unit unit = new Unit(i,j,tarI,tarJ);
        if(doneUnitSet.contains(unit))return;
        doneUnitSet.add(unit);
        pQ.add(unit);
    }

    static class Unit implements Comparable<Unit>{
        int i,j,d;
        public Unit(int i,int j,int tarI,int tarJ){
            this.i=i;this.j=j;
            this.d=Math.abs(i-tarI)+Math.abs(j-tarJ);
        }
        public int compareTo(Unit other){
            if(this.d!=other.d)return this.d-other.d;
            if(this.j!=other.j)return this.j-other.j;
            if(this.i!=other.i)return this.i-other.i;
            return 0;
        }
        public boolean equals(Object other){
            return this.compareTo((Unit)other)==0;
        }
        public int hashCode(){
            return Objects.hash(this.i,this.j,this.d);
        }
    }

}
