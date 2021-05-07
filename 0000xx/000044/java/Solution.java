import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public boolean isMatch(String s, String p) {
        char[] sCharList = s.toCharArray();
        char[] tCharList = null;
    
        // combine all ** to *
        StringBuilder psb = new StringBuilder();
        boolean lastStar = false;
        for(int i=0;i<p.length();++i){
            char c = p.charAt(i);
            if(c=='*'){
                if(lastStar){
                }else{
                    psb.append(c);
                }
                lastStar = true;
            }else{
                psb.append(c);
                lastStar = false;
            }
        }
        p=psb.toString();
        
        // edge case: p=""
        if(p.length()==0){
            return s.length()==0;
        }
        
        // split p by *, keep head tail empty str
        String[] pSplit = ("."+p+".").split(Pattern.quote("*"));
        pSplit[0] = pSplit[0].substring(1,pSplit[0].length());
        pSplit[pSplit.length-1] = pSplit[pSplit.length-1].substring(0,pSplit[pSplit.length-1].length()-1);
        
        // System.out.println(""+pSplit.length);
        
        // no *
        if(pSplit.length == 1){
            if(s.length()!=p.length())return false;
            tCharList = pSplit[0].toCharArray();
            return match(sCharList,0,sCharList.length,tCharList);
        }
        
        // one *
        if(pSplit.length == 2){
            if(s.length()<p.length()-1)return false;
            tCharList = pSplit[0].toCharArray();
            if(!match(sCharList,0,sCharList.length,tCharList))return false;
            tCharList = pSplit[1].toCharArray();
            if(!match(sCharList,sCharList.length-tCharList.length,sCharList.length,tCharList))return false;
            return true;
        }
        
        // * count >= 2
        tCharList = pSplit[0].toCharArray();
        if(!match(sCharList,0,sCharList.length,tCharList))return false;
        int sLeftIdx = tCharList.length;
        tCharList = pSplit[pSplit.length-1].toCharArray();
        if(!match(sCharList,sCharList.length-tCharList.length,sCharList.length,tCharList))return false;
        int sRightIdx = sCharList.length-tCharList.length;

        if(sLeftIdx>sRightIdx)return false;
        
        //// greedy find pSplit[1:-1] match in s[sLeftIdx:sRightIdx]
        
        int si=sLeftIdx;
        
        for(int pi=1;pi<pSplit.length-1;++pi){
            tCharList = pSplit[pi].toCharArray();
            while(!match(sCharList,si,sRightIdx,tCharList)){
                si++;
                if(si+tCharList.length>sRightIdx)return false;
            }
            si+=tCharList.length;
        }
        return true;
    }
    
    public static boolean match(char[] sCharList,int sStart,int sEnd,char[] pCharList){
        int plen = pCharList.length;
        if(sStart+plen>sCharList.length)return false;
        if(sStart+plen>sEnd)return false;
        for(int i=0;i<plen;++i){
            int si=sStart+i;
            int pi=i;
            if(pCharList[pi]=='?')continue;
            if(pCharList[pi]!=sCharList[si])return false;
        }
        return true;
    }
    
    public static void main(String[] argv){
        test("aa","a",false);
        test("aa","aa",true);
        test("aaa","aa",false);
        test("aa", "*",true);
        test("aa", "a*",true);
        test("ab", "?*",true);
        test("aab", "c*a*b",false);
        test("", "*",true);
        test("", "**",true);
        test("ab", "**b",true);
        test("ba", "*a*",true);
    }
    
    public static void test(String s,String p,boolean expected){
        Solution solution = new Solution();
        boolean result = solution.isMatch(s,p);
        System.out.println(String.format("s=%s, p=%s, exp=%s, act=%s",s,p,expected,result));
        aassert(result == expected);
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
