from typing import List
import collections
import math

BIG = 10**9 + 7

class Solution:
    def maxProductPath(self, grid: List[List[int]]) -> int:
        north_data_list = None
        for num_list in grid:
            data_list = []
            for i in range(len(num_list)):
                num = num_list[i]
                north_data = north_data_list[i] if north_data_list is not None else None
                west_data = data_list[i-1] if i > 0 else None
                data = {}
                if (north_data is None) and (west_data is None):
                    data['MAX'] = num
                    data['MIN'] = num
                    data['ZERO'] = (num==0)
                elif (north_data is None):
                    data['MAX'] = west_data['MAX'] * num
                    data['MIN'] = west_data['MIN'] * num
                    data['ZERO'] = west_data['ZERO'] or (num==0)
                elif (west_data is None):
                    data['MAX'] = north_data['MAX'] * num
                    data['MIN'] = north_data['MIN'] * num
                    data['ZERO'] = north_data['ZERO'] or (num==0)
                else:
                    data['MAX'] = max(west_data['MAX'] * num,north_data['MAX'] * num,west_data['MIN'] * num,north_data['MIN'] * num)
                    data['MIN'] = min(west_data['MAX'] * num,north_data['MAX'] * num,west_data['MIN'] * num,north_data['MIN'] * num)
                    data['ZERO'] = west_data['ZERO'] or north_data['ZERO'] or (num==0)
                data_list.append(data)
            north_data_list = data_list
        
        data = north_data_list[-1]
        if data['MAX'] > 0: return data['MAX'] % BIG
        if data['ZERO']: return 0
        return -1
