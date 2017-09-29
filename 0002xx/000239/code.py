from collections import deque

class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        result = []
        vx_window = deque()
        
        for x in range(len(nums)):
            v = nums[x]
            x2 = x+k

            # pop all too-left value
            while (len(vx_window)>0) and (vx_window[0][1]<=x):
                vx_window.popleft()
            
            # pop all low value
            while (len(vx_window)>0) and (vx_window[-1][0]<v):
                vx_window.pop()

            vx_window.append((v,x2))
            
            if x+1 >= k:
                result.append(vx_window[0][0])
                
        return result
