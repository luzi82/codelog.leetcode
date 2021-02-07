import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(1,new int[]{});
        test(2,new int[]{});
        test(3,new int[]{1});
        test(4,new int[]{2});

        // my case
        test(2,new int[]{0});
        test(10,new int[]{3,4,5});
    }
    
    public static void test(int N,int[] blacklist){
        System.out.println(String.format("N=%d, blacklist=%s",N,join(blacklist)));
        Solution solution = new Solution(N, blacklist);
        solution.trace();
        HashSet<Integer> blackSet = new HashSet<>();
        for(int black:blacklist){
          blackSet.add(black);
        }
        int caseCount = Math.max(N*N,100);
        for(int i=0;i<caseCount;++i){
          int pick = solution.pick();
          aassert(pick < N);
          aassert(!blackSet.contains(pick));
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
            if(v==null){
                sb.append("null");
            }else{
                sb.append(v.toString());
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
