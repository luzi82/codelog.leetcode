from typing import List
import collections
import math

class Solution(object):
    def reverseWords(self, input):
        x = input
        x = x.split(' ')
        x = map(lambda i:list(i),x)
        x = list(x)
        [i.reverse() for i in x]
        x = map(lambda i:''.join(i),x)
        x = ' '.join(x)
        return x
