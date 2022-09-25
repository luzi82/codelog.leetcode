from typing import List
import collections
import math

class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        mx = max(nums)
        ret = 0
        tmp = 0
        for n in nums:
            if n == mx:
               tmp += 1
               ret = max(ret,tmp)
            else:
               tmp = 0
        return ret
