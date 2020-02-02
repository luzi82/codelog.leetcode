import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new Integer[]{1,3,2,5,3,null,9},new Integer[]{1,3,9});
    }
    
    public static void test(Integer[] roott,Integer[] expectedd){
        System.out.println(String.format("root=%s, expected=%s",join(roott),join(expectedd)));
        TreeNode root = TreeNode.toTreeNode(roott);
        Solution solution = new Solution();
        List<Integer> result = solution.largestValues(root);
        Integer[] resultt = result.toArray(new Integer[0]);
        System.out.println(String.format("result=%s",join(resultt)));
        aassert(Arrays.equals(resultt, expectedd));
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
