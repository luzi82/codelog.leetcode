import java.io.*;
import java.util.*;
import java.math.*;

class Test{

    public static void main(String[] argv){
        Solution solution = new Solution();
        List<String> ret;
        
        ret = solution.fullJustify(
            new String[]{"This", "is", "an", "example", "of", "text", "justification."},
            16
        );
        //println(ret);
        assert(Arrays.equals(ret.toArray(new String[0]),new String[]{
           "This    is    an",
           "example  of text",
           "justification.  "
        }));
        
        ret = solution.fullJustify(
            new String[]{"What","must","be","acknowledgment","shall","be"},
            16
        );
        assert(Arrays.equals(ret.toArray(new String[0]),new String[]{
            "What   must   be",
            "acknowledgment  ",
            "shall be        "
        }));

        ret = solution.fullJustify(
            new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"},
            20
        );
        assert(Arrays.equals(ret.toArray(new String[0]),new String[]{
            "Science  is  what we",
            "understand      well",
            "enough to explain to",
            "a  computer.  Art is",
            "everything  else  we",
            "do                  "
        }));
    }

    public static void println(List<String> strList){
        for(String str:strList){
            System.err.println(str);
        }
    }

}