import code
import random

def tt(nums):
    print(nums)
    xx = code.Solution()
    vv = xx.findPeakElement(nums)
    print(vv)
    assert((vv==0) or (nums[vv-1]<nums[vv]) )
    assert((vv==len(nums)-1) or (nums[vv]>nums[vv+1]) )

    
tt([1, 2, 3, 1])
tt([1])
tt([1, 2, 3])
tt([3, 2, 1])

for _ in range(100):
    llen = random.randint(2,100)
    nums = list(range(1000))
    random.shuffle(nums)
    nums = nums[:llen]
    tt(nums)
