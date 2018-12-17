import java.util.*;

// TLE

class Solution {
    public String makeLargestSpecial(String S) {
        HashSet<String> doneStringSet = new HashSet<>();
        LinkedList<String> stringQueue = new LinkedList<>();
        
        String ans = S;

        doneStringSet.add(S);
        stringQueue.offer(S);

        while(!stringQueue.isEmpty()){
            String s = stringQueue.poll();
            char[] charAry = s.toCharArray();
            
            for(int i=0;i<charAry.length;++i){

                int iZeroCount=0;
                int iOneCount=0;
                for(int j=i+1;j<charAry.length;++j){
                    if(charAry[j-1]=='0'){
                        ++iZeroCount;
                    }else{
                        ++iOneCount;
                    }
                    if(iOneCount<iZeroCount)break;
                    if(iOneCount!=iZeroCount)continue;
    
                    int jZeroCount=0;
                    int jOneCount=0;
                    for(int k=j+1;k<=charAry.length;++k){
                        if(charAry[k-1]=='0'){
                            ++jZeroCount;
                        }else{
                            ++jOneCount;
                        }
                        if(jOneCount<jZeroCount)break;
                        if(jOneCount!=jZeroCount)continue;
                        
                        String newString = swap(s,i,j,k);
                        if(doneStringSet.contains(newString))continue;
                        doneStringSet.add(newString);

                        stringQueue.offer(newString);
                        if(newString.compareTo(ans)>0){
                            ans = newString;
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    static String swap(String s,int i,int j,int k){
        return s.substring(0,i)+s.substring(j,k)+s.substring(i,j)+s.substring(k);
    }
    
    static int compare(char[] a,char[] b){
        for(int i=0;i<a.length;++i){
            if(a[i]>b[i])return 1;
            if(a[1]<b[i])return -1;
        }
        return 0;
    }
}
