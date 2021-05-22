import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char[] cAry = paragraph.toCharArray();
        for(char c:cAry){
            if(c<'a'){sb.append(' ');continue;}
            if(c>'z'){sb.append(' ');continue;}
            sb.append(c);
        }
        paragraph = sb.toString();
        
        HashSet<String> banStrSet = new HashSet<>(Arrays.asList(banned));
        banStrSet.add("");
        
        String[] strAry = paragraph.split(Pattern.quote(" "));
        Arrays.sort(strAry);
        int tmpCnt=-1;
        String tmpStr="";
        int bestCnt=-1;
        String bestStr="";
        for(String str:strAry){
            if(banStrSet.contains(str))continue;
            if(!str.equals(tmpStr)){
                tmpStr=str;
                tmpCnt=0;
            }
            ++tmpCnt;
            if(tmpCnt>bestCnt){
                bestCnt=tmpCnt;
                bestStr=str;
            }
        }
        
        return bestStr;
    }
}
