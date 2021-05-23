import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
  public String longestPalindrome(String s) {
    if(s.length()<=0)return "";
  
    char[] xAry = new char[s.length()*2-1];
    for(int i=0;i<s.length();++i){
      xAry[i*2] = s.charAt(i);
    }
    
    int bestSLeft = 0;
    int bestSLen = 1;
    
    int[] xCenterToRadius = new int[xAry.length];
    int xRight = 1;
    int xCenter = 1;
    while(true){
      if(xRight>=xAry.length)break;
      while(true){
        if(xRight>=xAry.length)break;
        int xLeft = 2*xCenter-xRight;
        if(xLeft<0)break;
        if(xAry[xLeft]!=xAry[xRight])break;
        ++xRight;
      }
      int xRadius = xRight-xCenter-1;
      xCenterToRadius[xCenter] = xRadius;
      int sLeft = (xCenter-xRadius+1)/2;
      int sRight = (xCenter+xRadius+2)/2;
      int sLen = sRight - sLeft;
      if(sLen>bestSLen){
        bestSLen = sLen;
        bestSLeft = sLeft;
      }
      int xRight0;
      for(xRight0 = xCenter+1;xRight0<xRight;++xRight0){
        int xLeft0 = 2*xCenter-xRight0;
        int xRadius0 = xCenterToRadius[xLeft0];
        int maxRadius0 = xRadius - (xRight0-xCenter);
        if(xRadius0>=maxRadius0){
          xCenterToRadius[xRight0] = maxRadius0;
          break;
        }else{
          xCenterToRadius[xRight0] = xRadius0;
        }
      }
      xCenter = xRight0;
    }
    //System.out.println(Test.join(xCenterToRadius));
    return s.substring(bestSLeft,bestSLeft+bestSLen);
  }
}
