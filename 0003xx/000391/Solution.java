import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    /*
     * int array class for sorted key and simple struct
     */
    public static class IntTuple implements Comparable<IntTuple>{
        public int[] ary=null;
        public IntTuple(int[] ary){
            this.ary = Arrays.copyOf(ary,ary.length);
        }
        public int compareTo(IntTuple o){
            if((ary==null) && (o.ary==null))return 0;
            if(ary==null)return -1;
            if(o.ary==null)return 1;
            if(ary.length<o.ary.length)return -1;
            if(ary.length>o.ary.length)return 1;
            for(int i=0;i<ary.length;++i){
                int a=ary[i];
                int b=o.ary[i];
                if(a<b)return -1;
                if(a>b)return 1;
            }
            return 0;
        }
    }

    public boolean isRectangleCover(int[][] rectangles) {
        // edge cases
        if(rectangles.length==1){return true;}
        
        // get min/max of xy
        int min_x=Integer.MAX_VALUE;
        int min_y=Integer.MAX_VALUE;
        int max_x=Integer.MIN_VALUE;
        int max_y=Integer.MIN_VALUE;
        for(int[] rect:rectangles){
            min_x = Math.min(min_x,rect[0]);
            min_y = Math.min(min_y,rect[1]);
            max_x = Math.max(max_x,rect[2]);
            max_y = Math.max(max_y,rect[3]);
        }
        
        // get total size of all rect
        int total_size = 0;
        for(int[] rect:rectangles){
            total_size += (rect[2]-rect[0])*(rect[3]-rect[1]);
        }
        
        // check size is match
        if(total_size != ((max_x-min_x)*(max_y-min_y))){
            return false;
        }
        
        // convert input into tuple array
        // s/t = min/max x, u/v = min/max y
        IntTuple[] stuvTupleAry = new IntTuple[rectangles.length];
        for(int i=0;i<rectangles.length;++i){
            int[] rect = rectangles[i];
            stuvTupleAry[i] = new IntTuple(new int[]{rect[0],rect[2],rect[1],rect[3]});
        }
        
        // sort the array
        Arrays.sort(stuvTupleAry);
        
        // find if any repeat tuple exist
        for(int i=0;i<rectangles.length-1;++i){
            int j=i+1;
            if(stuvTupleAry[i].compareTo(stuvTupleAry[j])==0){
                return false;
            }
        }
        
        // scan all rect tuple in order of s
        // do overlap check in each x
        TreeSet<IntTuple> uvstSet=new TreeSet<>(); // store active block in stuv order, for overlap checking
        TreeSet<IntTuple> tsuvSet=new TreeSet<>(); // store active block in tsuv order, for x order pop
        
        for(IntTuple stuv:stuvTupleAry){
            // remove all rect which t <= s
            int s = stuv.ary[0];
            while(true){
                if(tsuvSet.isEmpty())break;
                IntTuple tsuvSetFirst = tsuvSet.first();
                if(tsuvSetFirst.ary[0]>s)break;
                tsuvSet.remove(tsuvSetFirst);
                uvstSet.remove(stuvToUvst(tsuvToStuv(tsuvSetFirst)));
            }
            
            // check overlap
            int u = stuv.ary[2];
            int v = stuv.ary[3];
            IntTuple uvst = stuvToUvst(stuv);
            if(!uvstSet.isEmpty()){
                IntTuple uvstClose = uvstSet.floor(uvst);
                if((uvstClose != null) && (uvstClose.ary[1] > u))return false;
                uvstClose = uvstSet.ceiling(uvst);
                if((uvstClose != null) && (uvstClose.ary[0] < v))return false;
            }
            
            // push to check set
            uvstSet.add(uvst);
            tsuvSet.add(stuvToTsuv(stuv));
        }
        
        return true;
    }
    
    public static IntTuple stuvToTsuv(IntTuple stuv){
        return new IntTuple(new int[]{stuv.ary[1],stuv.ary[0],stuv.ary[2],stuv.ary[3]});
    }

    public static IntTuple tsuvToStuv(IntTuple tsuv){
        return new IntTuple(new int[]{tsuv.ary[1],tsuv.ary[0],tsuv.ary[2],tsuv.ary[3]});
    }

    public static IntTuple stuvToUvst(IntTuple stuv){
        return new IntTuple(new int[]{stuv.ary[2],stuv.ary[3],stuv.ary[0],stuv.ary[1]});
    }
    
    public static IntTuple uvstToStuv(IntTuple uvst){
        return new IntTuple(new int[]{uvst.ary[2],uvst.ary[3],uvst.ary[0],uvst.ary[1]});
    }
    
    public static void main(String[] argv){
        test("1,1,3,3 3,1,4,2 3,2,4,4 1,3,2,4 2,3,3,4" ,true);
        test("1,1,2,3 1,3,2,4 3,1,4,2 3,2,4,4" ,false);
        test("1,1,3,3 3,1,4,2 1,3,2,4 3,2,4,4" ,false);
        test("1,1,3,3 3,1,4,2 1,3,2,4 2,2,4,4" ,false);
        test("0,0,1,1 0,1,3,2 1,0,2,2" ,false);
    }
    
    public static void test(String _rectangles,boolean expected){
        System.out.println(String.format("_rectangles=%s, expected=%s",_rectangles,expected));
        String[] _rectanglesAry = _rectangles.split(Pattern.quote(" "));
        int[][] rectangles = new int[_rectanglesAry.length][];
        for(int i=0;i<rectangles.length;++i){
            String[] cAry = _rectanglesAry[i].split(Pattern.quote(","));
            rectangles[i] = new int[cAry.length];
            for(int j=0;j<cAry.length;++j){
                rectangles[i][j] = Integer.parseInt(cAry[j]);
            }
        }
        Solution solution = new Solution();
        boolean result = solution.isRectangleCover(rectangles);
        System.out.println(String.format("result=%s",result));
        aassert(result == expected);
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
