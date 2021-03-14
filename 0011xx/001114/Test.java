import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv)throws Throwable{
        // given
        test(new int[]{1,2,3});
        test(new int[]{1,3,2});
    }
    
    public static void test(int[] inputAry)throws Throwable{
        System.out.println(String.format("inputAry=%s",join(inputAry)));
        boolean[] doneAry = new boolean[3];
        Foo solution = new Foo();
        S0 f0 = new S0(solution,doneAry);
        S1 f1 = new S1(solution,doneAry);
        S2 f2 = new S2(solution,doneAry);

        Thread[] threadAry = new Thread[3];
        for(int input:inputAry){
          int i = input-1;
          if(i==0){
            threadAry[i] = new Thread(f0);
          }else if(i==1){
            threadAry[i] = new Thread(f1);
          }else if(i==2){
            threadAry[i] = new Thread(f2);
          }
          threadAry[i].start();
        }

        for(Thread thread:threadAry){
          thread.join();
        }
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


    static class S0 implements Runnable{
      boolean[]doneAry;Foo foo;
      public S0(Foo foo,boolean[]doneAry){this.foo=foo;this.doneAry=doneAry;}
      public void run(){
        try{
          this.foo.first(new Runnable(){public void run(){
            S0.this.doneAry[0]=true;
          }});
        }catch(Throwable t){aassert(false);}
      }
    }

    static class S1 implements Runnable{
      boolean[]doneAry;Foo foo;
      public S1(Foo foo,boolean[]doneAry){this.foo=foo;this.doneAry=doneAry;}
      public void run(){
        try{
          this.foo.second(new Runnable(){public void run(){
            aassert(S1.this.doneAry[0]);
            S1.this.doneAry[1]=true;
          }});
        }catch(Throwable t){aassert(false);}
      }
    }

    static class S2 implements Runnable{
      boolean[]doneAry;Foo foo;
      public S2(Foo foo,boolean[]doneAry){this.foo=foo;this.doneAry=doneAry;}
      public void run(){
        try{
          this.foo.third(new Runnable(){public void run(){
            aassert(S2.this.doneAry[1]);
            S2.this.doneAry[2]=true;
          }});
        }catch(Throwable t){aassert(false);}
      }
    }

}
