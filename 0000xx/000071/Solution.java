import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String simplifyPath(String path) {
        // path = "/a/../../b/../c//.//"
    
        String[] pathSplit = path.split(Pattern.quote("/"));
        // pathSplit = {"a","..","..","b","..","c","",".","",""}
        
        LinkedList<String> retList = new LinkedList<>();
        
        for(String name:pathSplit){
            if(name.equals("")){continue;}
            if(name.equals(".")){continue;}
            if(name.equals("..")){
                if(retList.size()>0){
                    retList.removeLast();
                }
                continue;
            }
            retList.addLast(name);
        }
        // retList = {"c"}
        
        if(retList.size()<=0){return "/";}

        StringBuffer retSb = new StringBuffer();
        for(String name:retList){
            retSb.append("/");
            retSb.append(name);
        }
        // retSb = "/c"
        
        return retSb.toString();
    }
}
