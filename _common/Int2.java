    static class Int2 implements Comparable<Int2>{
      int a;int b;
      public Int2(int a,int b){this.a=a;this.b=b;}
      public int compareTo(Int2 other){
        int diff;
        diff=this.a-other.a;if(diff!=0)return diff;
        diff=this.b-other.b;if(diff!=0)return diff;
        return 0;
      }
      @Override
      public boolean equals(Object other){
        return this.compareTo((Int2)other)==0;
      }
      @Override
      public int hashCode(){
        return Objects.hash(this.a,this.b);
      }
      public String toString(){
        return String.format("a=%d, b=%d",this.a,this.b);
      }
    }
