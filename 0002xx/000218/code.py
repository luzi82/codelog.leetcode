from collections import deque
import heapq

class Solution(object):
    def getSkyline(self, buildings):
        """
        :type buildings: List[List[int]]
        :rtype: List[List[int]]
        """
        # special handle edge case
        if len(buildings) == 0:
            return []
        
        # u: start of building
        # v: end of building
        # h: height of building
        # s: -h, sort key in heap, higher h pop earlier
        # uvh: [u,v,h], buildings input format
        # suvh: [s,u,v,h], calculation format

        # convert buildlings(uvh) to suvh list
        suvh_list = [ ((-uvh[2],)+ tuple(uvh)) for uvh in buildings ]
        
        # append (uv=max_v+1,h=0) at end, for easy calc at last
        max_v = max([suvh[2] for suvh in suvh_list])
        suvh_list += [(0,max_v+1,max_v+1,0)]
        
        # output stuff
        result_queue = deque()
        
        # loop stuff
        
        done_x = None # cursor
        suvh_heap = [] # store suvh, which u <= done_x

        for suvh in suvh_list:
            #print(done_x,suvh,sorted(suvh_heap))
            _,u,v,h = suvh

            if len(suvh_heap) == 0:
                done_x = u
                heapq.heappush(suvh_heap,suvh)
                continue
            
            # u >= done_x
            
            if u == done_x:
                heapq.heappush(suvh_heap,suvh)
                continue
            
            # u > done_x
            
            # find all skyline in [done_x,u), burn suvh_heap
            while(done_x < u):
                if len(suvh_heap) == 0:
                    # no building in [done_x,u)
                    result_queue.append([done_x,0])
                    done_x = u
                    break
                
                _,top_u,top_v,top_h = suvh_heap[0]

                # skip passed building
                if top_v <= done_x:
                    heapq.heappop(suvh_heap)
                    continue

                result_queue.append([done_x, top_h])
                done_x = min(u, top_v)

            done_x = u
            heapq.heappush(suvh_heap,suvh)

        # remove all point x > max_v
        # remove all point h[x]=h[x-1]
        result_list = []
        last_h = 0
        for xh in result_queue:
            x,h = tuple(xh)
            if x > max_v:
                continue
            if h == last_h:
                continue
            result_list.append(xh)
            last_h = h

        return result_list
