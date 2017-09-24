import code
import random
import itertools
import copy

def tt(nums,v):
    print(nums,v)
    xx = code.Solution()
    vv = copy.copy(nums)
    xx.nextPermutation(vv)
    print(vv)
    assert(vv==v)

    
tt([],[])
tt([1],[1])
tt([1,2],[2,1])
tt([2,1],[1,2])

for _ in range(10):
    
    ll = [random.randint(0,9) for _ in range(7)]
    ll = itertools.permutations(ll)
    ll = set(ll)
    ll = list(sorted(ll))
    ll = [list(i) for i in ll]
    
    for i in range(len(ll)):
        j = (i+1)%len(ll)
        tt(ll[i],ll[j])
