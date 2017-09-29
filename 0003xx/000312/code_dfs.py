# failed by LTE

class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.nums = nums
        self.cache = None
        
        return self._maxCoins_dfs(0,len(nums))

    def _maxCoins_dfs(self, x0, x1):
        if self.cache is None:
            size = len(self.nums)+1
            self.cache = [ [None for _ in range(size)] for _ in range(size) ]
        if self.cache[x0][x1] is not None:
            return self.cache[x0][x1]
        self.cache[x0][x1] = self._maxCoins_dfs_cal(x0,x1)
        return self.cache[x0][x1]

    def _maxCoins_dfs_cal(self, x0, x1):
        if x0 == x1:
            return 0

        result = 0
        
        for x in range(x0, x1):
            result_x = self.v(x0-1)*self.v(x)*self.v(x1)
            result_x += self._maxCoins_dfs(x0,x)
            result_x += self._maxCoins_dfs(x+1,x1)
            result = max(result,result_x)
        
        return result

    def v(self, x):
        if x == -1:
            return 1
        if x == len(self.nums):
            return 1
        return self.nums[x]
