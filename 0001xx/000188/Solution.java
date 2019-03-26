import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxProfit(int k, int[] prices) {
        k = Math.min(k,prices.length+1);
        int[] money = new int[k*2+1];
        int[] oldMoney = new int[k*2+1];
        for(int i=0;i<money.length;++i){
            money[i] = Integer.MIN_VALUE/2;
            oldMoney[i] = Integer.MIN_VALUE/2;
        }
        money[0] = 0;
        oldMoney[0] = 0;
        
        int[] tmpMoney = null;
        for(int t=0;t<prices.length;++t){
            tmpMoney = money;money = oldMoney;oldMoney = tmpMoney;
            for(int i=1;(i<money.length)&&(i<t+2);++i){
                int m = oldMoney[i-1];
                if((i&1)==1){
                    // buy
                    m -= prices[t];
                }else{
                    // sell
                    m += prices[t];
                }
                money[i] = Math.max(m,oldMoney[i]);
            }
        }
        
        int ret = money[0];
        for(int i=0;i<money.length;++i){
            int m=money[i];
            if(m>ret)ret=m;
        }
        
        return ret;
    }
}
