import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        test(new Integer[]{2,1,3},true);
        test(new Integer[]{5,1,4,null,null,3,6},false);
        // no {null}, judge return error
    }
    
    public static void test(Integer[] x,boolean expected){
        System.out.println(String.format("x=%s, expected=%s",join(x),expected));
        TreeNode root = toTreeNode(x);
        Solution solution = new Solution();
        boolean result = solution.isValidBST(root);
        System.out.println(String.format("result=%s",result));
        aassert(result == expected);
    }
    
    public static TreeNode toTreeNode(Integer[] x){
        TreeNode[] tnAry = new TreeNode[x.length];
        for(int i=0;i<x.length;++i){
            if(x[i]==null)continue;
            tnAry[i] = new TreeNode(x[i]);
            if(i==0)continue;
            //System.err.println(String.format("%d %d",i,(i-1)/2));
            if((i-1)%2==0)tnAry[(i-1)/2].left=tnAry[i];
            else tnAry[(i-1)/2].right=tnAry[i];
        }
        return tnAry[0];
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
