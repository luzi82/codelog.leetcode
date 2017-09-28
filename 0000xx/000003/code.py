class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        
        left_set = set()

        best_len = 0
        
        left = 0
        right = 0
        
        while(right < len(s)):
            cr = s[right]
            right += 1
            
            if cr in left_set:
                while(True):
                    cl = s[left]
                    left_set.remove(cl)
                    left += 1
                    if cl==cr:
                        break
            
            my_len = right-left
            if my_len > best_len:
                best_len = my_len
            
            left_set.add(cr)

        return best_len
