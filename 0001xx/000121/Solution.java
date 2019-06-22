import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=0)return 0;
        int min = prices[0];
        int ret = 0;
        for(int price:prices){
            min = Math.min(min,price);
            ret = Math.max(ret,price-min);
        }
        return ret;
    }
}
