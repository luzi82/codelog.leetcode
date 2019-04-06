import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class MyLinkedList {

    public class Node{
        public Node next;
        public int v;
    }
    public Node start;

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0)return -1;
        Node itr = start;
        for(int i=0;i<index;++i){
            if(itr==null)return -1;
            itr = itr.next;
        }
        if(itr==null)return -1;
        return itr.v;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node head=new Node();
        head.next = this.start;
        head.v = val;
        this.start = head;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node tail = new Node();
        tail.v = val;
        if(this.start==null){
            this.start = tail;
            return;
        }
        Node itr = this.start;
        while(itr.next!=null){
            itr = itr.next;
        }
        itr.next = tail;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index<0)return;
        if(index==0){addAtHead(val);return;}
        Node itr = this.start;
        if(itr==null)return;
        for(int i=1;i<index;++i){
            itr = itr.next;
            if(itr==null)return;
        }
        Node add = new Node();
        add.next = itr.next;
        add.v = val;
        itr.next = add;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0)return;
        if(this.start==null)return;
        if(index==0){
            this.start = this.start.next;
            return;
        }
        Node itr = this.start;
        for(int i=1;i<index;++i){
            itr = itr.next;
            if(itr==null)return;
        }
        if(itr.next==null)return;
        itr.next = itr.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
 