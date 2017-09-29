import bisect

class Solution(object):
    def maxEnvelopes(self, envelopes):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        # sort envelopes by (x, -h)
        # after sorted, (right-h > left-h) iff fit
        # -h in sort key is used to avoid (1,4) fit (1,3)
        ssxh_list = [(xh[0],-xh[1],xh[0],xh[1]) for xh in envelopes]
        ssxh_list = sorted(ssxh_list)

        # min h of each layer
        # len(min_h_list) will become the answer
        min_h_list = []
        
        for _,_,_,h in ssxh_list:
            i = bisect.bisect_left(min_h_list, h)
            
            if i == len(min_h_list):
                min_h_list.append(h)
            else:
                min_h_list[i] = h

        return len(min_h_list)
