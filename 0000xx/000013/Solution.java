import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int romanToInt(String s) {
        char[] sCharAry = s.toCharArray();
        int ptr = 0;
        int ret = 0;
        while(ptr<sCharAry.length){
            if(ptr<sCharAry.length-1){
                if((sCharAry[ptr]=='I')&&(sCharAry[ptr+1]=='V')){
                    ret += 4;
                    ptr += 2;
                    continue;
                }
                if((sCharAry[ptr]=='I')&&(sCharAry[ptr+1]=='X')){
                    ret += 9;
                    ptr += 2;
                    continue;
                }
                if((sCharAry[ptr]=='X')&&(sCharAry[ptr+1]=='L')){
                    ret += 40;
                    ptr += 2;
                    continue;
                }
                if((sCharAry[ptr]=='X')&&(sCharAry[ptr+1]=='C')){
                    ret += 90;
                    ptr += 2;
                    continue;
                }
                if((sCharAry[ptr]=='C')&&(sCharAry[ptr+1]=='D')){
                    ret += 400;
                    ptr += 2;
                    continue;
                }
                if((sCharAry[ptr]=='C')&&(sCharAry[ptr+1]=='M')){
                    ret += 900;
                    ptr += 2;
                    continue;
                }
            }
            if(sCharAry[ptr]=='I')ret+=1;
            else if(sCharAry[ptr]=='V')ret+=5;
            else if(sCharAry[ptr]=='X')ret+=10;
            else if(sCharAry[ptr]=='L')ret+=50;
            else if(sCharAry[ptr]=='C')ret+=100;
            else if(sCharAry[ptr]=='D')ret+=500;
            else if(sCharAry[ptr]=='M')ret+=1000;
            
            ++ptr;
        }
        
        return ret;
    }
}
