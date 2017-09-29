from collections import deque

def create_kmp_table(s):
    
    kmp_table = [-1] * (len(s)+1)
    
    cur = 0
    for i in range(1,len(s)):
        if s[i] == s[cur]:
            #kmp_table[i] = kmp_table[cur]
            kmp_table[i] = cur # fix ["a","aa","aaa"] case
        else:
            kmp_table[i] = cur
            while (cur>=0) and (s[i]!=s[cur]):
                cur = kmp_table[cur]
        cur += 1

    kmp_table[len(s)] = cur
    
    return kmp_table

class Solution(object):
    def palindromePairs(self, words):
        """
        :type words: List[str]
        :rtype: List[List[int]]
        """
        word_dict = { words[i]:i for i in range(len(words)) }
        
        result_queue = deque()
        
        for word_i in range(len(words)):
            word = words[word_i]
            word_rev = ''.join(reversed(word))
            
            #dd ('> '+word)

            # deal with word + word_rev first
            if word_rev in word_dict:
                word_rev_i = word_dict[word_rev]
                if word_i != word_rev_i:
                    result_queue.append([word_dict[word_rev], word_i])
            
            # xx + word, left palindrome
            # eg. word = 'abad', word_rev = 'daba'
            # use kmp to find right palindrome of word_rev
            
            kmp_table = create_kmp_table(word)
            
            most_match_len = 0
            for i in range(len(word_rev)):
                word_rev_c = word_rev[i]
                while (most_match_len >= 0) and (word_rev_c != word[most_match_len]):
                    most_match_len = kmp_table[most_match_len]
                most_match_len += 1
            
            #dd (kmp_table)
            #dd ('most_match_len {}'.format(most_match_len))
            
            # 3(aba-d) > 1(a-bad) > 0(-abad) > -1
            # 0 is same str, so ignore
            match_len = most_match_len
            while ( match_len > 0 ):
                #dd(match_len)
                prefix = word_rev[:len(word)-match_len]
                #dd('prefix {}'.format(prefix))
                if prefix in word_dict:
                    result_queue.append([word_dict[prefix],word_i])
                match_len = kmp_table[match_len]
            
            # word + xx, right palindrome
            # eg. word = 'daba', word_rev = 'abad'
            # find right palindrome of word
            # aka, use word_rev to find most match len in right of word
            
            kmp_table = create_kmp_table(word_rev)
            
            most_match_len = 0
            for i in range(len(word)):
                c = word[i]
                while (most_match_len >= 0) and (c != word_rev[most_match_len]):
                    most_match_len = kmp_table[most_match_len]
                most_match_len += 1

            #dd ('most_match_len {}'.format(most_match_len))
            #dd (kmp_table)
            
            # 3(d{aba}) > 1(dab{a}) > 0(daba{}) > -1
            # 0 is same str, so ignore
            match_len = most_match_len
            while ( match_len > 0 ):
                postfix = word_rev[match_len:]
                #dd('postfix {}'.format(postfix))
                if postfix in word_dict:
                    result_queue.append([word_i,word_dict[postfix]])
                match_len = kmp_table[match_len]

        return list(result_queue)
