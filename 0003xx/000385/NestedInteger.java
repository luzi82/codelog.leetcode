import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class NestedInteger {

    Integer v;
    LinkedList<NestedInteger> childList;

    // Constructor initializes an empty nested list.
    public NestedInteger(){}

    // Constructor initializes a single integer.
    public NestedInteger(int value){
        this.childList=null;
        this.v=value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){
        return childList==null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){
        return v;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){
        this.childList=null;
        this.v=value;
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){
        this.v=null;
        if(this.childList==null){
            this.childList=new LinkedList<NestedInteger>();
        }
        this.childList.addLast(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){
        return this.childList;
    }
}
