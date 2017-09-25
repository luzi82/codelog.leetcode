class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 0
        
        i = -1 # nums[i] < nums[i+1]
        j = len(nums)-1 # nums[j] > nums[j+1]

        while (j-i) > 1:
            m0 = (i+j)//2
            m1 = m0+1
            if nums[m0]<nums[m1]:
                i = m0
            else:
                j = m0

        return j
        