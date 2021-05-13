import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(
          new String[][]{
            new String[]{"a","b"},
            new String[]{"b","c"}
          },
          new double[]{2.0,3.0},
          new String[][]{
            new String[]{"a","c"},
            new String[]{"b","a"},
            new String[]{"a","e"},
            new String[]{"a","a"},
            new String[]{"x","x"}
          },
          new double[]{6.00000,0.50000,-1.00000,1.00000,-1.00000}
        );
        test(
          new String[][]{
            new String[]{"a","b"},
            new String[]{"b","c"},
            new String[]{"bc","cd"}
          },
          new double[]{1.5,2.5,5.0},
          new String[][]{
            new String[]{"a","c"},
            new String[]{"c","b"},
            new String[]{"bc","cd"},
            new String[]{"cd","bc"}
          },
          new double[]{3.75000,0.40000,5.00000,0.20000}
        );
        test(
          new String[][]{
            new String[]{"a","b"}
          },
          new double[]{0.5},
          new String[][]{
            new String[]{"a","b"},
            new String[]{"b","a"},
            new String[]{"a","c"},
            new String[]{"x","y"}
          },
          new double[]{0.50000,2.00000,-1.00000,-1.00000}
        );
    }
    
    public static void test(String[][] equationss, double[] values,String[][] queriess,double[] expected){
        System.out.println(String.format("equations=%s, values=%s, queries=%s, expected=%s",join(equationss),join(values),join(queriess),join(expected)));
        List<List<String>> equations = toStrListList(equationss);
        List<List<String>> queries = toStrListList(queriess);
        Solution solution = new Solution();
        double[] result = solution.calcEquation(equations,values,queries);
        System.out.println(String.format("result=%s",join(result)));
        aassert(result.length == expected.length);
        for(int i=0;i<result.length;++i){
          aassert(eq(result[i],expected[i]));
        }
    }
    
    public static List<List<String>> toStrListList(String[][] strAryAry){
      Vector<List<String>> strListList = new Vector<>();
      for(int i=0;i<strAryAry.length;++i){
        Vector<String> strList = new Vector<>();
        for(int j=0;j<strAryAry[i].length;++j){
          strList.add(strAryAry[i][j]);
        }
        strListList.add(strList);
      }
      return strListList;
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
    
    public static String join(double[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(double v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            sb.append(Double.toString(v));
        }
        sb.append("]");
        return sb.toString();
    }

    public static String join(String[][] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(String[] v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            if(v==null){
                sb.append("null");
            }else{
                sb.append(join(v));
            }
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
    
    public static boolean eq(double a,double b){
      return Math.abs(a-b)<0.000001;
    } 
    
}
