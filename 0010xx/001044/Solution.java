import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public String longestDupSubstring(String S) {
        int start = 0;
        int end = S.length();
        
        char[] cAry = S.toCharArray();
        int[] vAry = new int[cAry.length];
        for(int i=0;i<cAry.length;++i){
            vAry[i] = cAry[i]-'a';
        }

        String ret = "";
        while(start<end-1){
            int mid = (start+end)/2;
            int found = find(vAry,mid);
            if(found==-1){
                end=mid;
            }else{
                ret=S.substring(found,found+mid);
                start=mid;
            }
        }
        
        return ret;
    }
    
    final static long BIG = 1000000007L;
    public static int find(int[] vAry,int len){
        //System.err.println(String.format("len=%d",len));
        long hashBye = 1;
        for(int i=0;i<len;++i){
            hashBye*=26;
            hashBye%=BIG;
        }
        
        HashMap<Long,LinkedList<Integer>> hashToOffsetListMap = new HashMap<Long,LinkedList<Integer>>();
        
        long hash = 0;
        int p=0;
        for(;p<len-1;++p){
            hash*=26;
            hash+=vAry[p];
            hash%=BIG;
        }
        hash*=26;
        hash+=vAry[p];
        hash%=BIG;
        hashToOffsetListMap.put(hash,new LinkedList<Integer>());
        hashToOffsetListMap.get(hash).addLast(p);
        ++p;
        for(;p<vAry.length;++p){
            hash*=26;
            hash+=vAry[p];
            hash+=vAry[p-len]*(BIG-hashBye);
            hash%=BIG;
            if(hashToOffsetListMap.containsKey(hash)){
                LinkedList<Integer> offsetList = hashToOffsetListMap.get(hash);
                for(int offset:offsetList){
                    if(eq(vAry,p+1-len,offset+1-len,len))return p+1-len;
                }
            }
            if(!hashToOffsetListMap.containsKey(hash)){
                hashToOffsetListMap.put(hash,new LinkedList<Integer>());
            }
            hashToOffsetListMap.get(hash).addLast(p);
        }
        
        return -1;
    }
    
    public static boolean eq(int[] vAry,int o0,int o1,int len){
        for(int i=0;i<len;++i){
            if(vAry[o0+i]!=vAry[o1+i])return false;
        }
        return true;
    }
}
