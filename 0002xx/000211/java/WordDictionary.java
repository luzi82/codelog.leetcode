import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class WordDictionary {

    HashMap<Integer,Tree> lenToTreeMap = new HashMap<>();
    
    /** Initialize your data structure here. */
    public WordDictionary() {
    }
    
    public void addWord(String word) {
        if(!lenToTreeMap.containsKey(word.length())){
            lenToTreeMap.put(word.length(),new Tree());
        }
        char[] cAry = word.toCharArray();
        lenToTreeMap.get(word.length()).add(cAry,0);
    }
    
    public boolean search(String word) {
        if(!lenToTreeMap.containsKey(word.length()))return false;
        char[] cAry = word.toCharArray();
        return lenToTreeMap.get(word.length()).search(cAry,0);
    }
    
    class Tree{
        public Tree[] childAry = new Tree[26];
        public void add(char[] cAry,int idx){
            if(idx==cAry.length)return;
            int cIdx = cAry[idx]-'a';
            if(childAry[cIdx]==null){
                childAry[cIdx]=new Tree();
            }
            childAry[cIdx].add(cAry,idx+1);
        }
        public boolean search(char[] cAry,int idx){
            if(idx==cAry.length)return true;
            char c=cAry[idx];
            if(c=='.'){
                for(Tree child:childAry){
                    if(child==null)continue;
                    if(child.search(cAry,idx+1))return true;
                }
                return false;
            }
            int cIdx = cAry[idx]-'a';
            if(childAry[cIdx]==null)return false;
            return childAry[cIdx].search(cAry,idx+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
