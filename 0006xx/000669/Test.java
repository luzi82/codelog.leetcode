import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(new Integer[]{1,0,2},1,2,new Integer[]{1,null,2});
        test(new Integer[]{3,0,4,null,2,null,null,1},1,3,new Integer[]{3,2,null,1});
    }
    
    public static void test(Integer[] root,int L, int R, Integer[] expected){
        System.out.println(String.format("root=%s, L=%d, R=%d, expected=%s",join(root),L,R,join(expected)));
        Solution solution = new Solution();
        TreeNode roott = TreeNode.toTreeNode(root);
        TreeNode resultt = solution.trimBST(roott,L,R);
        Integer[] result = TreeNode.toIntArray(resultt);
        System.out.println(String.format("result=%s",join(result)));
        aassert(Arrays.equals(result,expected));
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
