import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class BinarySearch{

    // return { found?, idx }
    public static int[] binarySearch(int[] vAry, int k){
        if(k<vAry[0])return new int[]{0,-1};
        if(k>vAry[vAry.length-1])return new int[]{0,vAry.length-1};
        
        int startIdx=0, endIdx=vAry.length;
        while(true){
            int midIdx = (startIdx+endIdx-1)/2;
            if (vAry[midIdx]==k) return new int[]{1,midIdx};
            if((vAry[midIdx]<k) && (k<vAry[midIdx+1])) return new int[]{0,midIdx};
            if (vAry[midIdx]<k) startIdx=midIdx+1;
            if (vAry[midIdx]>k) endIdx=midIdx;
        }
    }

    public static int[] binarySearch0(int[] vAry, int k){
        int ret = Arrays.binarySearch(vAry,k);
        if(ret>=0)return new int[]{1,ret};
        else return new int[]{0,-ret-2};
    }
    
    public static void main(String[] argv){
        Random random = new Random(0);
        for(int c=0;c<1000;++c){
            int vLen = 1+random.nextInt(21);
            int[] vAry = new int[vLen];
            for(int i=0;i<vLen;++i){
                vAry[i] = 2+random.nextInt(21);
            }
            
            Arrays.sort(vAry);
            //System.out.println(join(vAry));
            
            for(int cc=0;cc<1000;++cc){
                int k = random.nextInt(21+4);
                int[] result = binarySearch(vAry, k);
                //System.out.println(String.format("%d %s",k,join(result)));
                boolean found = result[0]==1;
                int idx = result[1];
                if(found){
                    aassert(vAry[idx] == k);
                }else{
                    if(idx>=0){
                        aassert(vAry[idx] < k);
                    }
                    if(idx+1<vAry.length){
                        aassert(vAry[idx+1] > k);
                    }
                }
            }
        }
        System.err.println("BinarySearch GOOD");
    }

    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }

    public static String join(int[] ary){
        return join(ary,0,ary.length);
    }

    public static String join(int[] ary,int s,int e){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int i=s;i<e;++i){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Integer.toString(ary[i]));
        }
        sb.append("]");
        return sb.toString();
    }

}
