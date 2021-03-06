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
    
    public static TreeNode toTreeNode(Integer[] vAry){
        if(vAry.length==0)return null;
        
        TreeNode ret = new TreeNode(vAry[0]);
        
        LinkedList<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.addLast(ret);
        
        int readIdx = 1;
        while(true){
            if(readIdx >= vAry.length)break;
            TreeNode node = bfsQueue.pollFirst();
            if(vAry[readIdx]!=null){
                node.left = new TreeNode(vAry[readIdx]);
                bfsQueue.addLast(node.left);
            }
            ++readIdx;
            if(readIdx >= vAry.length)break;
            if(vAry[readIdx]!=null){
                node.right = new TreeNode(vAry[readIdx]);
                bfsQueue.addLast(node.right);
            }
            ++readIdx;
        }
        
        return ret;
    }
    
    public static Integer[] toIntArray(TreeNode treeNode){
        if(treeNode==null){return new Integer[0];}
        LinkedList<Integer> retList = new LinkedList<>();
        LinkedList<TreeNode> bfsQueue = new LinkedList<>();
        
        retList.addLast(treeNode.val);
        bfsQueue.addLast(treeNode);
        
        while(!bfsQueue.isEmpty()){
            TreeNode node = bfsQueue.pollFirst();
            if(node.left!=null){
                retList.addLast(node.left.val);
                bfsQueue.addLast(node.left);
            }else{
                retList.addLast(null);
            }
            if(node.right!=null){
                retList.addLast(node.right.val);
                bfsQueue.addLast(node.right);
            }else{
                retList.addLast(null);
            }
        }
        
        while(true){
            if(retList.isEmpty())break;
            if(retList.getLast()!=null)break;
            retList.pollLast();
        }
        
        return retList.toArray(new Integer[0]);
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
