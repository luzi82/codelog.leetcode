from collections import deque

def to_token_list(s):
    # token type:
    #  ( , )
    #  + , - , *
    #  num
    
    result_queue = deque()
    
    last_num = None
    
    for c in s:
        if c in '()+-*':
            if last_num is not None:
                result_queue.append(last_num)
                last_num = None
            result_queue.append(c)
        elif c == ' ':
            if last_num is not None:
                result_queue.append(last_num)
                last_num = None
        else:
            if last_num is None:
                last_num = 0
            last_num *= 10
            last_num += int(c)
     
    if last_num is not None:
        result_queue.append(last_num)
        last_num = None
     
    return list(result_queue)

class Solution(object):

    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        token_list = to_token_list(s)
        
        result = 0

        last_token = None
        state_factor = 1
        state_factor_stack = deque()

        for token in token_list:
          if type(token).__name__ == 'int':
            factor = state_factor
            if last_token == '-':
              factor = factor * -1
            result += token * factor
          elif token == '(':
            state_factor_stack.append(state_factor)
            if last_token == '-':
              state_factor = state_factor * -1
          elif token == ')':
            state_factor = state_factor_stack.pop()
            
          last_token = token

        return result
