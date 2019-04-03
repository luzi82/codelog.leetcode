import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(
            new String[]{
                "XXXX",
                "XOOX",
                "XXOX",
                "XOXX"
            },
            new String[]{
                "XXXX",
                "XXXX",
                "XXXX",
                "XOXX"
            }
        );
    }
    
    public static void test(String[] boardX,String[] expected){
        System.out.println(String.format("boardX=%s, expected=%s",join(boardX),join(expected)));
        char[][] board = getB(boardX);
        Solution solution = new Solution();
        solution.solve(board);
        String[] resultX = getS(board);
        System.out.println(String.format("result=%s",join(resultX)));
        aassert(join(resultX).equals(join(expected)));
    }

    public static char[][] getB(String[] b){
        char[][] ret = new char[b.length][];
        for(int i=0;i<b.length;++i){
            ret[i] = b[i].toCharArray();
        }
        return ret;
    }
    
    public static String[] getS(char[][] b){
        String[] ret = new String[b.length];
        for(int i=0;i<b.length;++i){
            ret[i] = new String(b[i]);
        }
        return ret;
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
