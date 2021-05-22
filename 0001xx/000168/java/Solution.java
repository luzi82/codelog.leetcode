import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
  public String convertToTitle(int n) {
    Vector<Character> retRevVec = new Vector<>();
    while(n>0){
      int d = ((n%26)+25)%26; // beware of super big n
      retRevVec.add((char)('A'+d));
      --n;
      n/=26;
    }
    
    char[] retCharAry = new char[retRevVec.size()];
    for(int i=0;i<retRevVec.size();++i){
      int j = retCharAry.length-1-i;
      retCharAry[j] = retRevVec.get(i);
    }
    
    String retStr = new String(retCharAry);
    return retStr;
  }
}
