class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        if len(s) == 0:
            return 0
        if k == 0:
            return 0
        
        self.left_char_count_dict = {} # char: count

        result = 0
        left_ptr = 0

        for right_ptr in range(len(s)):
            self.add_char(s[right_ptr])
            while len(self.left_char_count_dict) > k:
                self.remove_char(s[left_ptr])
                left_ptr+=1
            result = max(result, right_ptr-left_ptr+1)
            
        return result

    def add_char(self, c):
        if c in self.left_char_count_dict:
            self.left_char_count_dict[c] += 1
        else:
            self.left_char_count_dict[c] = 1

    def remove_char(self, c):
        v = self.left_char_count_dict[c]
        v -= 1
        if v == 0:
            del self.left_char_count_dict[c]
        else:
            self.left_char_count_dict[c] = v
