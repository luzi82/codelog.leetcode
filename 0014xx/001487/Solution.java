import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String,Integer> nameToStartMap = new HashMap<>();
        HashSet<String> doneName = new HashSet<>();
        String[] retAry = new String[names.length];

        for(int i=0;i<names.length;++i){
          String name = names[i];
          if(!doneName.contains(name)){
            retAry[i] = name;
            doneName.add(name);
            continue;
          }
          int trial = 1;
          if(nameToStartMap.containsKey(name)){
            trial=nameToStartMap.get(name);
          }
          String nname = null;
          while(true){
            nname = String.format("%s(%d)",name,trial);
            if(!doneName.contains(nname))break;
            ++trial;
          }
          retAry[i] = nname;
          doneName.add(nname);
          nameToStartMap.put(name,trial+1);
        }

        return retAry;
    }
}
