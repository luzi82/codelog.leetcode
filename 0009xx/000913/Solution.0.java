import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// not completed, cannot handle draw

class Solution {

    static final int MOUSE_TURN = 0;
    static final int CAT_TURN = 0;
    
    static final int STATE_INIT = 0;
    static final int STATE_MOUSE_WIN = 1;
    static final int STATE_CAT_WIN = 2;
    static final int STATE_DRAW = 3;
    static final int STATE_BUSY = 4;

    public int catMouseGame(int[][] graph) {
        int size = graph.length;
        
        int[][][] stateAAA = new int[size][size][2]; // mouse,cat,turn
        
        int ret = calState(MOUSE_TURN, 1, 2, stateAAA, graph);
        
        if(ret == STATE_MOUSE_WIN) return 1;
        if(ret == STATE_CAT_WIN) return 2;
        return 0;
    }
    
    public static int calState(int turn, int mouse, int cat, int[][][] stateAAA, int[][] graph){
        if(stateAAA[mouse][cat][turn]==STATE_INIT){
            stateAAA[mouse][cat][turn] = STATE_BUSY;
            stateAAA[mouse][cat][turn] = _calState(MOUSE_TURN, 1, 2, stateAAA, graph);
        }
        return stateAAA[mouse][cat][turn];
    }
    
    public static int _calState(int turn, int mouse, int cat, int[][][] stateAAA, int[][] graph){
        if(mouse==cat) return STATE_CAT_WIN;
        if(mouse==0) return STATE_MOUSE_WIN;
        if(cat==0) return STATE_MOUSE_WIN;
        
        if(turn == MOUSE_TURN){
            int ret = STATE_CAT_WIN;
        }
    }
    
    public static int mouseOrder(int a,int b){
        if(a==STATE_MOUSE_WIN)return STATE_MOUSE_WIN;
        if(b==STATE_MOUSE_WIN)return STATE_MOUSE_WIN;
        if(a==STATE_DRAW)return STATE_DRAW;
        if(b==STATE_DRAW)return STATE_DRAW;
        if(a==STATE_BUSY)return STATE_DRAW;
        if(b==STATE_BUSY)return STATE_DRAW;
        return STATE_CAT_WIN;
    }
}
