class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.nums = nums
        coin_list_list = [ [None for _ in range(len(self.nums)+1)] for _ in range(len(self.nums)+1) ]
        
        for x in range(len(nums)+1):
            coin_list_list[x][x] = 0
        
        for llen in range(1,len(nums)+1):
            for x0 in range(len(nums)-llen+1):
                x1 = x0+llen
                
                result_max = 0
                
                for x in range(x0,x1):
                    result_x = self.v(x0-1)*self.v(x)*self.v(x1)
                    result_x += coin_list_list[x0][x]
                    result_x += coin_list_list[x+1][x1]
                    result_max = max(result_max,result_x)
                
                coin_list_list[x0][x1] = result_max
        
        return coin_list_list[0][len(nums)]

    def v(self, x):
        if x == -1:
            return 1
        if x == len(self.nums):
            return 1
        return self.nums[x]
