from collections import deque
import copy

try:
    Interval
except NameError:
    from common import Interval

# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if len(intervals) <= 1:
            return intervals
        
        intervals = list(sorted(intervals,lambda a,b: -1 if a.start<b.start else 1 if a.start>b.start else -1 if a.end<b.end else 1 if a.end>b.end else 0))
        #for itv in intervals:
        #    print(itv.start,itv.end)
        
        ret = deque()
        v = None
        for itv in intervals:
            if v == None:
                v = Interval(itv.start,itv.end)
            else:
                if v.end >= itv.start:
                    v.end = max(v.end,itv.end)
                else:
                    ret.append(v)
                    v = Interval(itv.start,itv.end)

        if v is not None:
            ret.append(v)
            v = None
        
        return list(ret)
