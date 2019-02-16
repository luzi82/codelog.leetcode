class Solution(object):
    
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        """
        self.ccc = 0
        len_s = len(s)
        cache = [[None for _ in range(len_s+1)] for _ in range(len_s+1)]

        cset = set(s)

        l_list_dict = {}
        for c in cset:
            l_list = [-1 for _ in range(len_s+1)]
            v = -1
            for i in reversed(range(len_s)):
                if s[i] == c:
                    v = i
                l_list[i] = v
            l_list_dict[c] = l_list
        self.l_list_dict = l_list_dict

        r_list_dict = {}
        for c in cset:
            r_list = [-1 for _ in range(len_s+1)]
            v = -1
            for i in range(1,len_s+1):
                if s[i-1] == c:
                    v = i-1
                r_list[i] = v
            r_list_dict[c] = r_list
        self.r_list_dict = r_list_dict
        
        ret = self.lps(s, cache, l_list_dict, r_list_dict, 0, len_s)
        return ret
        
    def lps(self, s, cache, l_list_dict, r_list_dict, start, end):
        self.ccc += 1
        if start == end:
            return 0
        if start == end - 1:
            return 1
        if cache[start][end] is not None:
            return cache[start][end]

        ret = 0
        for c in set(s[start:end]):
            #ss = s.find(c,start,end)
            #ee = s.rfind(c,start,end)+1
            ss = l_list_dict[c][start]
            ee = r_list_dict[c][end]+1
            if ss == ee-1:
                ret = max(ret,1)
            else:
                ret = max(ret,self.lps(s,cache,l_list_dict, r_list_dict,ss+1,ee-1)+2)

        cache[start][end] = ret

        return ret
