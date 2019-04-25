import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class QuickSelect{

    public static int quickSelect(int[] vAry,int k){
        int start=0,end = vAry.length-1;
        while(start<end){
            int pivot = partion(vAry,start,end);
            if(pivot<k) start = pivot+1;
            else if(pivot>k) end = pivot-1;
            else return vAry[k];
        }
        return vAry[k];
    }

    public static Random random = new Random(0);
    public static int partion(int[] vAry,int start,int end){
        int rIdx = start+random.nextInt(end-start+1);
        int rVal = vAry[rIdx];
        swap(vAry,rIdx,end);
        int s=start,e=end-1;
        while(s<e){
            while(s<e && vAry[s]<rVal)++s;
            while(s<e && vAry[e]>=rVal)--e;
            if(s>=e)break;
            swap(vAry,s,e);
        }
        while(s<end && vAry[s]<rVal)++s;
        swap(vAry,s,end);
        return s;
    }
    
    public static void swap(int[] vAry,int a,int b){
        int t=vAry[a];vAry[a]=vAry[b];vAry[b]=t;
    }

}

    public static void main(String[] argv){
        Random random = new Random(0);
        for(int i=0;i<100000;++i){
            int len = 1+random.nextInt(20);
            int[] vAry = new int[len];
            for(int j=0;j<len;++j){
                vAry[j] = random.nextInt(20);
            }
            int k = random.nextInt(len);
            int[] vAry0 = vAry.clone();
            int v0 = quickSelect(vAry0,k);
            int[] vAry1 = vAry.clone();
            Arrays.sort(vAry1);
            int v1 = vAry1[k];
            if(v0!=v1){
                System.out.println("no good");
                System.exit(1);
            }
        }
        System.out.println("good");
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
