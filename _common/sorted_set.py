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

def test():
    import random
    ss = SortedSet()
    mirror = []
    for _ in range(10000):
        action_list = []
        if len(mirror) > 0:
            action_list.append('pop_min')
            action_list.append('pop_max')
        if len(mirror) > 30:
            action_list.append('pop_min')
            action_list.append('pop_max')
        if len(mirror) < 100:
            action_list.append('add')
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
        elif action == 'pop_max':
            v = ss.pop_max()
            vv = max(mirror)
            mirror.remove(vv)
            assert(v==vv)
        else:
            assert(False)
        print mirror
        assert(len(mirror)==len(ss))

if __name__ == "__main__":
    test()
