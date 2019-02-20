import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        LinkedList<String> ret = new LinkedList<>();
        
        LinkedList<String> lineWordList = new LinkedList<>();
        int charCount = 0;
        for(String word:words){
            int newCharCount = charCount + word.length();
            int newRemainCharCount = maxWidth - newCharCount;

            if(newRemainCharCount < lineWordList.size()){
                if(lineWordList.size()==1){
                    StringBuilder sb = new StringBuilder();
                    sb.append(lineWordList.getFirst());
                    while(sb.length()<maxWidth)sb.append(" ");
                    ret.add(sb.toString());
                }else{
                    int remainCharCount = maxWidth - charCount;
                    int spaceMin = remainCharCount / (lineWordList.size()-1);
                    int bigSpaceCount = remainCharCount % (lineWordList.size()-1);
                    Iterator<String> lineWordItr = lineWordList.iterator();
                    StringBuilder sb = new StringBuilder();
                    sb.append(lineWordItr.next());
                    for(int i=0;i<bigSpaceCount;++i){
                        for(int j=0;j<spaceMin+1;++j)sb.append(" ");
                        sb.append(lineWordItr.next());
                    }
                    while(lineWordItr.hasNext()){
                        for(int j=0;j<spaceMin;++j)sb.append(" ");
                        sb.append(lineWordItr.next());
                    }
                    ret.add(sb.toString());
                }
                lineWordList.clear();
                charCount = 0;
            }

            lineWordList.add(word);
            charCount += word.length();
        }
        {
            Iterator<String> lineWordItr = lineWordList.iterator();
            StringBuilder sb = new StringBuilder();
            sb.append(lineWordItr.next());
            while(lineWordItr.hasNext()){
                sb.append(" ");
                sb.append(lineWordItr.next());
            }
            while(sb.length()<maxWidth)sb.append(" ");
            ret.add(sb.toString());
        }
        
        return ret;
    }
}
