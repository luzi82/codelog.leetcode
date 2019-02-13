import java.util.regex.*;

class Test {
    public static void main(String[] argv) {
        assert( Pattern.matches("^[+]$","+"));
        assert(!Pattern.matches("^[+]$","-"));
        assert( Pattern.matches("^[0-9]$","1"));
        assert( Pattern.matches("^\\d$","1"));
        assert( Pattern.matches("^[\\d]$","1"));
        assert( Pattern.matches("^\\.$","."));
        assert(!Pattern.matches("^\\.$","x"));
        assert( Pattern.matches("^(aa)|(b)$","aa"));
        assert( Pattern.matches("^(aa)|(b)$","b"));
    
        Solution solution=new Solution();
        assert( solution.isNumber("0"));
        assert( solution.isNumber(" 0.1 "    ));
        assert(!solution.isNumber("abc"      ));
        assert(!solution.isNumber("1 a"      ));
        assert( solution.isNumber("2e10"     ));
        assert( solution.isNumber(" -90e3   "));
        assert(!solution.isNumber(" 1e"      ));
        assert(!solution.isNumber("e3"       ));
        assert( solution.isNumber(" 6e-1"    ));
        assert(!solution.isNumber(" 99e2.5 " ));
        assert( solution.isNumber("53.5e93"  ));
        assert(!solution.isNumber(" --6 "    ));
        assert(!solution.isNumber("-+3"      ));
        assert(!solution.isNumber("95a54e53" ));

        // think by me
        assert( solution.isNumber(".0" ));
        assert( solution.isNumber(".0e123" ));
        assert( solution.isNumber("+.0e123" ));
        assert( solution.isNumber("-.0e123" ));
        assert( solution.isNumber(".0e-123" ));
        assert( solution.isNumber(".0e+123" ));

        // leetcode case =_=
        assert( solution.isNumber("3." ));
    }
}
