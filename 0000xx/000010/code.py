# 85ms
from collections import deque

class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        pp=deque()
        
        for i in range(len(p)):
            c = p[i]
            if c == '*':
                continue
            multi = False
            if i+1 < len(p):
                if p[i+1] == '*':
                    multi = True
            
            pu = {
                'c':c,
                'm':multi
            }
            pp.append(pu)
        
        pp = list(pp)
        
        bb = [[False for _ in range(len(pp)+1)] for _ in range(len(s)+1)] # [s][pp]
        bfs = deque()
        
        bfs.append((0,0))
        while(len(bfs)!=0):
            bfsu = bfs.popleft()
            si = bfsu[0]
            pi = bfsu[1]
            
            if (si == len(s)) and (pi == len(pp)):
                return True
            if (pi == len(pp)):
                continue
            if (si > len(s)):
                continue
            if bb[si][pi] == True:
                continue

            bb[si][pi] = True

            pu = pp[pi]
            pc = pu['c']
            pm = pu['m']
            
            if pm:
                sii = si
                while(True):
                    bfs.append((sii,pi+1))
                    if sii >= len(s):
                        break
                    if not self.match_c(s[sii], pc):
                        break
                    sii += 1
            else:
                if si >= len(s):
                    continue
                if self.match_c(s[si],pc):
                    bfs.append((si+1,pi+1))
        
        return False

    def match_c(self,sc,pc):
        if pc == '.':
            return True
        return sc == pc
