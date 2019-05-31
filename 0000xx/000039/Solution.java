import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        int[] countAry = new int[candidates.length];
        dfs(ret,target,countAry,0,candidates);
        return ret;
    }
    
    public static void dfs(LinkedList<List<Integer>> ret, int remain, int[] countAry, int done, int[] candidates){
        //System.err.println(String.format("asdf %d %d",remain,done));
        if(remain<0)return;
        if(remain==0){
            LinkedList<Integer> newList = new LinkedList<>();
            for(int i=0;i<done;++i){
                for(int j=0;j<countAry[i];++j){
                    newList.addLast(candidates[i]);
                }
            }
            ret.addLast(newList);
            return;
        }
        if(done>=candidates.length)return;
        countAry[done]=0;
        while(remain>=0){
            dfs(ret,remain,countAry,done+1,candidates);
            ++countAry[done];
            remain-=candidates[done];
        }
    }
}
