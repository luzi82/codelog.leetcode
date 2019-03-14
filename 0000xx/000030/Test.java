import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        Arrays.equals(
            Solution.split("wordgoodgoodgoodbestword",8),
            new String[]{"word","good","good","good","best","word"}
        );
    
        test("barfoothefoobarman",new String[]{"foo","bar"},new Integer[]{0,9});
        test("wordgoodgoodgoodbestword",new String[]{"word","good","best","word"},new Integer[]{});
        test("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"},new Integer[]{8});
    }
    
    public static void test(String s,String[] words,Integer[] ans){
        // System.out.println(String.format("s=%s, expected=%s",x,expected));
        System.out.println(String.format("s=%s",s));
        Solution solution = new Solution();
        List<Integer> result = solution.findSubstring(s,words);
        //System.out.println(String.format("result=%s",result));
        Integer[] intAry = result.toArray(new Integer[0]);
        Arrays.sort(intAry);
        Arrays.sort(ans);
        System.out.println(String.format("intAry=%s",join(intAry)));
        System.out.println(String.format("ans=%s",join(ans)));
        //aassert(result == expected);
        aassert(Arrays.equals(intAry,ans));
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
