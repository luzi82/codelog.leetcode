from collections import deque

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        
        word_set = set(wordDict)
        word_len_set = set([len(word) for word in wordDict])
        
        # backtrace: set of (j, w), j: last idx, w: word
        backtrace_set_list = [set() for _ in range(len(s)+1)]
        
        backtrace_set_list[0].add((None,None))
        
        for i in range(len(s)):
            if len(backtrace_set_list[i]) <= 0:
                continue
            for word_len in word_len_set:
                if i+word_len > len(s):
                    continue
                sub_s = s[i:i+word_len]
                if sub_s in word_set:
                    backtrace_set_list[i+word_len].add((i,sub_s))

        if len(backtrace_set_list[len(s)]) <= 0:
            return []
            
        ans_queue = deque()
        postfix_queue = deque()
        
        self.do_backtrace(backtrace_set_list,len(s),postfix_queue,ans_queue)
        
        return list(ans_queue)
        
    def do_backtrace(self,backtrace_set_list,j,postfix_queue,ans_queue):
        if j == 0:
            ans_queue.append(' '.join(postfix_queue))
            return
    
        backtrace_set = backtrace_set_list[j]
        
        for i, w in backtrace_set:
            postfix_queue.appendleft(w)
            self.do_backtrace(backtrace_set_list,i,postfix_queue,ans_queue)
            postfix_queue.popleft()
