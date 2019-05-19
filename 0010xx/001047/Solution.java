import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String removeDuplicates(String S) {
        LinkedList<Character> charStack = new LinkedList<>();
        char[] charArray = S.toCharArray();
        for(char c:charArray){
            if(!charStack.isEmpty()){
                char lastChar = charStack.getLast();
                if(lastChar==c){
                    charStack.removeLast();
                }else{
                    charStack.addLast(c);
                }
            }
            else{
                charStack.addLast(c);
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for(char c:charStack){
            sb.append(c);
        }
        return sb.toString();
    }
}
