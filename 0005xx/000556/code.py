from typing import List
import collections
import math

ORD_0 = ord('0')

class Solution:
    def nextGreaterElement(self, n: int) -> int:
        ret = self._nextGreaterElement(n)
        if ret > 2**31-1: return -1
        return ret

    def _nextGreaterElement(self, n: int) -> int:
        s = str(n)
        digi_count_list = [0 for _ in range(10)]
        last_d = None
        for i in reversed(range(len(s))):
            c = s[i]
            d = ord(c)-ORD_0
            digi_count_list[d] += 1
            if last_d is not None and d < last_d:
                for ii in range(d+1, 10):
                    if digi_count_list[ii] > 0:
                        new_d = ii
                        break
                digi_count_list[new_d] -= 1
                return int(s[:i]+str(new_d)+''.join(str(ii)*digi_count_list[ii]for ii in range(10)))
            last_d = d
        return -1


