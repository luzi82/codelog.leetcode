class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ij_dict = {}
        ji_dict = {}
        n_set = set()
        
        for n in nums:
            if n in n_set:
                continue
            n_set.add(n)
            
            left_exist = n-1 in ji_dict
            right_exist = n+1 in ij_dict
            
            if left_exist and right_exist:
                left = ji_dict[n-1]
                del ij_dict[left]
                del ji_dict[n-1]

                right = ij_dict[n+1]
                del ij_dict[n+1]
                del ji_dict[right]

                ij_dict[left] = right
                ji_dict[right] = left

            elif left_exist:
                left = ji_dict[n-1]
                del ij_dict[left]
                del ji_dict[n-1]

                right = n

                ij_dict[left] = right
                ji_dict[right] = left

            elif right_exist:
                left = n

                right = ij_dict[n+1]
                del ij_dict[n+1]
                del ji_dict[right]

                ij_dict[left] = right
                ji_dict[right] = left
            else:
                ij_dict[n] = n
                ji_dict[n] = n
            
            #print(ij_dict)
            #print(ji_dict)

        ret = 0
        for k,v in ij_dict.items():
            ret = max(ret,v-k+1)
        
        return ret
