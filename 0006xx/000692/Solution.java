import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> wordToCountMap = new HashMap<String,Integer>();
        HashMap<Integer,TreeSet<String>> countToWordSetMap = new HashMap<Integer,TreeSet<String>>();
        
        int maxCount = 0;
        
        for(String word:words){
            int count = getCount(word,wordToCountMap);
            remove(count,word,countToWordSetMap);
            ++count;
            wordToCountMap.put(word,count);
            put(count,word,countToWordSetMap);
            maxCount = Math.max(maxCount,count);
        }
        
        LinkedList<String> retList = new LinkedList<String>();
        
        TreeSet<String> wordSet=countToWordSetMap.get(maxCount);
        while(k>0){
            while(wordSet.size()==0){
                --maxCount;
                wordSet=countToWordSetMap.get(maxCount);
            }
            retList.add(wordSet.pollFirst());
            --k;
        }
        
        return retList;
    }
    
    public static int getCount(String word,HashMap<String,Integer> wordToCountMap){
        if(!wordToCountMap.containsKey(word))return 0;
        return wordToCountMap.get(word);
    }
    
    public static void remove(int count,String word,HashMap<Integer,TreeSet<String>> countToWordSetMap){
        if(count==0)return;
        countToWordSetMap.get(count).remove(word);
    }
    
    public static void put(int count,String word,HashMap<Integer,TreeSet<String>> countToWordSetMap){
        if(!countToWordSetMap.containsKey(count)){
            countToWordSetMap.put(count,new TreeSet<String>());
        }
        countToWordSetMap.get(count).add(word);
    }
}
