import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int longestStrChain(String[] words) {
        HashSet<String>[] lenToStringSetAry = new HashSet[17];
        for(int i=0;i<lenToStringSetAry.length;++i){
            lenToStringSetAry[i]=new HashSet<String>();
        }
        for(String word:words){
            lenToStringSetAry[word.length()].add(word);
        }
        
        HashMap<String,Integer> wordToK = new HashMap<>();
        
        int ret = 0;
        
        for(int i=1;i<lenToStringSetAry.length;++i){
            HashSet<String> stringSet = lenToStringSetAry[i];
            HashSet<String> lastStringSet = lenToStringSetAry[i-1];
            for(String string:stringSet){
                for(String lastString:lastStringSet){
                    if(!isPredecessor(lastString,string))continue;
                    int lastStringK = 0;
                    if(wordToK.containsKey(lastString)){
                        lastStringK = wordToK.get(lastString);
                    }
                    int stringK = lastStringK+1;
                    if(wordToK.containsKey(string)){
                        stringK = Math.max(stringK,wordToK.get(string));
                    }
                    wordToK.put(string,stringK);
                    ret = Math.max(ret,stringK);
                }
            }
        }
        
        return ret+1;
    }
    
    public static boolean isPredecessor(String a,String b){
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        int aDone = 0;
        for(char bChar:bCharArray){
            if(bChar==aCharArray[aDone]){
                ++aDone;
                if(aDone>=aCharArray.length)return true;
            }
        }
        return false;
    }
}