from typing import List
import collections
import math

# stupid O(n^2), TLE

class Solution:
    def lastSubstring(self, s: str) -> str:
        max_start = 0
        for start in range(len(s)):
            if s[start:] > s[max_start:]:
                max_start = start
        return s[max_start:]
        