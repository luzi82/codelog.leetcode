import java.io.*;
import java.util.*;
import java.math.*;

class Solution {

    public String nearestPalindromic(String str) {
        int strLen = str.length();
        long strLong = Long.parseLong(str);
        boolean odd = (strLen%2!=0);
        
        // hardcode [0,9]
        if(strLong==0)return "1";
        if(strLong<10){
            return Long.toString(strLong-1);
        }
        
        long ret = -1;
        long diff = Long.MAX_VALUE;
        
        long v,diff0;
        StringBuilder sb;
        
        // pure Palindromic
        v = buildPalindromic(str.substring(0,strLen/2),odd?str.substring(strLen/2,strLen/2+1):"");
        diff0 = Math.abs(v-strLong);
        if((diff0!=0)&&((diff0<diff)||((diff0==diff)&&(v<ret)))){
            ret = v;
            diff = diff0;
        }

        // 124000421
        for(int i=1;i<=strLen/2;++i){
            if(str.charAt(i-1)=='9')continue;
            sb = new StringBuilder();
            sb.append(str.substring(0,i-1));
            sb.append((char)(str.charAt(i-1)+1));
            while(sb.length()<strLen/2){
                sb.append('0');
            }
            v = buildPalindromic(sb.toString(),odd?"0":"");
            diff0 = Math.abs(v-strLong);
            if((diff0!=0)&&((diff0<diff)||((diff0==diff)&&(v<ret)))){
                ret = v;
                diff = diff0;
            }
        }
        
        // 122999221
        for(int i=1;i<=strLen/2;++i){
            if(str.charAt(i-1)=='0')continue;
            if((str.charAt(i-1)=='1')&&(i==1))continue;
            sb = new StringBuilder();
            sb.append(str.substring(0,i-1));
            sb.append((char)(str.charAt(i-1)-1));
            while(sb.length()<strLen/2){
                sb.append('0');
            }
            v = buildPalindromic(sb.toString(),odd?"9":"");
            diff0 = Math.abs(v-strLong);
            if((diff0!=0)&&((diff0<diff)||((diff0==diff)&&(v<ret)))){
                ret = v;
                diff = diff0;
            }
        }
        
        if(odd){
            char midC = str.charAt(strLen/2);
            // 123464321
            if(midC!='9'){
                sb = new StringBuilder();
                sb.append(str.substring(0,strLen/2));
                v = buildPalindromic(sb.toString(),""+(char)(str.charAt(strLen/2)+1));
                diff0 = Math.abs(v-strLong);
                if((diff0!=0)&&((diff0<diff)||((diff0==diff)&&(v<ret)))){
                    ret = v;
                    diff = diff0;
                }
            }
            // 123444321
            if(midC!='0'){
                sb = new StringBuilder();
                sb.append(str.substring(0,strLen/2));
                v = buildPalindromic(sb.toString(),""+(char)(str.charAt(strLen/2)-1));
                diff0 = Math.abs(v-strLong);
                if((diff0!=0)&&((diff0<diff)||((diff0==diff)&&(v<ret)))){
                    ret = v;
                    diff = diff0;
                }
            }
        }

        // 1000 -> 999
        sb = new StringBuilder();
        while(sb.length()<strLen-1){
            sb.append('9');
        }
        v = Long.parseLong(sb.toString());
        diff0 = Math.abs(v-strLong);
        if((diff0!=0)&&((diff0<diff)||((diff0==diff)&&(v<ret)))){
            ret = v;
            diff = diff0;
        }
        
        
        // 999 -> 1001
        sb = new StringBuilder();
        sb.append('1');
        while(sb.length()<strLen){
            sb.append('0');
        }
        sb.append('1');
        v = Long.parseLong(sb.toString());
        diff0 = Math.abs(v-strLong);
        if((diff0!=0)&&((diff0<diff)||((diff0==diff)&&(v<ret)))){
            ret = v;
            diff = diff0;
        }

        //System.err.println(""+ret);
        return Long.toString(ret);
    }
    
    public static long buildPalindromic(String prefix,String mid){
        //System.err.println(String.format("NLQQYBLTCY buildPalindromic %s %s",prefix,mid));
        char[] prefixCharAry = prefix.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(mid);
        for(int i=prefixCharAry.length-1;i>=0;--i){
            sb.append(prefixCharAry[i]);
        }
        long ret = Long.parseLong(sb.toString());
        //System.err.println(String.format("WTLEIGOOEL %d",ret));
        return ret;
    }

}