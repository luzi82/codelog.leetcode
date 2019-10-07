from typing import List

class Solution:
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        t_list = []
        for transaction in transactions:
            t = transaction.split(',')
            t = [t[0],int(t[1]),int(t[2]),t[3]]
            t_list.append(t)
        
        name_to_t_list_dict = {}
        for t in t_list:
            name,time,money,place = t
            name_to_t_list_dict[name] = []
        
        for t in t_list:
            name,time,money,place = t
            name_to_t_list_dict[name].append(t)
        
        ret_list = []
        for i in range(len(t_list)):
            t = t_list[i]
            name,time,money,place = t
            good = True
            good = good and money <= 1000
            if good:
                tt_list = name_to_t_list_dict[name]
                for tt in tt_list:
                    name0,time0,money0,place0 = tt
                    if place == place0: continue
                    if abs(time0-time) <= 60:
                        good = False
                        break
            if not good:
                ret_list.append(transactions[i])
        
        return ret_list
