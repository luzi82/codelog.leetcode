import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    static class Unit implements Comparable<Unit>{
        
        public char type;
        
        public String id;
        public int lineNum;
        
        public String wordAfter;
        
        public Unit(int lineNum,String s){
            String[] idWa = s.split(Pattern.quote(" "),2);
            this.id = idWa[0];
            this.wordAfter = idWa[1];
            this.lineNum = lineNum;
            
            for(char c:wordAfter.toCharArray()){
                if(c>='0'&&c<='9'){
                    type = '0';
                }else if(c>='a'&&c<='z'){
                    type = 'a';
                }
            }
        }
        
        public int compareTo(Unit u){
            if(this.type=='a'&&u.type=='0'){
                return -1;
            }else if(this.type=='0'&&u.type=='a'){
                return 1;
            }
            if(this.type=='0'){
                if(this.lineNum<u.lineNum)return -1;
                if(this.lineNum>u.lineNum)return 1;
                return 0;
            }
            int ret= this.wordAfter.compareTo(u.wordAfter);
            if(ret!=0)return ret;
            return this.id.compareTo(u.id);
        }
        
        public String toString(){
            return String.format("%s %s",id,wordAfter);
        }
        
    }
    
    public String[] reorderLogFiles(String[] logs) {
        Unit[] uAry = new Unit[logs.length];
        
        for(int i=0;i<logs.length;++i){
            uAry[i] = new Unit(i,logs[i]);
        }
        
        Arrays.sort(uAry);

        String[] retAry = new String[logs.length];
        
        for(int i=0;i<logs.length;++i){
            retAry[i] = uAry[i].toString();
        }
        
        return retAry;
    }
}
