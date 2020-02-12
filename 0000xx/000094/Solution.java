import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> retList = new LinkedList<>();
        
        LinkedList<Object> stack = new LinkedList<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            Object last = stack.removeLast();
            if(last == null){
                // do nothing
            }else if(last instanceof Integer){
                retList.addLast((Integer) last);
            }else if (last instanceof TreeNode){
                TreeNode lastTn = (TreeNode) last;
                stack.addLast(lastTn.right);
                stack.addLast(lastTn.val);
                stack.addLast(lastTn.left);
            }
        }

        return retList;
    }

}
