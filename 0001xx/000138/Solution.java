import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
    
        int headVal = head.val;
    
        // build outputValToNodeMap, empty node
        HashMap<Integer,Node> outputValToNodeMap = new HashMap<>();
        Node inputNode = head;
        while(inputNode!=null){
            outputValToNodeMap.put(inputNode.val,new Node(inputNode.val,null,null));
            inputNode = inputNode.next;
        }
        
        // fill outputValToNodeMap
        inputNode = head;
        while(inputNode!=null){
            Node outputNode = outputValToNodeMap.get(inputNode.val);
            if(inputNode.next!=null){
                outputNode.next = outputValToNodeMap.get(inputNode.next.val);
            }
            if(inputNode.random!=null){
                outputNode.random = outputValToNodeMap.get(inputNode.random.val);
            }
            inputNode = inputNode.next;
        }
        
        // return
        return outputValToNodeMap.get(headVal);
    }
}
