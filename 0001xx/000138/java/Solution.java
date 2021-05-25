import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        
        HashMap<Integer,LinkedList<Node>> valToOriNodeListMap = new HashMap<>();
        HashMap<Integer,LinkedList<Node>> valToNewNodeListMap = new HashMap<>();

        // clone list
        Node retRoot = new Node(head.val);
        Node wPtr = retRoot;
        Node rPtr = head;
        addNode(valToOriNodeListMap,rPtr);
        addNode(valToNewNodeListMap,wPtr);
        while(true){
            if(rPtr.next==null){break;}
            wPtr.next=new Node(rPtr.next.val);
            wPtr=wPtr.next;
            rPtr=rPtr.next;
            addNode(valToOriNodeListMap,rPtr);
            addNode(valToNewNodeListMap,wPtr);
        }
        
        wPtr = retRoot;
        rPtr = head;
        while(true){
            if(wPtr==null)break;
            wPtr.random = findNew(rPtr.random,valToOriNodeListMap,valToNewNodeListMap);
            wPtr=wPtr.next;
            rPtr=rPtr.next;
        }
        
        return retRoot;
    }
    
    void addNode(HashMap<Integer,LinkedList<Node>> valToNodeListMap, Node node){
        if(!valToNodeListMap.containsKey(node.val)){
            valToNodeListMap.put(node.val,new LinkedList<Node>());
        }
        valToNodeListMap.get(node.val).add(node);
    }
    
    Node findNew(Node oriNode,HashMap<Integer,LinkedList<Node>> valToOriNodeListMap,HashMap<Integer,LinkedList<Node>> valToNewNodeListMap){
        if(oriNode==null)return null;
        int val = oriNode.val;
        LinkedList<Node> oriNodeList = valToOriNodeListMap.get(val);
        LinkedList<Node> newNodeList = valToNewNodeListMap.get(val);
        Iterator<Node> oriNodeItr = oriNodeList.iterator();
        Iterator<Node> newNodeItr = newNodeList.iterator();
        while(true){
            Node ooriNode = oriNodeItr.next();
            Node newNode = newNodeItr.next();
            if(ooriNode==oriNode){
                return newNode;
            }
        }
    }
}
