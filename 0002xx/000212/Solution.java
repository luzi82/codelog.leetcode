import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public static class Tries{
        public String endString = null;
        public Map<Character,Tries> childTriesMap=new HashMap<>();
    }

    // assumptions:
    // - words does not contains emptry string
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
            while(char k:wordCharAry){
                if(!tries.childTriesMap.containsKey(k)){
                    tries.childTriesMap.put(k,new Tries());
                }
                tries = tries.childTriesMap.get(k);
            }
            tries.endString = newString(wordCharAry);
        }
        
        // search
        
        // return
        
        
    }
    
    public static void main(String[] argv){
        test(
            new String[]{"oaan","etae","ihkr","iflv"},
            new String[]{"oath","pea","eat","rain"},
            new String[]{"eat","oath"}
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
