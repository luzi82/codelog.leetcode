import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] v=new int[]{a,b,c};
        Arrays.sort(v);
        
        if((v[0]+1 == v[1])&&(v[1]+1 == v[2]))return new int[]{0,0};
        
        int min = 0;
        if(v[0]+1 == v[1]){min=1;}
        else if(v[1]+1 == v[2]){min=1;}
        else if(v[0]+2 == v[1]){min=1;}
        else if(v[1]+2 == v[2]){min=1;}
        else{min=2;}
        
        int max = 0;
        max = v[2]-v[0]-2;
        
        return new int[]{min,max};
    }
}
