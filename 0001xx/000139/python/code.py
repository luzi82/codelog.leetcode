class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        
        word_set = set(wordDict)
        word_len_set = set([len(word) for word in wordDict])
        
        # good: space-separated sequence exist in s[0:i]
        good_list = [False] * (len(s)+1)
        
        good_list[0] = True
        
        for i in range(len(s)):
            if not good_list[i]:
                continue
            for word_len in word_len_set:
                if i+word_len > len(s):
                    continue
                if good_list[i+word_len]:
                    continue
                sub_s = s[i:i+word_len]
                if sub_s in word_set:
                    good_list[i+word_len] = True
        
        return good_list[len(s)]
        