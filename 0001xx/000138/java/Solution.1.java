import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// new solution based on Solution.0.java, mod using System.identityHashCode

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
    
        int headId = System.identityHashCode(head);
    
        // build outputIdToNodeMap, empty node
        HashMap<Integer,Node> outputIdToNodeMap = new HashMap<>();
        Node inputNode = head;
        while(inputNode!=null){
            outputIdToNodeMap.put(System.identityHashCode(inputNode),new Node(inputNode.val,null,null));
            inputNode = inputNode.next;
        }
        
        // fill outputIdToNodeMap
        inputNode = head;
        while(inputNode!=null){
            Node outputNode = outputIdToNodeMap.get(System.identityHashCode(inputNode));
            if(inputNode.next!=null){
                outputNode.next = outputIdToNodeMap.get(System.identityHashCode(inputNode.next));
            }
            if(inputNode.random!=null){
                outputNode.random = outputIdToNodeMap.get(System.identityHashCode(inputNode.random));
            }
            inputNode = inputNode.next;
        }
        
        // return
        return outputIdToNodeMap.get(headId);
    }
}
