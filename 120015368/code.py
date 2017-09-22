class Solution(object):
    
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        """
        self.ccc = 0
        len_s = len(s)
        cache = [[None for _ in range(len_s+1)] for _ in range(len_s+1)]
        
        ret = self.lps(s, cache, 0, len_s)
        return ret
        
    def lps(self, s, cache, start, end):
        self.ccc += 1
        if start >= end:
            return 0
        if start == end - 1:
            return 1
        if cache[start][end] is not None:
            return cache[start][end]

        ret = 0
        for c in set(s[start:end]):
            ss = s.find(c,start,end)
            ee = s.rfind(c,start,end)+1
            if ss == ee-1:
                ret = max(ret,1)
            else:
                ret = max(ret,self.lps(s,cache,ss+1,ee-1)+2)

        cache[start][end] = ret

        return ret
