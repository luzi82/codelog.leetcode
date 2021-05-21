import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

/**
 * Do the thing using A* search
 * Runtime not better than Solution.0.java, but better memory consumption.
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))return 0;

        HashMap<String,Integer> wordToGMap = new HashMap<>();
        PriorityQueue<Unit> searchQ = new PriorityQueue<>();
        Unit startUnit = new Unit();
        startUnit.g = 1;
        startUnit.hg = diff(beginWord,endWord)+1;
        startUnit.word = beginWord;
        searchQ.add(startUnit);
        wordToGMap.put(beginWord,1);
        //wordSet.remove(beginWord);
        
        while(searchQ.size()>0){
            Unit unit = searchQ.poll();

            int g = unit.g;
            String word = unit.word;
            if(wordToGMap.containsKey(endWord)&&wordToGMap.get(endWord)<=g+1)break;
            if(g!=wordToGMap.get(word))continue;
            wordSet.remove(word);
            
            //HashSet<String> rmWordSet = new HashSet<String>();
            for(String word0:wordSet){
                if(wordToGMap.containsKey(word0)&&wordToGMap.get(word0)<=g+1)continue;
                if(diff(word,word0)>1)continue;
                //if(word0.equals(endWord))return g+1;
                Unit nxtUnit = new Unit();
                nxtUnit.g = g+1;
                nxtUnit.hg = nxtUnit.g+diff(endWord,word0);
                nxtUnit.word = word0;
                searchQ.add(nxtUnit);
                wordToGMap.put(word0,g+1);
                //rmWordSet.add(word0);
            }
            //wordSet.removeAll(rmWordSet);
        }
        
        if(!wordToGMap.containsKey(endWord))return 0;
        
        return wordToGMap.get(endWord);
    }
    
    // doing diff cache is slower then cal value directly...
    
    // public HashMap<String,Integer> strToDiffMap = new HashMap<String,Integer>();
    // public int diff(String a,String b){
    //     String key = String.format("%s_%s",a,b);
    //     if(strToDiffMap.containsKey(key))return strToDiffMap.get(key);
    //     String key0 = String.format("%s_%s",b,a);
    //     int ret = _diff(a,b);
    //     strToDiffMap.put(key,ret);
    //     strToDiffMap.put(key0,ret);
    //     return ret;
    // }
    
    public int diff(String a,String b){
    // public int _diff(String a,String b){
        char[] aCAry = a.toCharArray();
        char[] bCAry = b.toCharArray();
        int diff=0;
        for(int i=0;i<aCAry.length;++i){
            if(aCAry[i]==bCAry[i])continue;
            ++diff;
        }
        return diff;
    }
    
    class Unit implements Comparable<Unit>{
        int hg;
        int g;
        String word;
        public int compareTo(Unit other){
            int diff;
            diff = this.hg-other.hg;
            if(diff!=0)return diff;
            diff = this.g-other.g;
            if(diff!=0)return -diff;
            diff = this.word.compareTo(other.word);
            if(diff!=0)return diff;
            return 0;
        }
    }
}
