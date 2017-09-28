import code
import random

def tt(n,t):
    print(n,t)
    xx = code.Solution()
    vv = xx.longestConsecutive(n)
    print(vv)
    assert(vv==t)

    
tt([100, 4, 200, 1, 3, 2],4)
tt([],0)

for _ in range(100):
    
    llen = random.randint(1,100)
    n_list = [random.randint(0,99) for _ in range(llen)]
    
    b_list = [False]*100
    for n in n_list:
        b_list[n] = True
        
    max_v = 0
    v = 0
    
    for b in b_list:
        if b:
            v+=1
            max_v = max(max_v,v)
        else:
            v=0
    
    tt(n_list,max_v)
