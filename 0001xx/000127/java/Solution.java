import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> remainWordSet = new HashSet<>(wordList);
        
        //if(!remainWordSet.contains(beginWord))return 0;
        if(!remainWordSet.contains(endWord))return 0;
        if(beginWord.equals(endWord))return 1;
        
        HashMap<String,Integer> wordLengthMap = new HashMap<>();
        wordLengthMap.put(beginWord,1);
        
        LinkedList<String> wordQ = new LinkedList<>();
        wordQ.addLast(beginWord);
        remainWordSet.remove(beginWord);
        
        while(!wordQ.isEmpty()){
            String word = wordQ.removeFirst();
            int wordLength = wordLengthMap.get(word);
            int nextWordLength = wordLength+1;
            LinkedList<String> nextWordList = new LinkedList<>();
            for(String w:remainWordSet){
                if(!linked(word,w))continue;
                if(w.equals(endWord))return nextWordLength;
                nextWordList.addLast(w);
            }
            for(String w:nextWordList){
                remainWordSet.remove(w);
                wordLengthMap.put(w,nextWordLength);
                wordQ.addLast(w);
            }
        }
        
        return 0;
    }
    
    public boolean linked(String a,String b){
        char[] aCharAry = a.toCharArray();
        char[] bCharAry = b.toCharArray();
        int diffCnt = 0;
        for(int i=0;i<aCharAry.length;++i){
            if(aCharAry[i]!=bCharAry[i])++diffCnt;
        }
        return diffCnt==1;
    }
}
