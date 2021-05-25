import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    String[] dToStrAry = new String[10];
    {
        dToStrAry[2]="abc";
        dToStrAry[3]="def";
        dToStrAry[4]="ghi";
        dToStrAry[5]="jkl";
        dToStrAry[6]="mno";
        dToStrAry[7]="pqrs";
        dToStrAry[8]="tuv";
        dToStrAry[9]="wxyz";
    }
    String digits;
    LinkedList<String> retList = new LinkedList<>();
    char[] strBuilder;

    public List<String> letterCombinations(String digits) {
        if(digits.length()<=0){
            return retList;
        }
        this.strBuilder = new char[digits.length()];
        this.digits = digits;
        recursion(0);
        return retList;
    }
    
    public void recursion(int idx) {
        if(idx==digits.length()){
            retList.add(new String(strBuilder));
            return;
        }
        String sstr = dToStrAry[digits.charAt(idx)-'0'];
        for(char c:sstr.toCharArray()){
            strBuilder[idx]=c;
            recursion(idx+1);
        }
    }
}
