import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        int head = node.val;
        
        HashMap<Integer,Node> intToNodeMap = new HashMap<>();

        LinkedList<Node> q=new LinkedList();
        q.addLast(node);
        while(!q.isEmpty()){
            Node n=q.removeFirst();
            if(intToNodeMap.containsKey(n.val))continue;
            intToNodeMap.put(n.val, n);
            if(n.neighbors==null)continue;
            for(Node nn:n.neighbors){
                q.addLast(nn);
            }
        }
        
        HashMap<Integer,Node> cloneIntToNodeMap = new HashMap<>();
        for(int k:intToNodeMap.keySet()){
            Node n = intToNodeMap.get(k);
            LinkedList<Node> neighbors = null;
            if(n.neighbors!=null){
                neighbors = new LinkedList<>();
            }
            Node n2 = new Node(k,neighbors);
            cloneIntToNodeMap.put(k,n2);
        }
        for(int k:intToNodeMap.keySet()){
            Node n = intToNodeMap.get(k);
            Node n2 = cloneIntToNodeMap.get(k);
            if(n.neighbors!=null){
                LinkedList<Node> n2neighbors = (LinkedList<Node>)n2.neighbors;
                for(Node nn:n.neighbors){
                    Node nn2 = cloneIntToNodeMap.get(nn.val);
                    n2neighbors.addLast(nn2);
                }
            }
        }
        
        return cloneIntToNodeMap.get(head);
    }
}    
