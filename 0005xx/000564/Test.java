import java.io.*;
import java.util.*;
import java.math.*;

class Test{

    public static void main(String[] argv){
        Solution solution = new Solution();

        assert(solution.nearestPalindromic("123").equals("121"));
        assert(solution.nearestPalindromic("0").equals("1"));
        assert(solution.nearestPalindromic("1").equals("0"));
        assert(solution.nearestPalindromic("9").equals("8"));
        assert(solution.nearestPalindromic("10").equals("9"));
        assert(solution.nearestPalindromic("11").equals("9"));
        assert(solution.nearestPalindromic("99").equals("101"));
        assert(solution.nearestPalindromic("199").equals("202"));
        assert(solution.nearestPalindromic("202").equals("212"));
        assert(solution.nearestPalindromic("191").equals("181"));
        assert(solution.nearestPalindromic("1991").equals("2002"));
    }
    
}
