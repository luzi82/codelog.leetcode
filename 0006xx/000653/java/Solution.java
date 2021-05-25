import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        LinkedList<TreeNode> leftPtr = new LinkedList<>();
        LinkedList<TreeNode> rightPtr = new LinkedList<>();
        
        leftMost(leftPtr,root);
        rightMost(rightPtr,root);
        
        while(true){
            int sum = leftPtr.getLast().val + rightPtr.getLast().val;
            //System.out.println(String.format("add %d %d",leftPtr.getLast().val,rightPtr.getLast().val));
            if(leftPtr.getLast()==rightPtr.getLast())return false;
            if(sum==k)return true;
            if(sum<k){moveRight(leftPtr);}
            else{moveLeft(rightPtr);}
        }
    }
    
    public void leftMost(LinkedList<TreeNode> ptr, TreeNode root){
        while(true){
            if(root==null)return;
            ptr.add(root);
            root = root.left;
        }
    }

    public void rightMost(LinkedList<TreeNode> ptr, TreeNode root){
        while(true){
            if(root==null)return;
            ptr.add(root);
            root = root.right;
        }
    }
    
    public void moveLeft(LinkedList<TreeNode> ptr){
        if(ptr.getLast().left!=null){
            rightMost(ptr,ptr.getLast().left);
            return;
        }
        while(true){
            TreeNode lastRemove = ptr.removeLast();
            if(lastRemove == ptr.getLast().right)return;
        }
    }

    public void moveRight(LinkedList<TreeNode> ptr){
        if(ptr.getLast().right!=null){
            leftMost(ptr,ptr.getLast().right);
            return;
        }
        while(true){
            TreeNode lastRemove = ptr.removeLast();
            if(lastRemove == ptr.getLast().left)return;
        }
    }
}
