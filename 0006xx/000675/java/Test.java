import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("[[1,2,3],[0,0,4],[7,6,5]]",6);
        test("[[1,2,3],[0,0,0],[7,6,5]]",-1);
        test("[[2,3,4],[0,0,5],[8,7,6]]",6);
        // WA
        test("[[54581641,64080174,24346381,69107959],[86374198,61363882,68783324,79706116],[668150,92178815,89819108,94701471],[83920491,22724204,46281641,47531096],[89078499,18904913,25462145,60813308]]",57);
    }
    
    public static void test(String forestStr,int expected){
        System.out.println(String.format("forest=%s, expected=%d",forestStr,expected));
        int[][] cellAryQAryQ = toIntAryQAryQ(forestStr);
        LinkedList<List<Integer>> forest = new LinkedList<>();
        for(int[] cellAryQ:cellAryQAryQ){
          LinkedList<Integer> vList = new LinkedList<>();
          for(int cell:cellAryQ){
            vList.add(cell);
          }
          forest.add(vList);
        }
        Solution solution = new Solution();
        int result = solution.cutOffTree(forest);
        System.out.println(String.format("result=%d",result));
        aassert(result == expected);
    }
    
    public static int[][] toIntAryQAryQ(String intAryQAryQStr){
      return toIntAryQAryQ(toIntQAryQAryQ(intAryQAryQStr.toCharArray(),0).second);
    }

    public static int[] toIntAryQ(String intAryQStr){
      return toIntAryQ(toIntQAryQ(intAryQStr.toCharArray(),0).second);
    }
    
    public static int[][] toIntAryQAryQ(Integer[][] intQAryQAryQ){
      if(intQAryQAryQ==null)return null;
      int[][] intAryQAry = new int[intQAryQAryQ.length][];
      for(int i=0;i<intQAryQAryQ.length;++i){
        intAryQAry[i] = toIntAryQ(intQAryQAryQ[i]);
      }
      return intAryQAry;
    }

    public static int[] toIntAryQ(Integer[] intQAryQ){
      if(intQAryQ==null)return null;
      int[] intAry = new int[intQAryQ.length];
      for(int i=0;i<intAry.length;++i){
        intAry[i] = intQAryQ[i];
      }
      return intAry;
    }
    
    public static Pair<Integer,Integer[][]> toIntQAryQAryQ(char[] cAry,int start){
      LinkedList<Integer[]> intQAryQList = new LinkedList<>();
      int i=start;
      if(cAry[i]=='n'){ // null
        return new Pair<Integer,Integer[][]>(i+4,null);
      }
      aassert(cAry[i]=='[');
      i+=1;
      if(cAry[i]==']'){i+=1;} // empty ary
      else{
        while(true){
          Pair<Integer,Integer[]> ret = toIntQAryQ(cAry,i);
          i = ret.first;
          intQAryQList.add(ret.second);
          if(cAry[i]==']'){i+=1;break;}
          aassert(cAry[i]==',');
          i+=1;
        }
      }
      return new Pair<Integer,Integer[][]>(i,intQAryQList.toArray(new Integer[0][0]));
    }

    public static Pair<Integer,Integer[]> toIntQAryQ(char[] cAry,int start){
      LinkedList<Integer> intQList = new LinkedList<Integer>();
      int i=start;
      if(cAry[i]=='n'){ // null
        return new Pair<Integer,Integer[]>(i+4,null);
      }
      aassert(cAry[i]=='[');
      i+=1;
      if(cAry[i]==']'){i+=1;} // empty ary
      else{
        while(true){
          Pair<Integer,Integer> ret = toIntQ(cAry,i);
          i = ret.first;
          intQList.add(ret.second);
          if(cAry[i]==']'){i+=1;break;}
          aassert(cAry[i]==',');
          i+=1;
        }
      }
      return new Pair<Integer,Integer[]>(i,intQList.toArray(new Integer[0]));
    }
    
    public static Pair<Integer,Integer> toIntQ(char[] cAry,int start){
      int i=start;
      if(cAry[i]=='n'){ // null
        return new Pair<Integer,Integer>(i+4,null);
      }
      int v=0;
      int m=1;
      if(cAry[i]=='-'){
        m=-1;
        i+=1;
      }
      while(true){
        if((i>=cAry.length)||(cAry[i]<'0')||(cAry[i]>'9')){break;}
        v*=10;
        v+=(cAry[i]-'0');
        i+=1;
      }
      return new Pair<Integer,Integer>(i,v*m);
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

    public static String join(boolean[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(boolean v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Boolean.toString(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(long[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(long v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Long.toString(v));
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
            if(v==null){
                sb.append("null");
            }else{
                sb.append(v.toString());
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static int[][] to2D(int[] vAry, int l){
      int[][] ret = new int[vAry.length/l][l];
      for(int i=0;i<vAry.length;++i){
        ret[i/l][i%l]=vAry[i];
      }
      return ret;
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
