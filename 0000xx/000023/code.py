# https://leetcode.com/problems/merge-k-sorted-lists/description/

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#from common import ListNode

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
    
    def llen(self):
        return self._len

class SSNode(object):
    
    def __init__(self, p, v):
        self.v = v
        self.parent = p
        self.left = None
        self.right = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        sorted_set = SortedSet()
        p_list = [i for i in lists]
        
        for i in range(len(lists)):
            p = p_list[i]
            if p != None:
                sorted_set.add((p.val,i))
                p_list[i] = p.next

        ret = ListNode(None)
        ptr = ret

        while(sorted_set.llen()>0):
            mmin = sorted_set.pop_min()
            v = mmin[0]
            pi = mmin[1]
            
            ptr.next = ListNode(v)
            ptr = ptr.next
            
            new_n = p_list[pi]
            if new_n is not None:
                sorted_set.add((new_n.val,pi))
                p_list[pi] = new_n.next
        
        ret = ret.next
        return ret
