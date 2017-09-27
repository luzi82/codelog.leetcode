from collections import deque
import heapq

class Solution(object):
    def getSkyline(self, buildings):
        """
        :type buildings: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(buildings) == 0:
            return []
        
        # convert buildlings(uvh) to shuv list
        shuv_list = [ (-b[2], b[2], b[0], b[1]) for b in buildings ]
        
        # append (uv=max_v+1,h=-1) at end, for easy cal at last
        max_v = max([shuv[3] for shuv in shuv_list])
        shuv_list += [(1,-1,max_v+1,max_v+1)]
        
        result_queue = deque()
        
        shuv_heap = []
        done_x = None
        last_result_h = 0
        
        for shuv in shuv_list:
            #print(done_x,shuv,sorted(shuv_heap))
            _,h,u,v = shuv

            if len(shuv_heap) == 0:
                done_x = u
                heapq.heappush(shuv_heap,shuv)
                continue
            
            # u >= done_x
            
            if u == done_x:
                heapq.heappush(shuv_heap,shuv)
                continue
            
            # u > done_x
            
            while(True):
                if len(shuv_heap) == 0:
                    if last_result_h != 0:
                        result_queue.append([done_x, 0])
                        last_result_h = 0
                    break
                
                top_shuv = shuv_heap[0]
                #print(top_shuv)
                if top_shuv[3] <= done_x:
                    heapq.heappop(shuv_heap)
                    continue
                if top_shuv[1] != last_result_h:
                    #print('output {}'.format(top_shuv))
                    result_queue.append([done_x, top_shuv[1]])
                    last_result_h = top_shuv[1] 
                done_x = min(u, top_shuv[3])
                if done_x == u:
                    break

            done_x = u
            heapq.heappush(shuv_heap,shuv)

        return list(result_queue)
