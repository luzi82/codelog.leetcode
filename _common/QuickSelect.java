import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class QuickSelect{

    public static int quickSelect(int[] vAry,int k){
        int start=0, end=vAry.length;
        while(true){
            int[] pivot = partion(vAry,start,end);
            if(pivot[0]>k) end=pivot[0];
            else if(pivot[1]<=k) start=pivot[1];
            else return vAry[k];
        }
    }

    public static Random random = new Random(0);
    public static int[] partion(int[] vAry,int start,int end){
        int rVal = vAry[start+random.nextInt(end-start)];
        // vAry[start,i)<rVal, vAry[i,j)==rVal, vAry[k,end)>rVal
        int i=start, j=start, k=end;
        while(j<k){
            if(vAry[j]==rVal){
                ++j;
            }else if(vAry[j]<rVal){
                swap(vAry,i,j);
                ++i;++j;
            }else{
                swap(vAry,j,k-1);
                --k;
            }
        }
        return new int[]{i,j};
    }
    
    public static void swap(int[] vAry,int a,int b){
        int t=vAry[a];vAry[a]=vAry[b];vAry[b]=t;
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
