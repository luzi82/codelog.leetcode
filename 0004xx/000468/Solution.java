import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    final static String BAD = "Neither";
    final static String IP4 = "IPv4";
    final static String IP6 = "IPv6";

    public String validIPAddress(String IP) {
        char[] cAry = IP.toCharArray();
        
        for(char c:cAry){
            if(('0'<=c)&&(c<='9'))continue;
            if(('a'<=c)&&(c<='f'))continue;
            if(('A'<=c)&&(c<='F'))continue;
            if(c==':')continue;
            if(c=='.')continue;
            return BAD;
        }
        
        boolean contains4=false;
        boolean contains6=false;
        
        for(char c:cAry){
            contains4 = contains4 || (c=='.');
            contains6 = contains6 || (c==':');
        }
        
        if(contains4==contains6) return BAD;
        
        if(contains4&&check4(IP))return IP4;
        if(contains6&&check6(IP))return IP6;
        
        return BAD;
    }
    
    public static boolean check4(String IP){
        //System.err.println("check4");
        char[] cAry = IP.toCharArray();

        for(char c:cAry){
            if(('0'<=c)&&(c<='9'))continue;
            if(c=='.')continue;
            return false;
        }
        
        int dotCount = 0;
        for(char c:cAry){
            if(c=='.')++dotCount;
        }
        if(dotCount!=3)return false;
        
        String[] ips = IP.split(Pattern.quote("."));
        //System.err.println(""+ips.length);
        if(ips.length!=4)return false;
        for(String i:ips){
            //System.err.println(i);
            if(i.length()<=0)return false;
            if(i.length()>3)return false;
            if((i.length()>1) && (i.charAt(0)=='0'))return false;
            int ii = Integer.parseInt(i);
            if(ii>=256)return false;
        }
        
        return true;
    }

    public static boolean check6(String IP){
        char[] cAry = IP.toCharArray();

        int dotCount = 0;
        for(char c:cAry){
            if(c==':')++dotCount;
        }
        if(dotCount!=7)return false;

        String[] ips = IP.split(Pattern.quote(":"));
        if(ips.length!=8)return false;
        for(String i:ips){
            if(i.length()<=0)return false;
            if(i.length()>4)return false;
        }
        
        return true;
    }

}

