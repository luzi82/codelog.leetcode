import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class StringSearch{

    public static LinkedList<Integer> kmp(String string,String substring){

        char[] S = string.toCharArray();
        char[] W = substring.toCharArray();
    
        // compile
        int[] T = new int[W.length+1];
        T[0]=-1;
        int c=0;
        for(int p=1;p<W.length;++p){
            if(W[p]==W[c]){
                T[p]=T[c];
            }else{
                T[p]=c;
                while((c>=0)&&(W[p]!=W[c]))c=T[c];
            }
            ++c;
        }
        T[W.length]=c;
        
        // search
        LinkedList<Integer> retList = new LinkedList<Integer>();
        c=0;
        for(int p=0;p<S.length;++p){
            while((c>=0)&&(S[p]!=W[c]))c=T[c];
            ++c;
            if(c>=W.length){
                retList.addLast(p+1-W.length); // output
                c=T[c];
            }
        }
        
        return retList;

    }
    
    public static void main(String[] argv){
        LinkedList<Integer> retList;

        retList = kmp("THIS IS A TEST TEXT","TEST");
        aassert(Arrays.equals(retList.toArray(new Integer[0]),new Integer[]{10}));

        retList = kmp("AABAACAADAABAABA","AABA");
        aassert(Arrays.equals(retList.toArray(new Integer[0]),new Integer[]{0,9,12}));

        retList = kmp("ABCABCDABCD","ABCD");
        aassert(Arrays.equals(retList.toArray(new Integer[0]),new Integer[]{3,7}));

        Random random = new Random(0);
        for(int i=0;i<1000;++i){
            StringBuffer sSb = new StringBuffer();
            int sLen = 500+random.nextInt(501);
            for(int j=0;j<sLen;++j){
                sSb.append((char)('A'+random.nextInt(3)));
            }
            String s=sSb.toString();

            StringBuffer wSb = new StringBuffer();
            int wLen = 2+random.nextInt(3);
            for(int j=0;j<wLen;++j){
                wSb.append((char)('A'+random.nextInt(3)));
            }
            String w=wSb.toString();
            
            //System.err.println(String.format("%s %s",s,w));

            LinkedList<Integer> expList = new LinkedList<>();
            for(int j=0;j<s.length();++j){
                String s0 = s.substring(j,Math.min(j+w.length(),s.length()));
                if(s0.equals(w)){
                    expList.addLast(j);
                }
            }
            
            retList = kmp(s,w);

            //System.err.println(
            //    String.format(
            //        "%s %s",
            //        join(expList.toArray(new Integer[0])),join(retList.toArray(new Integer[0]))
            //    )
            //);

            aassert(expList.equals(retList));
        }
    }

    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(Object v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(v.toString());
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
    
}
