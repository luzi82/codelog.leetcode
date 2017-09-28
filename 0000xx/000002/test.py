from common import ListNode
import code

def num2ln(v):
    if v == 0:
        return ListNode(0)
    ret = None
    ptr = None
    while v > 0:
        vv = v%10
        if ret==None:
            ret = ListNode(vv)
            ptr = ret
        else:
            ptr.next = ListNode(vv)
            ptr = ptr.next
        v = int(v/10)
    return ret

def ln2num(l):
    v10 = 1
    ptr = l
    ret = 0
    while ptr is not None:
        ret += v10 * ptr.val
        ptr = ptr.next
        v10 *= 10
        #print(ret)
    return ret

def checkL(l):
    ptr = l
    while ptr is not None:
        assert(ptr.val>=0)
        assert(ptr.val<10)
        ptr = ptr.next

def tt(a,b):
    print(a,b)
    
    l1 = num2ln(a)
    l2 = num2ln(b)
    xx = code.Solution()
    l3 = xx.addTwoNumbers(l1,l2)
    
    checkL(l3)
    v3 = ln2num(l3)
    #print(v3)
    
    assert(a+b==v3)

    
tt(123,321)
tt(342,465)
tt(0,0)

for aa in range(1000):
    for bb in range(1000):
        tt(aa,bb)
