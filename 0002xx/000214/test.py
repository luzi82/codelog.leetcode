import code
import random
import string

def tt(s,v):
    print(s,v)
    xx = code.Solution()
    vv = xx.shortestPalindrome(s)
    print(vv)
    assert(vv == v)

tt("aacecaaa","aaacecaaa")
tt("abcd","dcbabcd")

for _ in range(100):
    
    s = [ random.choice(string.ascii_lowercase[:4]) for _ in range(10) ]
    s = ''.join(s)
    sv = ''.join(reversed(s))
    ss = s+sv[1:]
    
    for i in range(len(ss)):
        sss = ss[i:]
        xx = code.Solution()
        vv = xx.shortestPalindrome(sss)
        print(sss,vv)
        assert(vv == ''.join(reversed(vv)))
        assert(len(vv)<=len(ss))
        assert(len(vv)<=len(sss)*2-1)
