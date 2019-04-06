import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        aassert(Arrays.hashCode(new int[]{1,2,3})==Arrays.hashCode(new int[]{1,2,3}));
        Solution.I4 i40 = new Solution.I4();Solution.I4 i41 = new Solution.I4();
        aassert(i40.hashCode()==i41.hashCode());
        aassert(i40.equals(i41));
        HashSet<Solution.I4> i4Set=new HashSet<>();
        i4Set.add(i40);i4Set.add(i41);
        //System.err.println(""+i4Set.size());
        aassert(i4Set.size()==1);
        
        test(new int[]{1, 0, -1, 0, -2, 2},0,new int[][]{
            {-1,0,0,1},{-2,-1,1,2},{-2,0,0,2}
        });
    }
    
    public static void test(int[] nums,int target,int[][] expected){
        sortAA(expected);
        System.out.println(String.format("nums=%s, target=%d, expected=%s",join(nums),target,join(expected)));
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(nums,target);
        int[][] resultA = toAryAry(result);
        sortAA(resultA);
        System.out.println(String.format("result=%s",join(resultA)));
        aassert(join(resultA).equals(join(expected)));
    }
    
    public static void sortAA(int[][] iAA){
        for(int[] iA:iAA){
            Arrays.sort(iA);
        }
        Arrays.sort(iAA,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a==b)return 0;
                if(a==null)return -1;
                if(b==null)return 1;
                if(a.length<b.length)return -1;
                if(a.length>b.length)return 1;
                for(int i=0;i<a.length;++i){
                    int aa=a[i];int bb=b[i];
                    if(aa<bb)return -1;
                    if(aa>bb)return 1;
                }
                return 0;
            }
        });
    }
    
    public static int[][] toAryAry(List<List<Integer>> iLL){
        int[][] ret = new int[iLL.size()][];
        Iterator<List<Integer>> iLItr = iLL.iterator();
        for(int i=0;i<iLL.size();++i){
            List<Integer> iL = iLItr.next();
            ret[i] = toAry(iL);
        }
        return ret;
    }
    
    public static int[] toAry(List<Integer> iL){
        int[] ret = new int[iL.size()];
        Iterator<Integer> iItr = iL.iterator();
        for(int i=0;i<iL.size();++i){
            ret[i] = iItr.next();
        }
        return ret;
    }
    
    public static String join(int[][] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int[] v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(join(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(int[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(int v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Integer.toString(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(Object[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(Object v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(v.toString());
        }
        sb.append("]");
        return sb.toString();
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
