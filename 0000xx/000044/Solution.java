import java.lang.AssertionError;
import java.util.*;

class Solution {

    static class SP{
        public int sDone;
        public int pDone;
        public SP(int sDone,int pDone){
            this.sDone=sDone;
            this.pDone=pDone;
        }
        public int hashCode(){
            return Objects.hash(sDone,pDone);
        }
        public boolean equals(Object obj){
            if (!(obj instanceof SP))return false;
            SP o =(SP)obj;
            if(sDone!=o.sDone)return false;
            if(pDone!=o.pDone)return false;
            return true;
        }
    }

    public boolean isMatch(String s, String p) {
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
    
        LinkedList<SP> searchQueue = new LinkedList<>();
        HashSet<SP> doneSet = new HashSet<>();
        
        searchQueue.push(new SP(0,0));
        while(!searchQueue.isEmpty()){
            SP sp=searchQueue.pop();
            int sDone = sp.sDone;
            int pDone = sp.pDone;
            
            if ((sDone == s.length()) && (pDone == p.length()))
                return true;
            if (pDone == p.length())
                continue;
            if (p.charAt(pDone) == '*'){
                for(int i=sDone;i<=s.length();++i){
                    push(searchQueue,doneSet,i,pDone+1);
                }
                continue;
            }
            while(true){
                if (sDone == s.length())
                    break;
                if (pDone == p.length())
                    break;
                if (p.charAt(pDone) == '?'){
                    sDone++;
                    pDone++;
                }else if (p.charAt(pDone) == s.charAt(sDone)){
                    sDone++;
                    pDone++;
                }else{
                    break;
                }
            }
            push(searchQueue,doneSet,sDone,pDone);
        }
        
        return false;
    }
    
    public static void push(LinkedList<SP> searchQueue,HashSet<SP> doneSet,int sDone,int pDone){
        SP sp=new SP(sDone,pDone);
        if(doneSet.contains(sp))return;
        doneSet.add(sp);
        searchQueue.push(sp);
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
