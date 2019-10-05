from typing import List

class Solution:
    def kConcatenationMaxSum(self, arr: List[int], k: int) -> int:
        # cal mid_max
        mid_max = 0
        mid = 0
        for v in arr:
            mid += v
            mid = max(0,mid)
            mid_max = max(mid_max, mid)
        
        # cal ltr_max
        ltr_max = 0
        ltr = 0
        for v in arr:
            ltr += v
            ltr_max = max(ltr_max, ltr)
        
        # cal rtl_max
        rtl_max = 0
        rtl = 0
        for v in reversed(arr):
            rtl += v
            rtl_max = max(rtl_max, rtl)
        
        # arr_sum
        arr_sum = sum(arr)
        
        ret = 0
        
        ret = max(ret,mid)
        
        if k >= 2:
            ret = max(ret, ltr_max+rtl_max)
        
        if k > 2:
            ret = max(ret, ltr_max+rtl_max+((k-2)*arr_sum))
        
        return ret
