import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test("[[7,null],[13,0],[11,4],[10,2],[1,0]]");
        test("[[1,1],[2,1]]");
        test("[[3,null],[3,0],[3,null]]");
        test("[]");
    }
    
    public static void test(String headStr){
        System.out.println(String.format("head=%s",headStr));
        Integer[][] headAryAry = toIntQAryQAryQ(headStr.toCharArray(),0).second;
        Node[] nodeAry = new Node[headAryAry.length];
        for(int i=0;i<nodeAry.length;++i){
          nodeAry[i] = new Node(headAryAry[i][0]);
        }
        for(int i=0;i<nodeAry.length-1;++i){
          nodeAry[i].next = nodeAry[i+1];
        }
        for(int i=0;i<nodeAry.length;++i){
          if(headAryAry[i][1]==null)continue;
          nodeAry[i].random = nodeAry[headAryAry[i][1]];
        }
        Node head = (nodeAry.length==0)?null:nodeAry[0];
        Solution solution = new Solution();
        Node result = solution.copyRandomList(head);
        if(head==null){
          aassert(result==null);
          return;
        }
        Node[] resultNodeAry = new Node[headAryAry.length];
        Node ptr = result;
        for(int i=0;i<resultNodeAry.length;++i){
          resultNodeAry[i] = ptr;
          //System.out.println(String.format("OKIFBAIU %s",(ptr.random!=null)));
          ptr = ptr.next;
        }
        aassert(resultNodeAry[resultNodeAry.length-1].next==null);
        Integer[][] resultIntAryAry = new Integer[headAryAry.length][2];
        for(int i=0;i<resultNodeAry.length;++i){
          resultIntAryAry[i][0] = resultNodeAry[i].val;
          if(resultNodeAry[i].random!=null){
            //System.out.println(String.format("QTWRBYSC %d",i));
            for(int j=0;j<resultNodeAry.length;++j){
              if(resultNodeAry[i].random!=resultNodeAry[j])continue;
              resultIntAryAry[i][1] = j;
              break;
            }
            aassert(resultIntAryAry[i][1]!=null);
          }
        }
        String resultStr = join2(resultIntAryAry);
        System.out.println(String.format("result=%s",resultStr));
        aassert(resultStr.equals(headStr));
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

    public static String join2(Object[] ary){
        StringBuffer sb=new StringBuffer();
        sb.append("[");
        boolean isFirst=true;
        for(Object v:ary){
            if(!isFirst){sb.append(",");}
            isFirst=false;
            if(v==null){
                sb.append("null");
            }else{
                sb.append(join((Object[])v));
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
