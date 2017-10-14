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
