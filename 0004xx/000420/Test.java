import java.io.*;
import java.util.*;
import java.math.*;

class Test{

    public static void main(String[] argv){
        assert(Solution.h("*aa111")>0);
        assert(Solution.h("1111111111")<=3);
    
        Solution solution = new Solution();
        
        assert(solution.strongPasswordChecker("1Qwer")==1);
        assert(solution.strongPasswordChecker("1Qwert")==0);
        assert(solution.strongPasswordChecker("aaaaaa")==2);
        assert(solution.strongPasswordChecker("")==6);
        assert(solution.strongPasswordChecker("aaa111")==2);
        assert(solution.strongPasswordChecker("ABABABABABABABABABAB1")==2);
        solution.strongPasswordChecker("hoAISJDBVWD09232UHJEPODKNLADU1");
        assert(solution.strongPasswordChecker("1111111111")==3);
        assert(solution.strongPasswordChecker("..................!!!")==7);
        
        
    }

}