# LTE
# give up, need balanced sorted set to continue

from collections import deque

class Solution(object):
    def getSkyline(self, buildings):
        """
        :type buildings: List[List[int]]
        :rtype: List[List[int]]
        """
        result_queue = deque()
        
        huv_sortedset = SortedSet()
        done_x = None
        last_result_h = 0
        
        for uvh in buildings:
            u,v,h = tuple(uvh)
            huv = h,u,v

            if len(huv_sortedset) == 0:
                done_x = u
                huv_sortedset.add(huv)
                continue
            
            # u >= done_x
            
            if u == done_x:
                huv_sortedset.add(huv)
                continue
            
            # u > done_x
            
            while(True):
                if len(huv_sortedset) == 0:
                    if last_result_h != 0:
                        result_queue.append([done_x, 0])
                        last_result_h = 0
                    break
                
                top_huv = huv_sortedset.get_max()
                if top_huv[2] <= done_x:
                    huv_sortedset.pop_max()
                    continue
                if top_huv[0] != last_result_h:
                    result_queue.append([done_x, top_huv[0]])
                    last_result_h = top_huv[0] 
                done_x = min(u, top_huv[2])
                if done_x == u:
                    break

            done_x = u
            huv_sortedset.add(huv)

        while(len(huv_sortedset) > 0):
            top_huv = huv_sortedset.get_max()
            if top_huv[2] <= done_x:
                huv_sortedset.pop_max()
                continue
            if top_huv[0] != last_result_h:
                result_queue.append([done_x, top_huv[0]])
                last_result_h = top_huv[0] 
            done_x = top_huv[2]
        
        if last_result_h != 0:
            result_queue.append([done_x, 0])
            last_result_h = 0
        
        return list(result_queue)

class SortedSet(object):
    
    def __init__(self):
        self.root = None
        self._len = 0
    
    def add(self,v):
        if self.root == None:
            self.root = SSNode(None, v)
        else:
            p = self.root
            while(True):
                if v < p.v:
                    if p.left == None:
                        p.left = SSNode(p, v)
                        break
                    else:
                        p = p.left
                else:
                    if p.right == None:
                        p.right = SSNode(p,v)
                        break
                    else:
                        p = p.right
        self._len += 1
    
    def get_min(self):
        if self.root == None:
            return None
        p = self.root
        while(p.left != None):
            p = p.left
        return p.v

    def pop_min(self):
        if self.root == None:
            return None
        p = self.root
        while(p.left != None):
            p = p.left
        v = p.v
        pp = p.parent
        right = p.right
        if pp is not None:
            pp.left = right
        else:
            self.root = right
        if right is not None:
            right.parent = pp
        self._len -= 1
        return v

    def get_max(self):
        if self.root == None:
            return None
        p = self.root
        while(p.right != None):
            p = p.right
        return p.v

    def pop_max(self):
        if self.root == None:
            return None
        p = self.root
        while(p.right != None):
            p = p.right
        v = p.v
        pp = p.parent
        left = p.left
        if pp is not None:
            pp.right = left
        else:
            self.root = left
        if left is not None:
            left.parent = pp
        self._len -= 1
        return v
    
    def __len__(self):
        return self._len

class SSNode(object):
    
    def __init__(self, p, v):
        self.v = v
        self.parent = p
        self.left = None
        self.right = None
