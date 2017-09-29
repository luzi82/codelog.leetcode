class Solution(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        done = 0 # [1,done] all solved
        nums_used = 0
        
        num_patched = 0
        
        while done < n:
            if nums_used < len(nums):
                next_num = nums[nums_used]
                if next_num <= done+1:
                    done += next_num
                    nums_used += 1
                    continue
            
            # greedy, when [1,done] all solved, patch value (done+1)
            # so [1,done + (done+1)] all solved
            done += (done+1)
            num_patched += 1
        
        return num_patched
