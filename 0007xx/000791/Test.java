import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("cba","abcd");
    }
    
    public static void test(String S, String T){
        System.out.println(String.format("S=%s, T=%s",S,T));
        Solution solution = new Solution();
        String result = solution.customSortString(S,T);
        System.out.println(String.format("result=%s",result));
        
        char[] sCharAry = S.toCharArray();
        char[] tCharAry = T.toCharArray();
        char[] rCharAry = result.toCharArray();

        // check T, result contains same char
        char[] tCharAry0 = tCharAry.clone();
        char[] rCharAry0 = rCharAry.clone();
        Arrays.sort(tCharAry0);
        Arrays.sort(rCharAry0);
        aassert(Arrays.equals(tCharAry0,rCharAry0));
        
        // check result follow S order
        HashMap<Character,Integer> cToIdxMap = new HashMap<>();
        for(int i=0;i<sCharAry.length;++i){
            char c = sCharAry[i];
            cToIdxMap.put(c,i);
        }
        int cIdxDone = -1;
        for(char r:rCharAry){
            if(!cToIdxMap.containsKey(r)){continue;}
            int cIdx = cToIdxMap.get(r);
            aassert(cIdx>=cIdxDone);
            cIdxDone = cIdx;
        }
        
        // check no "aba"
        HashSet<Character> appearSet = new HashSet<>();
        char lastChar = 0;
        for(char r:rCharAry){
            if(r==lastChar){continue;}
            aassert(!appearSet.contains(r));
            appearSet.add(r);
        }
    }
    
    public static String join(int[][] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int[] v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(join(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Integer.toString(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(Object v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(v.toString());
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
