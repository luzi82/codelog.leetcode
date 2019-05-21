import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // monkey
        Random rand = new Random(0);
        for(int c=0;c<1000;++c){
            AllOne ao = new AllOne();
            int[] charToCnt = new int[26];
            for(int i=0;i<1000;++i){
                int cc = rand.nextInt(26);
                int pn = rand.nextInt(2);
                String key = new StringBuffer().append((char)('a'+cc)).toString();
                //System.err.println("key="+key);
                if(pn==0){
                    ++charToCnt[cc];
                    ao.inc(key);
                }else{
                    --charToCnt[cc];
                    charToCnt[cc]=Math.max(0,charToCnt[cc]);
                    ao.dec(key);
                }
                int maxCount = Integer.MIN_VALUE;
                int minCount = Integer.MAX_VALUE;
                for(int cnt:charToCnt){
                    maxCount = Math.max(maxCount,cnt);
                    if(cnt>0){
                        minCount = Math.min(minCount,cnt);
                    }
                }
                //System.err.println("maxCount="+maxCount);
                //System.err.println("minCount="+minCount);
                String resultMaxKey = ao.getMaxKey();
                String resultMinKey = ao.getMinKey();
                //System.err.println("resultMaxKey="+resultMaxKey);
                //System.err.println("resultMinKey="+resultMinKey);
                if(resultMaxKey.equals("")){
                    aassert(maxCount==0);
                }else{
                    aassert(charToCnt[resultMaxKey.charAt(0)-'a']==maxCount);
                }
                if(resultMinKey.equals("")){
                    aassert(maxCount==0);
                }else{
                    aassert(charToCnt[resultMinKey.charAt(0)-'a']==minCount);
                }
            }
        }
    }
    
    public static String join(int[][] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int[] v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(join(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Integer.toString(v));
        }
        sb.append("]");
        return sb.toString();
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
