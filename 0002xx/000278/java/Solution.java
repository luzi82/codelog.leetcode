import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(isBadVersion(1))return 1;
        long leftGood = 1;
        long rightBad = n;
        while(leftGood<rightBad-1){
            int mid = (int)((leftGood+rightBad)/2);
            if(isBadVersion(mid)){
                rightBad=mid;
            }else{
                leftGood=mid;
            }
        }
        return (int)rightBad;
    }
}
