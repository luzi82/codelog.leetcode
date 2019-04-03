import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public void solve(char[][] board) {
        if(board.length<=0)return;
        if(board[0].length<=0)return;
        
        int ix = board.length;
        int jx = board[0].length;

        int[][] oAA = new int[ix][jx];
        
        LinkedList<int[]> q=new LinkedList<>();
        for(int i=0;i<ix;++i){
            q.addLast(new int[]{i,0});
            q.addLast(new int[]{i,jx-1});
        }
        for(int j=0;j<jx;++j){
            q.addLast(new int[]{0,j});
            q.addLast(new int[]{ix-1,j});
        }

        while(!q.isEmpty()){
            int[] ij = q.removeFirst();
            int i=ij[0];int j=ij[1];
            if(i<0)continue;
            if(i>=ix)continue;
            if(j<0)continue;
            if(j>=jx)continue;
            if(board[i][j]=='X')continue;
            if(oAA[i][j]==1)continue;
            oAA[i][j]=1;
            q.addLast(new int[]{i-1,j});
            q.addLast(new int[]{i+1,j});
            q.addLast(new int[]{i,j-1});
            q.addLast(new int[]{i,j+1});
        }

        for(int i=0;i<ix;++i)for(int j=0;j<jx;++j){
            char c = board[i][j];
            int  o = oAA[i][j];
            if(c=='X')continue;
            if(o==1)continue;
            board[i][j] = 'X';
        }
    }
}
