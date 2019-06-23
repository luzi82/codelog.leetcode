import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public double[] sampleStats(int[] count) {
        int min = -1;
        for(int i=0;i<count.length;++i){
            if(count[i]==0)continue;
            min = i;
            break;
        }
        
        int max = -1;
        for(int i=count.length-1;i>=0;--i){
            if(count[i]==0)continue;
            max = i;
            break;
        }
        
        int countSum = 0;
        double sum = 0;
        for(int i=0;i<count.length;++i){
            countSum += count[i];
            sum += i * count[i];
        }
        double mean = sum/countSum;
        
        double median = -1;
        if(countSum%2==0){
            int countSum2 = countSum/2;
            
            median=0;

            int ii = 0;
            while(countSum2>0){
                countSum2-=count[ii];
                ++ii;
            }
            //System.err.println(ii);
            median += (ii-1);
            while(countSum2>=0){
                countSum2-=count[ii];
                ++ii;
            }
            //System.err.println(ii);
            median += (ii-1);
            //System.err.println(median);
            median /= 2;
            //System.err.println(median);
        }else{
            int countSum2 = countSum/2;
            ++countSum2;
            
            for(int i=0;i<count.length;++i){
                countSum2-=count[i];
                if(countSum2<=0){
                    median=i;
                    break;
                }
            }
        }
        
        int mode = -1;
        int countMax = -1;
        for(int i=0;i<count.length;++i){
            if(count[i]<=countMax)continue;
            countMax=count[i];
            mode = i;
        }
        
        return new double[]{min,max,mean,median,mode};
    }
}
