import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// Faster solution with sharing node

class Solution {

    List<TreeNode>[] nToTreeNodeList = new List[21];

    public List<TreeNode> allPossibleFBT(int n) {
        if(n<0)return new LinkedList<TreeNode>();
        if(n%2==0)return new LinkedList<TreeNode>();
        if(nToTreeNodeList[n]==null){
          nToTreeNodeList[n] = _allPossibleFBT(n);
        }
        return nToTreeNodeList[n];
    }

    public List<TreeNode> _allPossibleFBT(int n) {
        LinkedList<TreeNode> treeNodeList = new LinkedList<TreeNode>();
        if(n==1){
          treeNodeList.add(new TreeNode());
          return treeNodeList;
        }
        for(int i=1;i<n;i+=2){
          List<TreeNode> lTreeNodeList = allPossibleFBT(i);
          List<TreeNode> rTreeNodeList = allPossibleFBT(n-i-1);
          for(TreeNode lTreeNode : lTreeNodeList){
            for(TreeNode rTreeNode : rTreeNodeList){
              TreeNode tn = new TreeNode(0,lTreeNode,rTreeNode);
              treeNodeList.add(tn);
            }
          }
        }
        return treeNodeList;
    }

}
