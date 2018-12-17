import java.util.*;

class Solution {
    public String makeLargestSpecial(String S) {
    
        char[] charAry = S.toCharArray();
        
        LinkedList< LinkedList < String > > stringListStack = new LinkedList<>();
        stringListStack.push(new LinkedList<String>()); // root
        
        for(int i=0;i<charAry.length;++i){
            if(charAry[i] == '1'){
                stringListStack.push(new LinkedList<String>());
            }else{
                LinkedList<String> topStrList = stringListStack.pop();
                Collections.sort(topStrList);
                Collections.reverse(topStrList);
                String topStr = "1" + String.join("",topStrList) + "0";
                stringListStack.peek().add(topStr);
            }
        }

        LinkedList<String> strList = stringListStack.pop();
        Collections.sort(strList);
        Collections.reverse(strList);
        String ret = String.join("",strList);
        
        return ret;
    
    }
}
