import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean isMatch(String s, String p) {
        char[] pCAry = p.toCharArray();
        
        Vector<Element> elementVec = new Vector<>();
        int pIdx=0;
        while(true){
            if(pIdx>=pCAry.length)break;
            Element e = new Element();
            e.c = pCAry[pIdx];
            ++pIdx;
            if((pIdx<pCAry.length)&&(pCAry[pIdx]=='*')){
                e.star=true;
                ++pIdx;
            }
            elementVec.add(e);
        }
        
        char[] sCAry = s.toCharArray();
        boolean[] sDoneToGoodAry = new boolean[sCAry.length+1];
        sDoneToGoodAry[0] = true;
        boolean[] nxtSDoneToGoodAry = new boolean[sCAry.length+1];
        boolean[] tmpSDoneToGoodAry;
        for(Element element:elementVec){
            char c = element.c;
            boolean star = element.star;
            for(int sDone=0;sDone<nxtSDoneToGoodAry.length;++sDone){
                nxtSDoneToGoodAry[sDone]=false;
            }
            for(int sDone=0;sDone<sDoneToGoodAry.length;++sDone){
                if(!sDoneToGoodAry[sDone])continue;
                if((!star)&&(c!='.')){
                    if(sDone>=sCAry.length)continue;
                    if(sCAry[sDone]==c){
                        nxtSDoneToGoodAry[sDone+1]=true;
                    }
                }else if((!star)&&(c=='.')){
                    if(sDone>=sCAry.length)continue;
                    nxtSDoneToGoodAry[sDone+1]=true;
                }else if(star&&(c!='.')){
                    nxtSDoneToGoodAry[sDone]=true;
                    for(int sIdx=sDone;sIdx<sCAry.length;++sIdx){
                        if(sCAry[sIdx]!=c)break;
                        nxtSDoneToGoodAry[sIdx+1]=true;
                    }
                }else if(star&&(c=='.')){
                    nxtSDoneToGoodAry[sDone]=true;
                    for(int sIdx=sDone;sIdx<sCAry.length;++sIdx){
                        nxtSDoneToGoodAry[sIdx+1]=true;
                    }
                    break;
                }
            }
            tmpSDoneToGoodAry = sDoneToGoodAry;
            sDoneToGoodAry = nxtSDoneToGoodAry;
            nxtSDoneToGoodAry = tmpSDoneToGoodAry;
        }
        
        return sDoneToGoodAry[sDoneToGoodAry.length-1];
    }
    
    class Element{
        char c;
        boolean star;
        public String toString(){
            StringBuilder sb=new StringBuilder();
            sb.append(c);
            if(star)sb.append('*');
            return sb.toString();
        }
    }
}
