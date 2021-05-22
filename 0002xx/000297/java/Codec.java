import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        String ret = sb.toString();
        //System.out.println(ret);
        return ret;
    }
    
    void serialize(TreeNode root,StringBuilder sb) {
        sb.append(",");
        if(root==null){
            return;
        }
        sb.append(root.val);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strAry = data.split(Pattern.quote(","));
        //System.out.println(Integer.toString(strAry.length));
        return deserialize(new int[]{1},strAry);
    }
    
    TreeNode deserialize(int[] idxAry,String[] strAry){
        if(idxAry[0]>=strAry.length)return null;
        String str = strAry[idxAry[0]];
        //System.out.println(String.format("%d %s",idxAry[0],str));
        ++idxAry[0];
        if(str.equals(""))return null;
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = deserialize(idxAry,strAry);
        node.right = deserialize(idxAry,strAry);
        return node;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
