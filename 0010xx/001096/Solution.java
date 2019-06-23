import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

// using str-set-list instead of str-set-list-list

class Solution {
    public List<String> braceExpansionII(String expression) {
        char[] expCharAry = expression.toCharArray();
        
        LinkedList<TreeSet<String>> strOrSetStack = new LinkedList<>();
        LinkedList<TreeSet<String>> strConcatSetStack = new LinkedList<>();
        
        strConcatSetStack.addLast(new TreeSet<>());
        strConcatSetStack.getLast().add("");
        
        for(char expChar :expCharAry){
            if(expChar=='{'){
                strOrSetStack.addLast(new TreeSet<String>());
                strConcatSetStack.addLast(new TreeSet<>());
                strConcatSetStack.getLast().add("");

                continue;
            }
            if(expChar=='}'){
                strOrSetStack.getLast().addAll(strConcatSetStack.removeLast());
                TreeSet<String> strOrSet = strOrSetStack.removeLast();

                TreeSet<String> oldStrConcatSet = strConcatSetStack.removeLast();

                TreeSet<String> newStrConcatSet = new TreeSet<>();
                for(String oldStrConcat:oldStrConcatSet)for(String strOr:strOrSet){
                    newStrConcatSet.add(oldStrConcat+strOr);
                }
                
                strConcatSetStack.addLast(newStrConcatSet);
                continue;
            }
            if(expChar==','){
                strOrSetStack.getLast().addAll(strConcatSetStack.removeLast());
                strConcatSetStack.addLast(new TreeSet<>());
                strConcatSetStack.getLast().add("");
                continue;
            }
            {
                TreeSet<String> oldStrConcatSet = strConcatSetStack.removeLast();
                TreeSet<String> newStrConcatSet = new TreeSet<>();
                for(String oldStrConcat:oldStrConcatSet){
                    newStrConcatSet.add(oldStrConcat+expChar);
                }
                strConcatSetStack.addLast(newStrConcatSet);
            }
        }
        
        return new LinkedList<String>(strConcatSetStack.getLast());
    }
}
