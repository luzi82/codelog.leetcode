# Time limit exceedeed

from typing import List
import collections
import math

class Solution:
    def minInteger(self, num: str, k: int) -> str:
        ret = ''
        while True:
            #print(f'ret={ret} num={num} k={k}')
            if len(num) <= 0: break
            if k <= 0: break
            num_lhs = num[:k+1]
            #print(f'num_lhs={num_lhs}')
            t = zip(num_lhs, range(len(num_lhs))) # [('3',0),('2',1),('1',2)]
            t = list(t)
            t = sorted(t)
            t = t[0]
            c, idx = t
            ret = ret + c
            k -= idx
            num = num[:idx] + num[idx+1:]
        ret = ret + num
        return ret
