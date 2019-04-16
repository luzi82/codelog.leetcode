import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // unity test
        System.err.println("ACJCEJOZYE");
        aassert(Arrays.equals(Solution.getPivotHeightAry("aab"),new int[]{1,2,2,1,1}));
        System.err.println("KTQJGELBCD");
        aassert(Arrays.equals(Solution.getPivotHeightAry("abcba"),new int[]{1,1,2,1,5,1,2,1,1}));
        System.err.println("SXSVYFCCVG");
        aassert(Arrays.equals(Solution.getPivotHeightAry("ababa"),new int[]{1,1,3,1,5,1,3,1,1}));
        System.err.println("YVEETPKAGX");
    
        // given
        test("aab",1);
        // my case
        test("",-1); // console output
        test("x",0); // console output
        
        // monkey
        Random rand = new Random(0);
        for(int i=0;i<1000;++i){
            int len = 2+rand.nextInt(9);
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<len;++j){
                sb.append((char)('a'+rand.nextInt(2)));
            }
            ttest(sb.toString());
        }
        for(int i=0;i<1000;++i){
            int len = 2+rand.nextInt(9);
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<len;++j){
                sb.append((char)('a'+rand.nextInt(3)));
            }
            ttest(sb.toString());
        }
    }
    
    public static void test(String s,int expected){
        System.out.println(String.format("s=%s, expected=%d",s,expected));
        Solution solution = new Solution();
        int result = solution.minCut(s);
        System.out.println(String.format("result=%s",result));
        aassert(result == expected);
    }

    public static void ttest(String s){
        System.out.println(String.format("s=%s",s));
        Solution solution = new Solution();
        int result = solution.minCut(s);
        System.out.println(String.format("result=%s",result));
    }
    
    public static String join(boolean[][] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(boolean[] v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(join(v));
        }
        sb.append("]");
        return sb.toString();
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

    public static String join(boolean[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(boolean v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(v?"1":"0");
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
