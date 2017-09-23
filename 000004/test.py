import code
import random

def tt(l0,l1):
    print(l0,l1)
    xx = code.Solution()
    vv = xx.findMedianSortedArrays(l0,l1)
    print(vv)
    l2 = l0+l1
    l2 = sorted(l2)
    if len(l2)%2==1:
        v2 = l2[int(len(l2)/2)]
    else:
        v2 = (l2[int(len(l2)/2)]+l2[int(len(l2)/2)-1])/2
    assert(vv==v2)

    
tt([1,3],[2])
tt([1,2],[3,4])
tt([3,4],[1,2])

for _ in range(100):
    len0 = random.randint(0,100)
    len1 = random.randint(0,100)
    if len0 == 0:
        len1 = max(1,len1)
    
    l0 = [random.randint(0,100) for _ in range(len0)]
    l0 = sorted(l0)
    l1 = [random.randint(0,100) for _ in range(len1)]
    l1 = sorted(l1)

    tt(l0,l1)
