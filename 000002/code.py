# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#from common import ListNode

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        p1 = l1
        p2 = l2

        l3 = None
        p3 = None
        carry = 0
        
        while(True):
            if (p1 is None) and (p2 is None) and (carry == 0):
                break
            v1 = p1.val if p1 is not None else 0
            v2 = p2.val if p2 is not None else 0
            v3 = v1+v2+carry

            carry = int(v3/10)
            v3 = v3%10
            
            if l3 is None:
                l3 = ListNode(v3)
                p3 = l3
            else:
                p3.next = ListNode(v3)
                p3 = p3.next
            
            p1 = p1.next if p1 is not None else None
            p2 = p2.next if p2 is not None else None

        return l3
