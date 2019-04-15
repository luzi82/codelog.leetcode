import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // stupid cases
        if(desiredTotal<=0)return true;
        if(((1+maxChoosableInteger)*maxChoosableInteger)/2<desiredTotal){
            return false;
        }

        boolean[] usedAry = new boolean[maxChoosableInteger+1];
        HashMap<UsedAry,Integer> usedAryToResult = new HashMap<>();
        int result = dfs(usedAry,0,desiredTotal,-1, usedAryToResult);
        //System.err.println(String.format("usedAryToResult.size()=%d",usedAryToResult.size()));
        return result == -1;
    }
    
    static class UsedAry{
        boolean[] usedAry;
        UsedAry(boolean[] usedAry){
            this.usedAry=usedAry.clone();
        }
        public int hashCode(){
            return Arrays.hashCode(this.usedAry);
        }
        public boolean equals(Object other){
            UsedAry ua = (UsedAry)other;
            return Arrays.equals(this.usedAry,ua.usedAry);
        }
    }
    
    public int dfs(boolean[] usedAry,int sum,int desiredTotal,int turn,HashMap<UsedAry,Integer> usedAryToResult){
        UsedAry ua = new UsedAry(usedAry);
        if(usedAryToResult.containsKey(ua)){
            return usedAryToResult.get(ua);
        }
        int result = _dfs(usedAry,sum,desiredTotal,turn,usedAryToResult);
        usedAryToResult.put(ua,result);
        return result;
    }
    
    public int _dfs(boolean[] usedAry,int sum,int desiredTotal,int turn,HashMap<UsedAry,Integer> usedAryToResult){
        if(sum>=desiredTotal){return -turn;}
        for(int i=usedAry.length-1;i>=1;--i){
            if(usedAry[i])continue;
            usedAry[i]=true;
            int tmp = dfs(usedAry, sum+i, desiredTotal, -turn, usedAryToResult);
            usedAry[i]=false;
            if(tmp==turn)return turn;
        }
        return -turn;
    }
}
