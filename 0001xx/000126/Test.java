import java.io.*;
import java.util.*;
import java.math.*;

class Test{

    public static void main(String[] argv){
        Solution solution = new Solution();

        List<List<String>> ans;
        ans = solution.findLadders(
            "hit","cog",
            Arrays.asList(new String[]{
                "hot","dot","dog","lot","log","cog"
            })
        );
        printAns(ans);
        assert(ans.size()==2);
        assert(ans.contains(Arrays.asList(new String[]{
            "hit","hot","dot","dog","cog"
        })));
        assert(ans.contains(Arrays.asList(new String[]{
            "hit","hot","lot","log","cog"
        })));
        
        ans = solution.findLadders(
            "hit","cog",
            Arrays.asList(new String[]{
                "hot","dot","dog","lot","log"
            })
        );
        assert(ans.size()==0);
    }
    
    public static void printAns(List<List<String>> sLL){
        System.err.println("len: "+sLL.size());
        for(List<String> sL:sLL){
            for(String s:sL){
                System.err.print(s+" ");
            }
            System.err.println();
        }
    }

}