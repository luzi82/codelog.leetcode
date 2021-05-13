import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("[10,20,5]","[70,50,30]",2,105d);
        test("[3,1,10,10,1]","[4,8,2,2,7]",3,30.66667);
        // WA
        test(
          "[37,32,14,14,23,31,82,96,81,96,22,17,68,3,88,59,54,23,22,77,61,16,46,22,94,50,29,46,7,33,22,99,31,99,75,67,95,54,31,48,44,96,99,20,51,54,18,85,25,84]",
          "[453,236,199,359,107,45,150,433,32,192,433,94,113,200,293,31,48,27,15,32,295,97,199,427,90,215,390,412,475,131,122,398,479,142,103,243,86,309,498,210,173,363,449,135,353,397,105,165,165,62]",
          20,
          4947.75000
        );
    }
    
    public static void test(String qualityStr,String wageStr,int k,double expected){
        System.out.println(String.format("qualityStr=%s, wageStr=%s, k=%d, expected=%f",qualityStr,wageStr,k,expected));
        int[] quality=toIntAryQ(toIntQAryQ(qualityStr.toCharArray(),0).second);
        int[] wage=toIntAryQ(toIntQAryQ(wageStr.toCharArray(),0).second);
        Solution solution = new Solution();
        double result = solution.mincostToHireWorkers(quality,wage,k);
        System.out.println(String.format("result=%f",result));
        aassert(eq(result,expected));
    }

    public static boolean eq(double a,double b){
      return Math.abs(a-b)<0.0001;
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
