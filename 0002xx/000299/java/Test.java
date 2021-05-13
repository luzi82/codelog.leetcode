import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("1807","7810","1A3B");
        test("1123","0111","1A1B");
        test("1","0","0A0B");
        test("1","1","1A0B");
    }
    
    public static void test(String secret, String guess,String expected){
        System.out.println(String.format("secret=%s, guess=%s, expected=%s",secret,guess,expected));
        Solution solution = new Solution();
        String result = solution.getHint(secret, guess);
        System.out.println(String.format("result=%s",result));
        aassert(result.equals(expected));
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
