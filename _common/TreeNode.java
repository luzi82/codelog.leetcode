import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

    public static TreeNode toTreeNode(String str){
      Integer[] intQAryQ = Test.toIntQAryQ(str.toCharArray(),0).second;
      return toTreeNode(intQAryQ);
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

    public String toString(){
      Integer[] intQAry = this.toIntQAry();
      return Test.join(intQAry);
    }

    public Integer[] toIntQAry(){
      LinkedList<Integer> intQList = new LinkedList<>();
      LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
      queue.addLast(this);
      while(queue.size()>0){
        TreeNode n = queue.removeFirst();
        if(n==null){
          intQList.add(null);
          continue;
        }
        intQList.add(n.val);
        queue.addLast(n.left);
        queue.addLast(n.right);
      }
      
      Integer[] intQAry = intQList.toArray(new Integer[0]);
      int lastNonNull = -1;
      for(int i=0;i<intQAry.length;++i){
        if(intQAry[i]==null)continue;
        lastNonNull=i;
      }
      
      intQAry = Arrays.copyOf(intQAry,lastNonNull+1);
      return intQAry;
    }

}
