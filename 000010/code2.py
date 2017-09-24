# 82 ms
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
        
        bb = [[None for _ in range(len(pp)+1)] for _ in range(len(s)+1)] # [s][pp]
        
        return self.do_match(s,pp,bb,0,0)
    
    def do_match(self,s,pp,bb,si,pi):
        
        if (si==len(s))and(pi==len(pp)):
            return True
        
        if (pi>=len(pp)):
            return False
        
        if (si>len(s)):
            return False
        
        if bb[si][pi]!=None:
            return bb[si][pi]
        
        v = self.do_match_cal(s,pp,bb,si,pi)
        bb[si][pi] = v
        return v
        
    def do_match_cal(self,s,pp,bb,si,pi):

        pu = pp[pi]
        pc = pu['c']
        
        if pu['m']:
            sii = si
            while(True):
                bi = self.do_match(s,pp,bb,sii,pi+1)
                if bi:
                    return True
                if (sii >= len(s)):
                    break
                if (s[sii] != pc) and (pc!='.'):
                    break
                sii += 1
            return False
        else:
            if si >= len(s):
                return False
            if (s[si] != pc) and (pc!='.'):
                return False
            return self.do_match(s,pp,bb,si+1,pi+1)
