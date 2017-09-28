import code
import random

from common import Interval

def tt(n,t):
    print(n,t)
    nn = [Interval(ni[0],ni[1]) for ni in n]
    xx = code.Solution()
    vv = xx.merge(nn)
    vv = [[vvi.start,vvi.end] for vvi in vv]
    print(vv)
    assert(vv==t)

    
tt([[1,3],[2,6],[8,10],[15,18]],[[1,6],[8,10],[15,18]])
tt([],[])
tt([[1,2]],[[1,2]])

tt([[1,2],[3,4]],[[1,2],[3,4]])

for _ in range(100):
    llen = random.randint(2,10)
    
    itv_list = []
    for _ in range(llen):
        a = random.randint(0,99)
        b = random.randint(0,99)
        i = min(a,b)
        j = max(a,b)
        itv_list.append([i,j])

    b_list = [False]*200
    
    for itv in itv_list:
        for i in range(itv[0]*2,itv[1]*2+1):
            b_list[i]=True
    
    v_list = []
    v = None
    for i in range(200):
        if v is None:
            if b_list[i]:
                v = [i/2,i/2]
        else:
            if b_list[i]:
                v[1] = i/2
            else:
                v_list.append(v)
                v = None

    if v is not None:
        v_list.append(v)
        v = None

    tt(itv_list,v_list)
