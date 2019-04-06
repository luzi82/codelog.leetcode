import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        Random rand = new Random(0);
        for(int i=0;i<10;++i){
            LinkedList<Integer> intList = new LinkedList<>();
            MyLinkedList myList = new MyLinkedList();
            for(int j=0;j<1000;++j){
                int act = rand.nextInt(5);
                if(act==0){
                    int len = intList.size();
                    int idx = rand.nextInt(len+10)-5;
                    System.err.println(String.format("GET %d",idx));
                    int expected = (idx>=len||idx<0)?-1:intList.get(idx);
                    int result = myList.get(idx);
                    aassert(expected==result);
                }else if(act==1){
                    int v = rand.nextInt();
                    System.err.println(String.format("ADDHEAD %d",v));
                    intList.addFirst(v);
                    myList.addAtHead(v);
                }else if(act==2){
                    int v = rand.nextInt();
                    System.err.println(String.format("ADDLAST %d",v));
                    intList.addLast(v);
                    myList.addAtTail(v);
                }else if(act==3){
                    int len = intList.size();
                    int idx = rand.nextInt(len+10)-5;
                    int v = rand.nextInt();
                    System.err.println(String.format("ADD %d %d",idx,v));
                    if(idx>=0&&idx<=len){
                        intList.add(idx,v);
                    }
                    myList.addAtIndex(idx,v);
                }else{
                    int len = intList.size();
                    int idx = rand.nextInt(len+10)-5;
                    System.err.println(String.format("REMOVE %d",idx));
                    if(idx>=0&&idx<len){
                        intList.remove(idx);
                    }
                    myList.deleteAtIndex(idx);
                }
                Iterator<Integer> itr = intList.iterator();
                MyLinkedList.Node node = myList.start;
                while(itr.hasNext()){
                    int v0 = itr.next();
                    int v1 = node.v;
                    //System.err.println(String.format("CHECK %d %d",v0,v1));
                    aassert(v0==v1);
                    node = node.next;
                }
                aassert(node==null);
            }
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
