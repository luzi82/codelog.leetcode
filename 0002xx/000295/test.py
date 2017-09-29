import code
import random

for _ in range(100):

    median_finder = code.MedianFinder()
    mirror = []
    
    for _ in range(100):
        v = random.randint(0,99)
        median_finder.addNum(v)
        mirror.append(v)
        
        mid_result = median_finder.findMedian()
        
        mirror = sorted(mirror)
        if len(mirror)%2 == 1:
            mid_expected = mirror[len(mirror)//2]
        else:
            mid_expected = (mirror[len(mirror)//2] + mirror[(len(mirror)//2)-1])/2.0
        
        print(mid_expected,mid_result)
        
        assert(mid_result == mid_expected)
