import java.util.*;

class Solution {

    public int slidingPuzzle(int[][] board) {
        
        if(Arrays.deepEquals(board,FINAL_BOARD))return 0;
        
        LinkedList<int[][]> searchQueue = new LinkedList<>();
        HashMap<Integer,Integer> boardToStepMap = new HashMap<>();
        
        int boardHash = hashCode(board);
        boardToStepMap.put(boardHash,0);
        searchQueue.offer(board);
        
        while(!searchQueue.isEmpty()){
            board = searchQueue.poll();
            boardHash = hashCode(board);
            int moveStep  = boardToStepMap.get(boardHash)+1;
            List<int[][]> moveBoardList = getMoveBoardList(board);
            for(int[][] moveBoard : moveBoardList){
                int moveBoardHash = hashCode(moveBoard);
                if(boardToStepMap.containsKey(moveBoardHash))continue;
                //System.err.println(toString(board));
                //System.err.println(toString(moveBoard));
                //System.err.println("");
                if(Arrays.deepEquals(moveBoard,FINAL_BOARD))return moveStep;
                boardToStepMap.put(moveBoardHash,moveStep);
                searchQueue.offer(moveBoard);
            }
        }
        
        return -1;
    }
    
    static List<int[][]> getMoveBoardList(int[][] board){
        LinkedList<int[][]> ret = new LinkedList<>();
    
        int[] zeroPos = findLoc(board, 0);
        int i = zeroPos[0];
        int j = zeroPos[1];
        if(j>0){
            int ii = i;int jj = j-1;
            int[][] board0 = slide(board,i,j,ii,jj);
            ret.push(board0);
        }
        if(j<2){
            int ii = i;int jj = j+1;
            int[][] board0 = slide(board,i,j,ii,jj);
            ret.push(board0);
        }
        if(true){
            int ii = 1-i;int jj = j;
            int[][] board0 = slide(board,i,j,ii,jj);
            ret.push(board0);
        }
        
        return ret;
    }
    
    static int[][] slide(int[][] board,int i,int j,int ii,int jj){
        int a = board[i][j];
        int b = board[ii][jj];
        
        int[][] board0 = deepClone(board);
        board0[i][j] = b;
        board0[ii][jj] = a;
        return board0;
    }
    
    static int[] findLoc(int[][] board,int v){
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[i].length;++j){
                if(board[i][j] == v){return new int[]{i,j};}
            }
        }
        return null;
    }
    
    static int[][] deepClone(int[][] v){
        int[][] ret = new int[v.length][];
        for(int i=0;i<v.length;++i){
            ret[i] = v[i].clone();
        }
        return ret;
    }
    
    static int hashCode(int[][] v){
        int ret = 0;
        for(int i=0;i<v.length;++i){
            for(int j=0;j<v[i].length;++j){
                ret*=10;
                ret+=v[i][j];
            }
        }
        return ret;
    }
    
    static String toString(int[][] v){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<v.length;++i){
            for(int j=0;j<v[i].length;++j){
                if(sb.length()>0)sb.append(" ");
                sb.append(""+v[i][j]);
            }
        }
        return sb.toString();
    }

    static final int[][] FINAL_BOARD = new int[][]{{1,2,3},{4,5,0}};

    public static void main(String[] argv){
        Solution s = new Solution();
        assertTrue(s.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}})==1);
        assertTrue(s.slidingPuzzle(FINAL_BOARD)==0);
        assertTrue(s.slidingPuzzle(new int[][]{{1,2,3},{5,4,0}})==-1);
        assertTrue(s.slidingPuzzle(new int[][]{{4,1,2},{5,0,3}})==5);
        assertTrue(s.slidingPuzzle(new int[][]{{3,2,4},{1,5,0}})==14);
    }

    public static void assertTrue(boolean v){
        if(!v)throw new Error();
    }

}
