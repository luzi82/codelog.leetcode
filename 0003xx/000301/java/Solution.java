import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashMap<Integer,HashSet<String>> lvToStrSetMap = new HashMap<>();
        HashMap<Integer,Integer> lvToLenMap = new HashMap<>();
        HashMap<Integer,HashSet<String>> nxtLvToStrSetMap = new HashMap<>();
        HashMap<Integer,Integer> nxtLvToLenMap = new HashMap<>();
        
        add(lvToStrSetMap,lvToLenMap,0,"");
        
        char[] cAry = s.toCharArray();
        for(char c:cAry){
            nxtLvToStrSetMap.clear();
            nxtLvToLenMap.clear();
            for(Map.Entry<Integer,HashSet<String>> lvToStrSetMe:lvToStrSetMap.entrySet()){
                int lv = lvToStrSetMe.getKey();
                HashSet<String> strSet = lvToStrSetMe.getValue();
                for(String str:strSet){
                    add(nxtLvToStrSetMap,nxtLvToLenMap,lv,str);
                    if(c=='('){
                        add(nxtLvToStrSetMap,nxtLvToLenMap,lv+1,str+c);
                    }else if(c==')'){
                        add(nxtLvToStrSetMap,nxtLvToLenMap,lv-1,str+c);
                    }else{
                        add(nxtLvToStrSetMap,nxtLvToLenMap,lv,str+c);
                    }
                }
            }
            HashMap<Integer,HashSet<String>> tmpLvToStrSetMap = nxtLvToStrSetMap;
            HashMap<Integer,Integer> tmpLvToLenMap = nxtLvToLenMap;
            nxtLvToStrSetMap = lvToStrSetMap;
            nxtLvToLenMap = lvToLenMap;
            lvToStrSetMap=tmpLvToStrSetMap;
            lvToLenMap=tmpLvToLenMap;
        }
        
        return new ArrayList<String>(lvToStrSetMap.get(0));
    }
    
    public void add(HashMap<Integer,HashSet<String>> lvToStrSetMap,HashMap<Integer,Integer> lvToLenMap,int lv,String str){
        if(lv<0)return;
        if(lvToLenMap.containsKey(lv)&&lvToLenMap.get(lv)>str.length())return;
        if(!lvToStrSetMap.containsKey(lv)){
            lvToStrSetMap.put(lv,new HashSet<String>());
        }
        if((!lvToLenMap.containsKey(lv))||str.length()>lvToLenMap.get(lv)){
            lvToStrSetMap.get(lv).clear();
            lvToLenMap.put(lv,str.length());
        }
        lvToStrSetMap.get(lv).add(str);
    }
}
