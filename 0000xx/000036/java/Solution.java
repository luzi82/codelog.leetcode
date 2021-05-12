import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check j=[0,9)
        for(int i=0;i<9;++i){
            boolean[] vToExistAry=new boolean[9];
            for(int j=0;j<9;++j){
                char c = board[i][j];
                if(c=='.')continue;
                int v = c-'1';
                if(vToExistAry[v])return false;
                vToExistAry[v]=true;
            }
        }

        // check i=[0,9)
        for(int i=0;i<9;++i){
            boolean[] vToExistAry=new boolean[9];
            for(int j=0;j<9;++j){
                char c = board[j][i];
                if(c=='.')continue;
                int v = c-'1';
                if(vToExistAry[v])return false;
                vToExistAry[v]=true;
            }
        }
        
        // check sub square
        for(int ii=0;ii<3;++ii)for(int jj=0;jj<3;++jj){
            boolean[] vToExistAry=new boolean[9];
            for(int iii=0;iii<3;++iii)for(int jjj=0;jjj<3;++jjj){
                int i=ii*3+iii;int j=jj*3+jjj;
                char c = board[i][j];
                if(c=='.')continue;
                int v = c-'1';
                if(vToExistAry[v])return false;
                vToExistAry[v]=true;
            }
        }
        
        return true;
    }
}
