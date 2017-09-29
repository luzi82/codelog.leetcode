import code
import random

for _ in range(100):
    k = random.randint(1,10)
    nums_len = random.randint(k,k+30)
    
    nums = [ random.randint(0,9) for _ in range(nums_len) ]

    solution = code.Solution()
    result = solution.maxSlidingWindow(nums, k)
    expect = [ max(nums[i:i+k]) for i in range(nums_len-k+1) ]
    
    print(nums, k)
    print(expect, result)
    
    assert(result == expect)
