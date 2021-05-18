import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// This answer do not share node among trees

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        LinkedList<TreeNode> retList = new LinkedList<TreeNode>();
        if(n%2==0){return retList;} // no case
        if(n<0){return retList;} // no case
        if(n==1){
          retList.add(new TreeNode());
          return retList;
        }
        for(int lSize=1;lSize<n;lSize+=2){
            int rSize = n-lSize-1;
            List<TreeNode> lTreeList = allPossibleFBT(lSize);
            List<TreeNode> rTreeList = allPossibleFBT(rSize);
            List<TreeNode>[] rToLTreeListAry=new List[rTreeList.size()];
            List<TreeNode>[] lToRTreeListAry=new List[lTreeList.size()];
            rToLTreeListAry[0] = lTreeList;
            lToRTreeListAry[0] = rTreeList;
            for(int r=1;r<rToLTreeListAry.length;++r){
                rToLTreeListAry[r] = allPossibleFBT(lSize);
            }
            for(int l=1;l<lToRTreeListAry.length;++l){
                lToRTreeListAry[l] = allPossibleFBT(rSize);
            }
            TreeNode[][] lrToLTreeAryAry = new TreeNode[lToRTreeListAry.length][rToLTreeListAry.length];
            TreeNode[][] lrToRTreeAryAry = new TreeNode[lToRTreeListAry.length][rToLTreeListAry.length];
            for(int r=0;r<rToLTreeListAry.length;++r){
                int l=0;
                for(TreeNode lTree:rToLTreeListAry[r]){
                    lrToLTreeAryAry[l][r]=lTree;
                    ++l;
                }
            }
            for(int l=0;l<lToRTreeListAry.length;++l){
                int r=0;
                for(TreeNode rTree:lToRTreeListAry[l]){
                    lrToRTreeAryAry[l][r]=rTree;
                    ++r;
                }
            }
            for(int l=0;l<lToRTreeListAry.length;++l){
                for(int r=0;r<rToLTreeListAry.length;++r){
                    TreeNode tn = new TreeNode(0,lrToLTreeAryAry[l][r],lrToRTreeAryAry[l][r]);
                    retList.add(tn);
                }
            }
        }
        return retList;
    }
}
