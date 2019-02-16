import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new LinkedList<>();
    
        // endWord not in wordList case
        if(!wordList.contains(endWord)){
            return ret;
        }
        
        Map<String, List<String> > wordToLastWordListMap = new HashMap<>();
        
        List<String> remainWordList = new LinkedList<>(wordList);
        
        Set<String> bfsHeadWordSet = new HashSet<>();
        bfsHeadWordSet.add(beginWord);
        
        while(true){
            Set<String> nextBfsHeadWordSet = new HashSet<>();
            
            for(String bfsHeadWord : bfsHeadWordSet){
                for(String remainWord : remainWordList){
                    if(!canTransform(bfsHeadWord,remainWord))continue;
                    //System.err.println(String.format("%s -> %s", bfsHeadWord, remainWord));
                    addLastWord(wordToLastWordListMap, remainWord, bfsHeadWord);
                    nextBfsHeadWordSet.add(remainWord);
                }
            }

            remainWordList.removeAll(nextBfsHeadWordSet);
            
            // check loop break;
            bfsHeadWordSet = nextBfsHeadWordSet;
            if(wordToLastWordListMap.containsKey(endWord)){
                if(!wordToLastWordListMap.get(endWord).isEmpty()){
                    break;
                }
            }
            if(bfsHeadWordSet.isEmpty())break;
        }
        
        //for(Map.Entry< String, List<String> > wordToLastWordList : wordToLastWordListMap.entrySet()){
        //    System.err.println(wordToLastWordList.getKey());
        //    System.err.print("->");
        //    for(String lastWord:wordToLastWordList.getValue()){
        //        System.err.print(" "+lastWord);
        //    }
        //    System.err.println();
        //}
        
        // check no answer
        if(!wordToLastWordListMap.containsKey(endWord)){
            return ret;
        }
        if(wordToLastWordListMap.get(endWord).isEmpty()){
            return ret;
        }
        
        // build seqs
        LinkedList<String> seqWordList = new LinkedList<>();
        seqWordList.addFirst(endWord);
        dfs(ret, seqWordList, wordToLastWordListMap, beginWord);
        
        return ret;
    }
    
    public static boolean canTransform(String s0, String s1){
        int diffCount = 0;
        char[] s0CharAry = s0.toCharArray();
        char[] s1CharAry = s1.toCharArray();
        for(int i=0;i<s0CharAry.length;++i){
            if(s0CharAry[i]==s1CharAry[i])continue;
            ++diffCount;
            if(diffCount>1)return false;
        }
        return diffCount == 1;
    }
    
    public static void addLastWord(Map<String, List<String> > wordToLastWordListMap, String toWord, String fromWord){
        if(!wordToLastWordListMap.containsKey(toWord))
            wordToLastWordListMap.put(toWord,new LinkedList<String>());
        List<String> lastWordList = wordToLastWordListMap.get(toWord);
        lastWordList.add(fromWord);
    }
    
    public static void dfs(List<List<String>> ret, LinkedList<String> seqWordList, Map<String, List<String> > wordToLastWordListMap, String beginWord){
        String startWord = seqWordList.get(0);
        
        if(startWord.equals(beginWord)){
            ret.add(new LinkedList<String>(seqWordList));
            return;
        }
        
        if(!wordToLastWordListMap.containsKey(startWord))throw new Error();
        
        List<String> lastWordList = wordToLastWordListMap.get(startWord);
        if(lastWordList.isEmpty())throw new Error();
        
        for(String lastWord : lastWordList){
            seqWordList.addFirst(lastWord);
            dfs(ret, seqWordList, wordToLastWordListMap, beginWord);
            seqWordList.removeFirst();
        }
    }
}
