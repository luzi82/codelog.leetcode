class Solution(object):
    def findMedianSortedArrays(self, ll0, ll1):
        """
        :type l0: List[int]
        :type l1: List[int]
        :rtype: float
        """
        if len(ll0)<len(ll1):
            l0 = ll0
            l1 = ll1
        else:
            l0 = ll1
            l1 = ll0
        
        c01 = int((len(l0)+len(l1))/2)
        c0_min = 0
        c0_max = len(l0)+1

        while(True):
            c0 = int((c0_min+c0_max)/2)
            c1 = c01 - c0
            #print(c01,c0,c1)
            
            if c0-1 < 0:
                left_max = l1[c1-1]
            elif c1-1 < 0:
                left_max = l0[c0-1]
            else:
                left_max = max(l0[c0-1],l1[c1-1])

            if c0 >= len(l0):
                right_min = l1[c1]
            elif c1 >= len(l1):
                right_min = l0[c0]
            else:
                right_min = min(l0[c0],l1[c1])

            if left_max <= right_min:
                break
            if (c0-1>=0) and (l0[c0-1]>l1[c1]):
                c0_max = c0
            else:
                c0_min = c0

        if((len(l0)+len(l1))%2)==0:
            return (left_max+right_min)/2
        else:
            return right_min
