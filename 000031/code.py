class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        # find b
        b = -1
        for i in reversed(range(len(nums)-1)):
            j = i+1
            if nums[i] < nums[j]:
                b = i
                break
        
        if b >= 0:
            # find c0
            c0 = None
            for i in reversed(range(len(nums))):
                if nums[i] > nums[b]:
                    c0 = i
                    break
            
            assert(c0 is not None)
            
            # b <-> c0
            t = nums[c0]
            nums[c0] = nums[b]
            nums[b] = t
        
        # reverse all
        i = b+1
        j = len(nums)-1
        
        while(i<j):
            t = nums[i]
            nums[i] = nums[j]
            nums[j] = t
            i+=1
            j-=1
