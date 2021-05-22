import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String addBinary(String a, String b) {
        char[] aCAry = a.toCharArray();
        char[] bCAry = b.toCharArray();
        
        int size = Math.max(aCAry.length,bCAry.length)+1;
        aCAry = appendZ(aCAry,size);
        bCAry = appendZ(bCAry,size);
        
        char[] cCAry = new char[size];
        int carry = 0;
        for(int i=size-1;i>=0;--i){
            char aC = aCAry[i];
            char bC = bCAry[i];
            carry += (aC=='1')?1:0;
            carry += (bC=='1')?1:0;
            cCAry[i] = (carry%2==1)?'1':'0';
            carry/=2;
        }
        
        int firstOneIdx = 0;
        while(true){
            if(firstOneIdx>=cCAry.length)return "0";
            if(cCAry[firstOneIdx]=='1')break;
            ++firstOneIdx;
        }
        
        return new String(cCAry,firstOneIdx,cCAry.length-firstOneIdx);
    }
    
    public char[] appendZ(char[] cAry,int len){
        char[] retAry = new char[len];
        for(int i=0;i<len;++i){
            retAry[i]='0';
        }
        for(int i=0;i<cAry.length;++i){
            int j = len-cAry.length+i;
            retAry[j]=cAry[i];
        }
        return retAry; 
    }
}
