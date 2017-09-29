class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        result = []

        while len(s) > 0:
            remain_char_set = set(s)

            # find max x1 which set(s[x1:]) == remain_char_set
            right_char_set = set()
            for x in reversed(range(len(s))):
                right_char_set.add(s[x])
                if len(right_char_set) >= len(remain_char_set):
                    break
            x1 = x

            min_char = min(s[:x1+1])
            min_char_x = s.find(min_char)
            result.append(min_char)
            s = s[min_char_x+1:]
            s = s.replace(min_char,'')

        return ''.join(result)
