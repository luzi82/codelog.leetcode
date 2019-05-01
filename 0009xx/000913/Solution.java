import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// v1, pass, 6ms, 37.5MB

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
        while(true){
            boolean change = false;

            // mouse move
            {
                int t=MOUSE_TURN;
                for(int m=0;m<size;++m){
                    for(int c=0;c<size;++c){
                        if(stateAAA[m][c][t]!=STATE_INIT){continue;}
                        boolean existMouseWin = false;
                        boolean allCatWin = true;
                        int[] nextMAry = graph[m];
                        for(int nextM:nextMAry){
                            int next = stateAAA[nextM][c][1-t];
                            if(next==STATE_MOUSE_WIN){existMouseWin=true;break;}
                            if(next!=STATE_CAT_WIN){allCatWin=false;}
                        }
                        if(existMouseWin){
                            stateAAA[m][c][t] = STATE_MOUSE_WIN;
                            change=true;
                        }else if(allCatWin){
                            stateAAA[m][c][t] = STATE_CAT_WIN;
                            change=true;
                        }
                    }
                }
            }
            // cat move
            {
                int t=CAT_TURN;
                for(int m=0;m<size;++m){
                    for(int c=0;c<size;++c){
                        if(stateAAA[m][c][t]!=STATE_INIT){continue;}
                        boolean existCatWin = false;
                        boolean allMouseWin = true;
                        int[] nextCAry = graph[c];
                        for(int nextC:nextCAry){
                            int next = stateAAA[m][nextC][1-t];
                            if(next==STATE_CAT_WIN){existCatWin=true;break;}
                            if(next!=STATE_MOUSE_WIN){allMouseWin=false;}
                        }
                        if(existCatWin){
                            stateAAA[m][c][t] = STATE_CAT_WIN;
                            change=true;
                        }else if(allMouseWin){
                            stateAAA[m][c][t] = STATE_MOUSE_WIN;
                            change=true;
                        }
                    }
                }
            }
            if(!change)break;
            if(stateAAA[1][2][MOUSE_TURN] != STATE_INIT)break;
        }
        
        if(stateAAA[1][2][MOUSE_TURN] == STATE_MOUSE_WIN) return 1;
        if(stateAAA[1][2][MOUSE_TURN] == STATE_CAT_WIN) return 2;
        return 0;
    }

}
