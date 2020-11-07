from typing import List
import collections
import math

ORD_0 = ord('0')

class Solution:
    def minInteger(self, num: str, k: int) -> str:
        digit_count_list = [0 for _ in range(10)]
        digit_pos_gtcount_list_list = [[] for _ in range(10)]
        for pos in range(len(num)):
            c = num[pos]
            d = ord(c)-ORD_0
            gtcount = sum(digit_count_list[d+1:])
            digit_pos_gtcount_list_list[d].append((pos, gtcount))
            digit_count_list[d] += 1

        # print(f'digit_pos_gtcount_list_list={digit_pos_gtcount_list_list}')

        digit_pos_gtcount_offset_list = [0 for _ in range(10)]
        digit_done_count_list = [0 for _ in range(10)]

        ret = []
        while len(ret) < len(num):
            # print(f'digit_pos_gtcount_offset_list={digit_pos_gtcount_offset_list}')
            # print(f'digit_done_count_list={digit_done_count_list}')
            # print(f'k={k}')
            d = None
            cost = None
            for _d in range(10):
                offset = digit_pos_gtcount_offset_list[_d]
                if offset >= len(digit_pos_gtcount_list_list[_d]): continue
                pos, gtcount = digit_pos_gtcount_list_list[_d][offset]
                donegtcount = sum(digit_done_count_list[_d+1:])
                _cost = gtcount - donegtcount
                if _cost <= k:
                    d, cost = _d, _cost
                    digit_pos_gtcount_offset_list[d] += 1
                    digit_done_count_list[d] += 1
                    break
            
            k -= cost
            c = chr(d+ORD_0)
            ret.append(c)

        ret = ''.join(ret)
        return ret

