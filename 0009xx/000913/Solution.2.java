import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// v2, I think that should be lessor O
// but longer runtime, 321ms, 58.7MB

class Solution {

    static final int MOUSE_TURN = 0;
    static final int CAT_TURN = 1;
    
    static final int STATE_INIT = 0;
    static final int STATE_MOUSE_WIN = 1;
    static final int STATE_CAT_WIN = 2;

    public int catMouseGame(int[][] graph) {
        int size = graph.length;
        
        int[][][] stateAAA = new int[size][size][2]; // mouse,cat,turn
        
        // put cat=mouse -> cat win
        for(int m=0;m<size;++m){
            int c=m;
            for(int t=0;t<2;++t){
                stateAAA[m][c][t] = STATE_CAT_WIN;
            }
        }
        
        // put mouse=0 -> mouse win
        {
            int m=0;
            for(int c=0;c<size;++c){
                for(int t=0;t<2;++t){
                    stateAAA[m][c][t] = STATE_MOUSE_WIN;
                }
            }
        }

        // put cat=0 -> mouse win (forbid move)
        {
            int c=0;
            for(int m=0;m<size;++m){
                for(int t=0;t<2;++t){
                    stateAAA[m][c][t] = STATE_MOUSE_WIN;
                }
            }
        }
        
        // dijkstra?
        HashSet<MCT> mctSet = new HashSet<>();
        for(int m=0;m<size;++m)for(int c=0;c<size;++c)for(int t=0;t<2;++t){
            mctSet.add(new MCT(m,c,t));
        }
        while(true){
            //System.err.println(Test.join(stateAAA));
            boolean change = false;
            HashSet<MCT> nextMctSet = new HashSet<>();
            for(MCT mct:mctSet){
                nextMctSet.remove(mct);
                int m=mct.m;int c=mct.c;int t=mct.t;
                if(stateAAA[m][c][t]!=STATE_INIT){continue;}
                if(t==MOUSE_TURN){
                    boolean existMouseWin = false;
                    boolean allCatWin = true;
                    int[] nextMAry = graph[m];
                    for(int nextM:nextMAry){
                        int next = stateAAA[nextM][c][1-t];
                        if(next==STATE_MOUSE_WIN){existMouseWin=true;break;}
                        if(next!=STATE_CAT_WIN){allCatWin=false;}
                    }
                    boolean myChange = false;
                    if(existMouseWin){
                        stateAAA[m][c][t] = STATE_MOUSE_WIN;
                        myChange = true;
                        change=true;
                    }else if(allCatWin){
                        stateAAA[m][c][t] = STATE_CAT_WIN;
                        myChange = true;
                        change=true;
                    }
                    if(myChange){
                        int[] lastCAry = graph[c];
                        for(int lastC:lastCAry){
                            //System.err.println(String.format("%d,%d,%d=%d -> %d,%d,%d",m,c,t,stateAAA[m][c][t],m,lastC,1-t));
                            nextMctSet.add(new MCT(m,lastC,1-t));
                        }
                    }
                }
                if(t==CAT_TURN){
                    boolean existCatWin = false;
                    boolean allMouseWin = true;
                    int[] nextCAry = graph[c];
                    for(int nextC:nextCAry){
                        int next = stateAAA[m][nextC][1-t];
                        if(next==STATE_CAT_WIN){existCatWin=true;break;}
                        if(next!=STATE_MOUSE_WIN){allMouseWin=false;}
                    }
                    boolean myChange = false;
                    if(existCatWin){
                        stateAAA[m][c][t] = STATE_CAT_WIN;
                        myChange = true;
                        change=true;
                    }else if(allMouseWin){
                        stateAAA[m][c][t] = STATE_MOUSE_WIN;
                        myChange = true;
                        change=true;
                    }
                    if(myChange){
                        int[] lastMAry = graph[m];
                        for(int lastM:lastMAry){
                            //System.err.println(String.format("%d,%d,%d=%d -> %d,%d,%d",m,c,t,stateAAA[m][c][t],lastM,c,1-t));
                            nextMctSet.add(new MCT(lastM,c,1-t));
                        }
                    }
                }
            }
            if(!change)break;
            if(stateAAA[1][2][MOUSE_TURN] != STATE_INIT)break;
            mctSet = nextMctSet;
        }
        
        if(stateAAA[1][2][MOUSE_TURN] == STATE_MOUSE_WIN) return 1;
        if(stateAAA[1][2][MOUSE_TURN] == STATE_CAT_WIN) return 2;
        return 0;
    }

    static class MCT{
        int m;int c;int t;
        public MCT(int m,int c,int t){
            this.m=m;this.c=c;this.t=t;
        }
        public int hashCode(){
            return Objects.hash(this.m,this.c,this.t);
        }
    }

}
