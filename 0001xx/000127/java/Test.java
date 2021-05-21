import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test("hit","cog",new String[]{"hot","dot","dog","lot","log","cog"},5);
        test("hit","cog",new String[]{"hot","dot","dog","lot","log"},0);
    }
    
    public static void test(String beginWord, String endWord, String[] wordAry,int expected){
        System.out.println(
            String.format("beginWord=%s, endWord=%s, wordAry=%s, expected=%d",
            beginWord,endWord,join(wordAry),expected)
        );
        List<String> wordList = Arrays.asList(wordAry);
        Solution solution = new Solution();
        int result = solution.ladderLength(beginWord,endWord,wordList);
        System.out.println(String.format("result=%s",result));
        aassert(result == expected);
    }
    
    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        for(Object v:ary){
            sb.append(v.toString());
            sb.append(",");
        }
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
