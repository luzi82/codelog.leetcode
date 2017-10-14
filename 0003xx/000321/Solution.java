import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // define:
        // u,v: number consumed in num1/num2
        // j: number put to result, 0<=j<=k
    
        int[] resultAry = new int[k]; // for return
        Arrays.fill(resultAry,Integer.MIN_VALUE);
        
        // search in bfs, j=depth
        // juvToUvUvMaxMap / uValueMax / vValueMax magic: if 9 found in array, output
        //   sometime max is not 9, so we do sth to fast search the max
        HashSet<IntTuple> uvSet=new HashSet<>();
        HashMap<IntTuple, IntTuple> juvToUvUvMaxMap=new HashMap<>(); // max( num[u:uMax) ) <= juvToUvUvMaxMap[0/1]
        uvSet.add(new IntTuple(new int[]{0,0})); // start point in j=0
        juvToUvUvMaxMap.put(new IntTuple(new int[]{0,0,0}),new IntTuple(new int[]{-1,-1,9,9}));
        for(int j=0;j<k;++j){
            int reserve = k-j-1;
            HashSet<IntTuple> nextUvSet=new HashSet<>();
            for(IntTuple uv:uvSet){
                // basic info
                int u=uv.ary[0];
                int v=uv.ary[1];
                IntTuple juvMax = juvToUvUvMaxMap.get(new IntTuple(new int[]{j,u,v}));
                int uValueMaxI = juvMax.ary[0];
                int vValueMaxI = juvMax.ary[1];
                int uValueMax = juvMax.ary[2];
                int vValueMax = juvMax.ary[3];
                
                // search range
                int uMax = nums1.length - Math.max(0,reserve-(nums2.length-v));
                int vMax = nums2.length - Math.max(0,reserve-(nums1.length-u));
                
                // search biggest num
                int nextU,nextUValue,nextV,nextVValue;
                
                if(u==uMax){
                    nextU = -1;
                    uValueMaxI = -1;
                    nextUValue = Integer.MIN_VALUE;
                    uValueMax = 9;
                }else if(nums1[uMax-1] > uValueMax){
                    nextU = uMax-1;
                    uValueMaxI = nextU;
                    nextUValue = nums1[nextU];
                    uValueMax = nextUValue;
                }else if((u<=uValueMaxI)&&(uValueMaxI<uMax)){
                    nextU = uValueMaxI;
                    uValueMaxI = -1;
                    nextUValue = nums1[nextU];
                    uValueMax = nextUValue;
                }else{
                    nextU = findMax(nums1,u,uMax,uValueMax);
                    uValueMaxI = nextU;
                    nextUValue = nums1[nextU];
                    uValueMax = nextUValue;
                }

                if(v==vMax){
                    nextV = -1;
                    vValueMaxI = -1;
                    nextVValue = Integer.MIN_VALUE;
                    vValueMax = 9;
                }else if(nums2[vMax-1] > vValueMax){
                    nextV = vMax-1;
                    vValueMaxI = nextV;
                    nextVValue = nums2[nextV];
                    vValueMax = nextVValue;
                }else if((v<=vValueMaxI)&&(vValueMaxI<vMax)){
                    nextV = vValueMaxI;
                    vValueMaxI = -1;
                    nextVValue = nums2[nextV];
                    vValueMax = nextVValue;
                }else{
                    nextV = findMax(nums2,v,vMax,vValueMax);
                    vValueMaxI = nextV;
                    nextVValue = nums2[nextV];
                    vValueMax = nextVValue;
                }

                int nextValue = Math.max(nextUValue,nextVValue);

                // ignore case if nextValue smaller than resultAry[j]
                if(nextValue<resultAry[j])continue;

                juvMax = new IntTuple(new int[]{uValueMaxI, vValueMaxI, uValueMax,vValueMax});

                // reset nextUvSet if higher resultAry[j] found
                if(nextValue>resultAry[j]){
                    resultAry[j]=nextValue;
                    nextUvSet.clear();
                }

                if(nextUValue>nextVValue){
                    nextUvSet.add      (new IntTuple(new int[]{    nextU+1,v}));
                    juvToUvUvMaxMap.put(new IntTuple(new int[]{j+1,nextU+1,v}),juvMax);
                }else if(nextUValue<nextVValue){
                    nextUvSet.add      (new IntTuple(new int[]{    u,nextV+1}));
                    juvToUvUvMaxMap.put(new IntTuple(new int[]{j+1,u,nextV+1}),juvMax);
                }else{
                    nextUvSet.add      (new IntTuple(new int[]{    nextU+1,v}));
                    juvToUvUvMaxMap.put(new IntTuple(new int[]{j+1,nextU+1,v}),juvMax);
                    nextUvSet.add      (new IntTuple(new int[]{    u,nextV+1}));
                    juvToUvUvMaxMap.put(new IntTuple(new int[]{j+1,u,nextV+1}),juvMax);
                }
            }
            //System.out.println(String.format("output %d",resultAry[j]));
            
            uvSet = nextUvSet;
        }
        
        return resultAry;
    }
    
    public static int findMax(int[] intAry,int start,int end,int max){
        //System.out.println(String.format("s=%d, e=%d",start,end));
        int maxV = Integer.MIN_VALUE;
        int maxI = -1;
        for(int i=start;i<end;++i){
            if(intAry[i]>maxV){
                maxI = i;
                maxV = intAry[i];
                if(maxV>=max){
                    return maxI;
                }
            }
        }
        return maxI;
    }

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
        public int hashCode(){
            int[] ary0 = Arrays.copyOf(ary,ary.length+1);
            ary0[ary.length] = ary.length;
            return Arrays.hashCode(ary0);
        }
        public boolean equals(Object obj){
            if(!(obj instanceof IntTuple))return false;
            IntTuple o = (IntTuple)obj;
            return compareTo(o)==0;
        }
    }
}
