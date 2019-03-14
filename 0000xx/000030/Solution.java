import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new LinkedList<Integer>();
        if(words.length==0)return ret;

        HashMap<String,Integer> wordToMaxMap = new HashMap<String,Integer>();
        for(String word:words){
            int cnt=(wordToMaxMap.containsKey(word))?wordToMaxMap.get(word):0;
            wordToMaxMap.put(word,cnt+1);
        }
        
        int wordLen = words[0].length();
        for(int offset=0;offset<wordLen;++offset){
            String ss = s.substring(offset);
            String[] sWordAry = split(ss,wordLen);
            HashMap<String,Integer> wordToRemainMap = (HashMap<String,Integer>) wordToMaxMap.clone();

            int good = 0;

            for(int i=0;i<sWordAry.length;++i){
                String sWord = sWordAry[i];
                if(wordToRemainMap.containsKey(sWord)){
                    int remain = wordToRemainMap.get(sWord);
                    if(remain==0)--good;
                    remain--;
                    if(remain==0)++good;
                    wordToRemainMap.put(sWord,remain);
                }
                if(i>=words.length){
                    sWord = sWordAry[i-words.length];
                    if(wordToRemainMap.containsKey(sWord)){
                        int remain = wordToRemainMap.get(sWord);
                        if(remain==0)--good;
                        remain++;
                        if(remain==0)++good;
                        wordToRemainMap.put(sWord,remain);
                    }
                }
                //System.err.println(String.format("i=%d, wordLen=%d, offset=%d, good=%d",i,wordLen,offset,good));
                if(good==wordToRemainMap.size()){
                    //System.err.println(String.format("i=%d, wordLen=%d, offset=%d",i,wordLen,offset));
                    ret.add((i-words.length+1)*wordLen+offset);
                }
            }
        }
        
        return ret;
    }
    
    public static String[] split(String s,int len){
        String[] ret = new String[s.length()/len];
        for(int i=0;i<ret.length;++i){
            ret[i] = s.substring(i*len,(i+1)*len);
        }
        return ret;
    }
}
