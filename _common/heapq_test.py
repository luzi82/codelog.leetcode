import heapq

# heapq.heappush(heap,v)
# heapq.heappop(heap)

def test():
    import random
    heap = []
    mirror = []
    for _ in range(10000):
        action_list = []
        if len(mirror) > 0:
            action_list.append('pop_min')
        if len(mirror) > 30:
            action_list.append('pop_min')
        if len(mirror) < 100:
            action_list.append('add')
        action = random.choice(action_list)
        if action == 'add':
            v = random.randint(0,100)
            mirror.append(v)
            heapq.heappush(heap,v)
        elif action == 'pop_min':
            v = heapq.heappop(heap)
            vv = min(mirror)
            mirror.remove(vv)
            assert(v==vv)
        else:
            assert(False)
        print(mirror)
        if len(mirror)>0:
            assert(min(mirror)==heap[0])
        print(heap)
        #assert(len(mirror)==len(ss))

if __name__ == "__main__":
    test()
