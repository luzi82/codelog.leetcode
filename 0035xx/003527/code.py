from typing import List
import collections
import math

class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        d2 = dist2(p1,p2)
        d3 = dist2(p1,p3)
        d4 = dist2(p1,p4)

        if d2 == 0: return False
        if d3 == 0: return False
        if d4 == 0: return False

        (p5,p6,p7) = (p2,p3,p4) if (d2==d4) else \
                     (p3,p4,p2) if (d2==d3) else \
                     (p4,p2,p3) if (d3==d4) else \
                     (None,None,None)
        if p5 is None: return False

        d5 = dist2(p1,p5)
        d6 = dist2(p1,p6)
        d7 = dist2(p1,p7)

        if d5+d7 != d6: return False

        d56 = dist2(p5,p6)
        d67 = dist2(p6,p7)
        d57 = dist2(p5,p7)

        if d56 != d5: return False
        if d67 != d5: return False
        if d57 != d6: return False

        return True


def dist2(p1: List[int], p2: List[int]):
    d0 = p1[0]-p2[0]
    d1 = p1[1]-p2[1]
    return d0*d0 + d1*d1
