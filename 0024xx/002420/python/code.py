from typing import List
import collections
import math

class Solution:
    def goodIndices(self, nums: List[int], k: int) -> List[int]:
        nums_len = len(nums)
        incList = [0]*(nums_len+1)
        decList = [0]*(nums_len+1)
        
        incList[1] = 1
        decList[1] = 1
        for i in range(2,nums_len+1):
          if nums[i-2] <= nums[i-1]:
            incList[i] = incList[i-1] + 1
          else:
            incList[i] = 1

          if nums[i-2] >= nums[i-1]:
            decList[i] = decList[i-1] + 1
          else:
            decList[i] = 1

        # print(incList)
        # print(decList)

        retList = []
        for i in range(k,nums_len-k):
          if decList[i] < k: continue
          if incList[i+k+1] < k: continue
          retList.append(i)
        
        return retList

# [440043,276285,336957] 1
