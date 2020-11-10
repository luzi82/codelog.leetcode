from typing import List
import collections
import math

class Solution:
    def flipAndInvertImage(self, A: List[List[int]]) -> List[List[int]]:
        ill = A
        ill = [list(reversed(il)) for il in ill]
        ill = [list(map(lambda i:1-i, il)) for il in ill]
        return ill
