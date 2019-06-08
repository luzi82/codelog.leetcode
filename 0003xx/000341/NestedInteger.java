import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class NestedInteger {

    Integer v;
    LinkedList<NestedInteger> childList;

    // Constructor initializes an empty nested list.
    public NestedInteger(){
        this.childList=new LinkedList<NestedInteger>();
        this.v=null;
    }

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

    public static NestedInteger deserialize(String s) {
        char[] cAry = s.toCharArray();
        int[] ptr=new int[]{0};
        
        NestedInteger ni = new NestedInteger();
        parseList(cAry,ptr,ni);
        return ni.getList().get(0);
    }

    static void parseList(char[] cAry,int[] ptr,NestedInteger ni){
        while(true){
            char c=cAry[ptr[0]];
            if(isDigi(c)){
                int start = ptr[0];
                while(true){
                    if(ptr[0]>=cAry.length)break;
                    if(!isDigi(cAry[ptr[0]]))break;
                    ++ptr[0];
                }
                int end = ptr[0];
                int v = Integer.parseInt(new String(cAry,start,end-start));
                ni.add(new NestedInteger(v));
            }else if(c=='-'){
                ++ptr[0];
                int start = ptr[0];
                while(true){
                    if(ptr[0]>=cAry.length)break;
                    if(!isDigi(cAry[ptr[0]]))break;
                    ++ptr[0];
                }
                int end = ptr[0];
                int v = Integer.parseInt(new String(cAry,start,end-start));
                ni.add(new NestedInteger(-v));
            }else if(c=='['){
                ++ptr[0]; // [
                NestedInteger ni0 = new NestedInteger();
                parseList(cAry,ptr,ni0);
                ni.add(ni0); // ]
                ++ptr[0];
            }
            if(ptr[0]>=cAry.length)return;
            c=cAry[ptr[0]];
            if(c==']')return;
            if(c==','){++ptr[0];continue;}
            //System.err.println(String.format("%s %d",new String(cAry),ptr[0]));
            throw new Error();
        }
    }
    
    public static boolean isDigi(char c){
        if(c<'0')return false;
        if(c>'9')return false;
        return true;
    }
}
