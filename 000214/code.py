def create_kmp_table(s):
    
    kmp_table = [-1] * len(s)
    
    cur = 0
    for i in range(1,len(s)):
        if s[i] == s[cur]:
            kmp_table[i] = kmp_table[cur]
        else:
            kmp_table[i] = cur
            while (cur>=0) and (s[i]!=s[cur]):
                cur = kmp_table[cur]
        cur += 1
    
    return kmp_table

class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        kmp_table = create_kmp_table(s)
        
        # create reverse of s
        s_rev = ''.join(reversed(s))
        
        # use kmp to find longest palindrome in left of s
        # cur_done become the palindrome length
        cur_done = 0
        for i in range(len(s_rev)):
            s_rev_c = s_rev[i]
            while (cur_done >= 0) and (s_rev_c != s[cur_done]):
                cur_done = kmp_table[cur_done]
            cur_done += 1

        # num of char need to append to left of s
        char_add_count = len(s) - cur_done
    
        # append str to create shortest palindrome
        result = s_rev[:char_add_count] + s
        
        return result
