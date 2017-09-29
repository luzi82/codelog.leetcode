class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if len(matrix) == 0:
            return 0
        if len(matrix[0]) == 0:
            return 0
        
        self.matrix = matrix
        self.xlen = len(matrix)
        self.ylen = len(matrix[0])
        
        # store the longest tail after [x][y]
        self.cache = [[None for _ in range(self.ylen)] for _ in range(self.xlen)]
        
        result = 0
        
        for x in range(self.xlen):
            for y in range(self.ylen):
                v = self.mx(x,y)
                
                # filter min point which no adj point smaller than it
                nv = self.mx(x,y-1)
                if nv is not None and nv < v: continue
                sv = self.mx(x,y+1)
                if sv is not None and sv < v: continue
                wv = self.mx(x-1,y)
                if wv is not None and wv < v: continue
                ev = self.mx(x+1,y)
                if ev is not None and ev < v: continue
                
                path_len = self.longestIncreasingPath_dfs(x,y)
                result = max(path_len,result)
        
        return result
        

    def longestIncreasingPath_dfs(self,x,y):
        if self.cache[x][y] is None:
            self.cache[x][y] = self.longestIncreasingPath_dfs_cal(x,y)
        return self.cache[x][y]
    
    def longestIncreasingPath_dfs_cal(self,x,y):
        result = 0
        v = self.mx(x,y)

        nv = self.mx(x,y-1)
        if nv is not None and nv > v:
            result=max(result,self.longestIncreasingPath_dfs(x,y-1))
        sv = self.mx(x,y+1)
        if sv is not None and sv > v:
            result=max(result,self.longestIncreasingPath_dfs(x,y+1))
        wv = self.mx(x-1,y)
        if wv is not None and wv > v:
            result=max(result,self.longestIncreasingPath_dfs(x-1,y))
        ev = self.mx(x+1,y)
        if ev is not None and ev > v:
            result=max(result,self.longestIncreasingPath_dfs(x+1,y))
        
        result += 1
            
        return result
    
    def mx(self,x,y):
        if x<0:
            return None
        if y<0:
            return None
        if x>=self.xlen:
            return None
        if y>=self.ylen:
            return None
        return self.matrix[x][y]
        