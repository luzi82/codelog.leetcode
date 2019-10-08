from typing import List
import collections
import math

# try to make thing quicker, still stupid O(n^2) but accepted

class Solution:
    def lastSubstring(self, s: str) -> str:
        start_list = []
        start_char = 'a'
        
        for start in range(len(s)):
            if s[start] > start_char:
                start_char = s[start]
                start_list = [start]
            elif s[start] == start_char:
                start_list.append(start)
        
        max_start = 0
        for start in start_list:
            if s[start:] > s[max_start:]:
                max_start = start
        return s[max_start:]
        