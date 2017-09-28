# I think using Red Black tree would be more general
# This algo clone https://discuss.leetcode.com/topic/31288/c-o-nlogn-time-o-n-space-mergesort-solution-with-detail-explanation

class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if len(nums) == 0:
            return []

        result_ic_list = self._countSmaller_dfs(nums,0,len(nums))
        
        result_list = [0] * len(nums)
        for i,c in result_ic_list:
            result_list[i] = c
        
        return result_list

    def _countSmaller_dfs(self, nums, x0, x1):
        
        if x1-x0==1:
            return [(x0,0)]
        
        mid = int((x0+x1)/2)
        left_ic_list = self._countSmaller_dfs(nums,x0,mid)
        right_ic_list = self._countSmaller_dfs(nums,mid,x1)
        
        result_ic_list = []
        lptr = 0
        rptr = 0
        
        while(True):
            if lptr == len(left_ic_list) and rptr == len(right_ic_list):
                break
            elif lptr == len(left_ic_list):
                result_ic_list.append(right_ic_list[rptr])
                rptr+=1
            elif rptr == len(right_ic_list):
                left_i, left_c = left_ic_list[lptr]
                lptr+=1
                result_ic_list.append((left_i,left_c+rptr+1))
            elif nums[rptr] < nums[lptr]:
                result_ic_list.append(right_ic_list[rptr])
                rptr+=1
            else:
                left_i, left_c = left_ic_list[lptr]
                lptr+=1
                result_ic_list.append((left_i,left_c+rptr+1))

        return result_ic_list
        