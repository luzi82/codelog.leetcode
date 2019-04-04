import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public NestedInteger deserialize(String s) {
        char[] cAry = s.toCharArray();
        int[] ptr=new int[]{0};
        
        NestedInteger ni = new NestedInteger();
        parseList(cAry,ptr,ni);
        return ni.getList().get(0);
    }
    
    void parseList(char[] cAry,int[] ptr,NestedInteger ni){
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
    
    public boolean isDigi(char c){
        if(c<'0')return false;
        if(c>'9')return false;
        return true;
    }
}
