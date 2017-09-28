import code
import random
from common import ListNode

def test_ss():
    ss = code.SortedSet()
    mirror = []
    for _ in range(10000):
        action_list = []
        if len(mirror) > 0:
            action_list.append('pop_min')
        if len(mirror) > 10:
            action_list.append('pop_min')
        if len(mirror) < 100:
            action_list.append('add')
        action = random.choice(action_list)
        if action == 'add':
            v = random.randint(0,100)
            mirror.append(v)
            ss.add(v)
        elif action == 'pop_min':
            v = ss.pop_min()
            vv = min(mirror)
            mirror.remove(vv)
            assert(v==vv)
        print mirror
        assert(len(mirror)==ss.llen())

#test_ss()

def tt(v_list_list,ans):
    print(v_list_list,ans)
    
    lists = []
    for v_list in v_list_list:
        p = None
        for v in reversed(v_list):
            pp = ListNode(v)
            pp.next = p
            p = pp
        lists.append(p)
    
    xx = code.Solution()
    vv = xx.mergeKLists(lists)
    
    vvl = []
    while(vv is not None):
        vvl.append(vv.val)
        vv = vv.next

    print(vvl)
    
#    assert(len(vvl)==len(an))
#    
#    for i in range(len(vvl)):
#        assert(vvl[i]==v[i])
    
    assert(vvl == ans)

tt([],[])
tt([[]],[])
tt([[],[]],[])

for _ in range(100):
    v_list_list_len = random.randint(1,10)
    v_list_list = []
    for _ in range(v_list_list_len):
        v_list_len = random.randint(0,10)
        v_list = [random.randint(0,100) for _ in range(v_list_len)]
        v_list = list(sorted(v_list))
        v_list_list.append(v_list)
    vv_list = []
    for v_list in v_list_list:
        vv_list += v_list
    vv_list = list(sorted(vv_list))
    tt(v_list_list,vv_list)
