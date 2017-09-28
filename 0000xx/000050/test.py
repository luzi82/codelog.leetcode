import code
import random
import math

def tt(x, n, v):
    print(x, n, v)
    xx = code.Solution()
    vv = xx.myPow(x,n)
    print(vv)
    assert(abs((vv-v)/v)<0.000001)

tt(3, 5, 3*3*3*3*3)

for _ in range(1000):
    x = (random.random() - 0.5)*3
    n = random.randint(-20,20)
    
    v = math.pow(x, n)
    tt(x,n,v)
