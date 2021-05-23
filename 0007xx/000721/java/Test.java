import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
      // given
      test(
        new String[][]{
          new String[]{"John","johnsmith@mail.com","john_newyork@mail.com"},
          new String[]{"John","johnsmith@mail.com","john00@mail.com"},
          new String[]{"Mary","mary@mail.com"},
          new String[]{"John","johnnybravo@mail.com"}
        },
        new String[][]{
          new String[]{"John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"},
          new String[]{"Mary","mary@mail.com"},
          new String[]{"John","johnnybravo@mail.com"}
        }
      );
      test(
        new String[][]{
          new String[]{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"},
          new String[]{"Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"},
          new String[]{"Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"},
          new String[]{"Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"},
          new String[]{"Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"}
        },
        new String[][]{
          new String[]{"Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"},
          new String[]{"Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"},
          new String[]{"Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"},
          new String[]{"Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"},
          new String[]{"Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"}
        }
      );
    }
    
    public static void test(String[][] accountsAryAry,String[][] expectedAryAry){
        System.out.println(String.format("accounts=%s, expected=%s",join2(accountsAryAry),join2(expectedAryAry)));
        LinkedList<List<String>> accounts = new LinkedList<>();
        for(String[] accountsAry : accountsAryAry){
          accounts.add(Arrays.asList(accountsAry));
        }
        Solution solution = new Solution();
        List<List<String>> resultListList = solution.accountsMerge(accounts);
        System.out.println(String.format("result=%s",join2(resultListList)));
        String[] expectedStrAry = new String[expectedAryAry.length];
        for(int i=0;i<expectedAryAry.length;++i){
          expectedStrAry[i] = join(expectedAryAry[i]);
        }
        Arrays.sort(expectedStrAry);
        String expectedStr = join(expectedStrAry);
        List[] resultListAry = resultListList.toArray(new List[0]);
        String[] resultStrAry = new String[resultListList.size()];
        for(int i=0;i<resultStrAry.length;++i){
          resultStrAry[i] = join(resultListAry[i]);
        }
        Arrays.sort(resultStrAry);
        String resultStr = join(resultStrAry);
        aassert(resultStr.equals(expectedStr));
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

    public static String join(List ary){
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

    public static String join2(List ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(Object vv:ary){
            List v = (List) vv;
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

    public static String join2(Object[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(Object vv:ary){
            Object[] v = (Object[]) vv;
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
