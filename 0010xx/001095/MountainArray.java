class MountainArray {
    private int[] v;
    private int getCount;
    public MountainArray(int[] v){
        this.v=v;
        this.getCount=0;
    }
    public int get(int index) {
        ++getCount;
        return v[index];
    }
    public int length() {
        return v.length;
    }
    public int getGetCount(){
        return getCount;
    }
}
