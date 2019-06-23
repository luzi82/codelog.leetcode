import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;


class Solution {
    public List<String> braceExpansionII(String expression) {
        LinkedList<LinkedList<TreeSet<String>>> strSetListStack = new LinkedList<>();
        LinkedList<TreeSet<String>> strSetStack = new LinkedList<>();
        //TreeSet<String> tt0 = new TreeSet<>();
        //tt0.add("");
        //strSetStack.addLast(tt0);
        
        char[] expCharAry = expression.toCharArray();
        
        LinkedList<TreeSet<String>> strSetList = new LinkedList<>();
        TreeSet<String> strSet = new TreeSet<>();
        strSet.add("");
        
        for(char expChar:expCharAry){
            if(expChar=='{'){
                strSetStack.addLast(strSet);
                strSetListStack.addLast(strSetList);

                strSetList = new LinkedList<>();
                strSet = new TreeSet<String>();
                strSet.add("");

                continue;
            }
            if(expChar=='}'){
                strSetList.addLast(strSet);
                
                LinkedList<TreeSet<String>> strSetList0 = strSetListStack.removeLast();
                TreeSet<String> strSet0 = strSetStack.removeLast();

                TreeSet<String> newStrSet = new TreeSet<>();
                for(String str0:strSet0)for(TreeSet<String> strSet1:strSetList)for(String str1:strSet1){
                    newStrSet.add(str0+str1);
                }
                
                strSetList = strSetList0;
                strSet = newStrSet;
                continue;
            }
            if(expChar==','){
                strSetList.addLast(strSet);
                strSet = new TreeSet<>();
                strSet.add("");
                continue;
            }
            {
                TreeSet<String> newStrSet = new TreeSet<>();
                for(String str:strSet){
                    newStrSet.add(str+expChar);
                }
                strSet = newStrSet;
            }
        }
        
        return new LinkedList<String>(strSet);
    }
}
