import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public static class Tries{
        public String endString = null;
        public Map<Character,Tries> childTriesMap=new HashMap<>();
        public boolean isEmpty(){
            if(endString!=null)return false;
            if(!childTriesMap.isEmpty())return false;
            return true;
        }
    }

    // assumptions:
    // - words does not contains empty string
    // - no repeat words
    // - word not too long, break recursion
    public List<String> findWords(char[][] board, String[] words) {
        LinkedList<String> retList = new LinkedList<>();
    
        // edge cases
        if(board.length == 0)return retList;
        if(board[0].length == 0)return retList;
        if(words.length == 0)return retList;

        // prepare
        char[][] wordCharAryAry = new char[words.length][];
        for(int i=0;i<words.length;++i){
            wordCharAryAry[i] = words[i].toCharArray();
        }
        
        // build tries
        Tries rootTries = new Tries();
        for(char[] wordCharAry:wordCharAryAry){
            Tries tries = rootTries;
            for(char k:wordCharAry){
                if(!tries.childTriesMap.containsKey(k)){
                    tries.childTriesMap.put(k,new Tries());
                }
                tries = tries.childTriesMap.get(k);
            }
            tries.endString = new String(wordCharAry);
        }
        
        // search by dfs
        int height = board.length;
        int width = board[0].length;
        boolean[][] doneAryAry=new boolean[height][width];
        for(int i=0;i<height;++i)for(int j=0;j<width;++j){
            doneAryAry[i][j]=false;
        }
        
        for(int i=0;i<height;++i)for(int j=0;j<width;++j){
            searchDfs(board,rootTries,height,width,i,j,doneAryAry,retList);
        }
        
        // return
        return retList;
    }

    public static void searchDfs(char[][] board,Tries tries,int h,int w,int i,int j,boolean[][] doneAryAry,LinkedList<String> retList){
        if(i<0)return;
        if(j<0)return;
        if(i>=h)return;
        if(j>=w)return;
        if(doneAryAry[i][j])return;
        char c=board[i][j];
        if(!tries.childTriesMap.containsKey(c))return;

        Tries nextTries=tries.childTriesMap.get(c);
        if(nextTries.endString!=null){
            retList.push(nextTries.endString);
            nextTries.endString=null;
        }
        doneAryAry[i][j] = true;
        searchDfs(board,nextTries,h,w,i+1,j,doneAryAry,retList);
        searchDfs(board,nextTries,h,w,i-1,j,doneAryAry,retList);
        searchDfs(board,nextTries,h,w,i,j+1,doneAryAry,retList);
        searchDfs(board,nextTries,h,w,i,j-1,doneAryAry,retList);
        doneAryAry[i][j] = false;
        if(nextTries.isEmpty()){
            tries.childTriesMap.remove(c);
        }
    }
    
    public static void main(String[] argv){
        test(
            new String[]{"oaan","etae","ihkr","iflv"},
            new String[]{"oath","pea","eat","rain"},
            new String[]{"eat","oath"}
        );
        test(
            new String[]{"oaan","etae","ihkr","iflv"},
            new String[]{"oath","pea","eat","rain","ea"},
            new String[]{"eat","oath","ea"}
        );
        test(
            new String[]{"oaan","etae","ihkr","iflv","oaan","etae","ihkr","iflv"},
            new String[]{"oath","pea","eat","rain","ea"},
            new String[]{"eat","oath","ea"}
        );
    }
    
    public static void test(String[] _board,String[] words,String[] _expected){
        System.out.println(String.format(
            "_board=%s, words=%s, _expected=%s",
            Arrays.toString(_board),Arrays.toString(words),Arrays.toString(_expected)
        ));
        char[][] board = new char[_board.length][];
        for(int i=0;i<_board.length;++i){
            board[i] = _board[i].toCharArray();
        }
        Solution solution = new Solution();
        List<String> result = solution.findWords(board,words);
        String[] _result = result.toArray(new String[0]);
        System.out.println(String.format("result=%s",Arrays.toString(_result)));
        Arrays.sort(_expected);
        Arrays.sort(_result);
        aassert(Arrays.equals(_expected,_result));
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
