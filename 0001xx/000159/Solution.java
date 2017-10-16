import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // edge case
        if(s.length()<=2){
            return s.length();
        }
        
        int answer = 0;
        
        HashMap<Character,Integer> charCount = new HashMap<>();
        int i=0; // start of string
        for(int j=0;j<s.length();++j){
            // add new char
            char c = s.charAt(j);

            int count;
            if(charCount.containsKey(c)){
                count = charCount.get(c);
            }else{
                count = 0;
            }
            ++count;
            charCount.put(c,count);
            
            // pop old char when need
            while(charCount.size() > 2){
                c = s.charAt(i);
                count = charCount.get(c);
                --count;
                
                if(count>0){
                    charCount.put(c,count);
                }else{
                    charCount.remove(c);
                }
                ++i;
            }
            
            // update answer
            answer = Math.max(answer, j+1-i);
        }
        
        return answer;
    }
}
