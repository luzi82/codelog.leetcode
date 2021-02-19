import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // given
        test(
          new int[]{7,4,5,3,8},
          new int[]{
            0,2,2,
            4,2,4,
            2,13,1000000000
          },
          new boolean[]{true,false,true}
        );
        test(
          new int[]{5,2,6,4,1},
          new int[]{
            3,1,2,
            4,10,3,
            3,10,100,
            4,100,30,
            1,3,1
          },
          new boolean[]{false,true,true,false,false}
        );
        
        // WA
        test(
          new int[]{
            5215,14414,67303,93431,44959,
            34974,22935,64205,28863,3436,
            45640,34940,38519,5705,14594,
            30510,4418,87954,8423,65872,
            79062,83736,47851,64523,15639,
            19173,88996,97578,1106,17767,
            63298,8620,67281,76666,50386,
            97303,26476,95239,21967,31606,
            3943,33752,29634,35981,42216,
            88584,2774,3839,81067,59193,

            225,8289,9295,9268,4762,
            2276,7641,3542,3415,1372,
            5538,878,5051,7631,1394,
            5372,2384,2050,6766,3616,
            7181,7605,3718,8498,7065,
            1369,1967,2781,7598,6562,
            7150,8132,1276,6656,1868,
            8584,9442,8762,6210,6963,
            4068,1605,2780,556,6825,
            4961,4041,4923,8660,4114
          },
          new int[]{
            46,4191056,444472063,
            75,865431,146060662,
            91,244597,840227137,
            89,2601754,901415801,
            69,1777314,444098682,
            78,2957259,231019870,
            19,4350225,516815116,
            42,4081198,594990005,
            59,3176552,508520222,
            77,4577766,38900694,
            92,320256,1362,
            44,3992014,7209,
            55,1950613,1370,
            97,734069,3066,
            39,1188632,661,
            58,4526426,6202,
            51,3083812,1767,
            46,2563654,9680,
            21,4012578,7014,
            66,2185952,7039,
            67,3712445,1239,
            0,1840130,185,
            35,605159,7105,
            94,2269908,416,
            68,4117247,2076,
            0,4540381,2412,
            20,579583,8917,
            62,4407388,7127,
            17,4468545,6287,
            50,3462654,1410,
            7,1883037,77,
            4,4089924,5849,
            5,4340465,3843,
            68,596099,5796,
            29,542371,5952,
            91,441898,2227,
            35,912775,6110,
            12,267236,3248,
            27,990261,771,
            76,320119,5220,
            23,738123,2504,
            66,439801,4436,
            18,372357,1654,
            51,846227,5325,
            80,502088,3751,
            49,117408,102,
            75,837527,8747,
            46,984134,7924,
            42,463312,7558,
            50,214995,1043,
            94,981465,6758,
            79,892988,1063,
            17,985872,2314,
            71,870151,2004,
            63,793308,7608,
            49,873121,2846,
            32,453564,3739,
            42,890492,6026,
            19,278107,2649,
            64,792101,2208,
            98,577463,526,
            41,572006,748,
            99,478120,895,
            52,224338,423,
            83,532978,600,
            67,92281,486,
            28,829955,925,
            22,171381,749,
            82,986821,603,
            57,294692,194,
            9,730892,973,
            69,241093,931,
            70,646855,27,
            45,233480,669,
            60,369922,965,
            27,935011,659,
            96,667580,837,
            7,919344,188,
            99,584762,131,
            5,93173,898,
            16,736395,184,
            57,893061,196,
            28,352640,924,
            87,980414,80,
            88,432895,129,
            23,461032,85,
            73,645991,268,
            5,241036,458,
            9,422324,785,
            28,124913,224,
            51,815633,765,
            59,894120,559,
            70,459876,192,
            80,423125,584,
            85,824496,142,
            18,578975,104,
            56,477816,303,
            6,702127,400,
            43,35371,850,
            3,226423,10
          },
          new boolean[]{
            false,true,true,false,true,
            false,false,false,false,false,
            true,false,true,true,true,
            false,false,false,false,true,
            false,false,true,true,false,
            false,true,false,false,false,
            false,false,false,true,true,
            true,true,true,true,true,
            true,true,true,true,true,
            true,true,true,true,true,
            true,true,false,true,true,
            true,true,true,true,true,
            true,true,true,true,true,
            true,true,true,true,true,
            false,true,true,true,true,
            true,true,false,true,true,
            false,true,true,true,true,
            true,true,true,false,true,
            true,true,true,true,true,
            true,true,false,true,false
          }
        );
    }
    
    public static void test(int[] candiesCount, int[] qqueries, boolean[] expected){
        System.out.println(String.format("candiesCount=%s, qqueries=%s, expected=%s",join(candiesCount),join(qqueries),join(expected)));
        int[][] queries = to2D(qqueries,3);
        Solution solution = new Solution();
        boolean[] result = solution.canEat(candiesCount, queries);
        System.out.println(String.format("result=%s",join(result)));
        aassert(Arrays.equals(result, expected));
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
