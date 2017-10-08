import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public String alienOrder(String[] words) {
        // steps:
        // 1: get char set
        // 2: get char relationship by alt string
        // 3: topological sort
        
        // step 0: edge cases
        if(words.length==0)return "";
        
        // step 1: get char set
        Set<Character> charSet = new HashSet<>();
        for(String word:words){
            for(char c:word.toCharArray()){
                charSet.add(c);
            }
        }
        
        // step 2: get char relationship by alt string
        // for "wrt"<"wrf", "wr" is common, so t<f
        // for "wrf"<"er",  no common, so w<e
        
        // gtSetMap: a:[b,c,d] means b<a,c<a,d<a
        Map<Character,Set<Character> > gtSetMap = new HashMap<>();
        // ltSetMap: a:[b,c,d] means b>a,c>a,d>a
        Map<Character,Set<Character> > ltSetMap = new HashMap<>();
        
        // create empty set for each char
        for(char c:charSet){
            gtSetMap.put(c,new HashSet<Character>());
            ltSetMap.put(c,new HashSet<Character>());
        }
        
        // get char relationship
        for(int i=0;i<words.length-1;++i){
            char[] cAry0 = words[i].toCharArray();
            char[] cAry1 = words[i+1].toCharArray();
            int j=0; // common prefix len
            boolean isShort = false; // case 0="ab", 1="abc"
            while(true){
                if(j>=cAry0.length){isShort=true;break;};
                if(j>=cAry1.length){isShort=true;break;};
                if(cAry0[j]!=cAry1[j])break;
                ++j;
            }
            if(isShort)continue;
            char c0 = cAry0[j];
            char c1 = cAry1[j];
            gtSetMap.get(c1).add(c0);
            ltSetMap.get(c0).add(c1);
        }
        
        // step 3: topological sort
        StringBuilder retSb=new StringBuilder();
        
        // process queue
        LinkedList<Character> processCharQueue=new LinkedList<>();
        for(char c : charSet){
            processCharQueue.push(c);
        }
        
        while(!processCharQueue.isEmpty()){
            char c = processCharQueue.pop();
            if(!gtSetMap.containsKey(c))continue;
            Set<Character> gtSet=gtSetMap.get(c);
            if(!gtSet.isEmpty())continue;
            Set<Character> ltSet=ltSetMap.get(c);
            for(char ltc:ltSet){
                Set<Character> gtSet0=gtSetMap.get(ltc);
                if(gtSet0==null)continue;
                gtSet0.remove(c);
                if(gtSet0.isEmpty())processCharQueue.push(ltc);
            }
            gtSetMap.remove(c);
            ltSetMap.remove(c);
            retSb.append(c);
        }
        
        if(!gtSetMap.isEmpty()){
            //System.out.println("invalid "+retSb.toString());
            return "";
        }
        
        return retSb.toString();
    }
    
    public static void main(String[] argv){
        test(new String[]{"wrt","wrf","er","ett","rftt"},"wertf");
        test(new String[]{"z","x"},"zx");
        test(new String[]{"z","x","z"},"");
    }
    
    public static void test(String[] words,String expected){
        Solution solution = new Solution();
        String result = solution.alienOrder(words);
        System.out.println(String.format("words=%s, exp=%s, act=%s",Arrays.toString(words),expected,result));
        aassert(result.equals(expected));
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
