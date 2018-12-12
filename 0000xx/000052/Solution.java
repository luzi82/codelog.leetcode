class Solution {
    public int totalNQueens(int n) {
        
        boolean[] yDone = new boolean[n]; // y
        boolean[] xyDone = new boolean[2*n-1]; // x+y
        boolean[] yxDone = new boolean[2*n-1]; // y-x+n-1
        
        return dfs(0, n, yDone, xyDone, yxDone);
        
    }
    
    public int dfs(int x,int n, boolean[] yDone, boolean[] xyDone, boolean[] yxDone){
        if(x==n){return 1;}
    
        int ret = 0;
        for(int y=0;y<n;++y){
            if(yDone[y])continue;
            if(xyDone[x+y])continue;
            if(yxDone[y-x+n-1])continue;

            yDone[y] = true;
            xyDone[x+y] = true;
            yxDone[y-x+n-1] = true;
            
            ret += dfs(x+1, n, yDone, xyDone, yxDone);
            
            yDone[y] = false;
            xyDone[x+y] = false;
            yxDone[y-x+n-1] = false;
        }
        return ret;
    }
    
    public static void main(String[] argv){
        Solution s = new Solution();
        System.out.println(s.totalNQueens(4));
        System.out.println(s.totalNQueens(5));
        System.out.println(s.totalNQueens(8));
    }
}
