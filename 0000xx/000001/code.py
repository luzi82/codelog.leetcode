class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        i = 0
        left = {}
        
        for i in range(len(nums)):
            v = nums[i]
            if target-v in left:
                return [left[target-v],i]
            left[v] = i
