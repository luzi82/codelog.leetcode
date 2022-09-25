from typing import List
import collections
import math

class Solution:
    def sortPeople(self, names: List[str], heights: List[int]) -> List[str]:
        heights = map(lambda i:-i,heights)
        tmpList = zip(heights, names)
        tmpList = sorted(tmpList)
        tmpList = map(lambda i:i[1],tmpList)
        return tmpList
